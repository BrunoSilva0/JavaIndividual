package sistema.database.service;

import sistema.database.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

import java.text.DecimalFormat;

public class RegistroService {
    Conversor conversor = new Conversor();
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();
    DecimalFormat formatarDecimal = new DecimalFormat("#.0");
    ProcessadorService processadorService = new ProcessadorService();
    MemoriaService memoriaService = new MemoriaService();
    DiscoService discoService = new DiscoService();

    public Double pegarUsoProcessador() {
        return processadorService.pegarProcessadorLooca().getUso();
    }

    public Long pegarUsoMemoria() {
        return memoriaService.pegarMemoriaLooca().getEmUso();
    }

    public Long pegarDisponivelMemoria() {
        return memoriaService.pegarMemoriaLooca().getDisponivel();
    }

    public Long pegarTotalMemoria() {
        return memoriaService.pegarMemoriaLooca().getTotal();
    }

    public Integer pegarQtdTotalProcessosLooca() {
        return looca.getGrupoDeProcessos().getTotalProcessos();
    }

    public String pegarPorcentagemUsoProcessador() {
        Double usoProcessador = pegarUsoProcessador() * 10.0;
        return formatarDecimal.format(usoProcessador);
    }

    public String pegarQtdUsoMemoria() {
        return Conversor.formatarBytes(pegarUsoMemoria());
    }

    public String pegarQtdDisponivelMemoria() {
        Long qtdDisponivelMemoriaBytes = pegarDisponivelMemoria();
        return Conversor.formatarBytes(qtdDisponivelMemoriaBytes);
    }

    public String pegarPorcentagemUsoMemoria() {
        Double porcentagemUsoMemoriaBytes = (pegarUsoMemoria() * 100.0) / pegarTotalMemoria();
        return formatarDecimal.format(porcentagemUsoMemoriaBytes);
    }

//    Faz insert do registro e também coleta os dados de Disco necessários
    public void inserirDadosRegistro() {
        for (int i = 0; i < discoService.pegarListaDiscoLooca().size(); i++) {
            Long qtdTotalDiscoBytes = discoService.pegarListaVolumeLooca().get(i).getTotal();
            Long qtdDisponivelDiscoBytes = discoService.pegarListaVolumeLooca().get(i).getDisponivel();
            Long qtdUsoDiscoBytes = qtdTotalDiscoBytes - qtdDisponivelDiscoBytes;
            Double porcentagemUsoDiscoBytes = (qtdUsoDiscoBytes * 100.0) / qtdTotalDiscoBytes;

            String qtdUsoDisco = Conversor.formatarBytes(qtdUsoDiscoBytes);
            String qtdDisponivelDisco = Conversor.formatarBytes(qtdDisponivelDiscoBytes);
            String porcentagemUsoDisco = formatarDecimal.format(porcentagemUsoDiscoBytes);

            templateMySQL.getTemplateMySQl().update("""
                    insert into registro
                    (
                        qtdTotalProcessos,
                        porcentagemUsoProcessador,
                        qtdUsoMemoria,
                        qtdDisponivelMemoria,
                        porcentagemUsoMemoria,
                        qtdUsoDisco,
                        qtdDisponivelDisco,
                        porcentagemUsoDisco,
                        fkProcessador,
                        fkMemoria,
                        fkDisco
                    )
                    values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """, pegarQtdTotalProcessosLooca(), pegarPorcentagemUsoProcessador(), pegarQtdUsoMemoria(),
                    pegarQtdDisponivelMemoria(), pegarPorcentagemUsoMemoria(), qtdUsoDisco, qtdDisponivelDisco,
                    porcentagemUsoDisco, templateMySQL.pegarIdProcessadorMaisRecente(), templateMySQL.pegarIdMemoriaMaisRecente(),
                    templateMySQL.pegarIdDiscoMaisRecente());
        }
    }
}
