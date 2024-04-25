package sistema.database.service;

import sistema.database.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.util.Conversor;

public class ProcessadorService {
    Conversor conversor = new Conversor();
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();

    public Processador pegarProcessadorLooca() {
        return looca.getProcessador();
    }

    public String pegarNomeProcessadorLooca() {
        String nomeProcessador = pegarProcessadorLooca().getNome();
        return nomeProcessador;
    }

    public String pegarModeloProcessadorLooca() {
        String modeloProcessador = pegarProcessadorLooca().getIdentificador();
        return modeloProcessador;
    }

    public String pegarFrequenciaProcessadorLooca() {
        Long frequenciaProcessadorBytes = pegarProcessadorLooca().getFrequencia();
        String frequenciaProcessador = conversor.formatarBytes(frequenciaProcessadorBytes);
        return frequenciaProcessador;
    }

    public Integer pegarQtdProcessadorFisicoLooca() {
        Integer qtdProcessadorFisico = looca.getProcessador().getNumeroCpusFisicas();
        return qtdProcessadorFisico;
    }

    public Integer pegarQtdProcessadorLogicoLooca() {
        Integer qtdProcessadorLogico = pegarProcessadorLooca().getNumeroCpusLogicas();
        return qtdProcessadorLogico;
    }

    public void inserirDadosProcessador() {
        templateMySQL.getTemplateMySQl().update("""
                insert into Processador (nomeProcessador, modeloProcessador, frequenciaProcessador,
                qtdProcessadorFisico, qtdProcessadorLogico, fkAtm) values
                (?, ?, ?, ?, ?, ?)
                """, pegarNomeProcessadorLooca(), pegarModeloProcessadorLooca(), pegarFrequenciaProcessadorLooca(), pegarQtdProcessadorFisicoLooca(), pegarQtdProcessadorLogicoLooca(), templateMySQL.pegarIdAtmMaisRecente());
    }
}
