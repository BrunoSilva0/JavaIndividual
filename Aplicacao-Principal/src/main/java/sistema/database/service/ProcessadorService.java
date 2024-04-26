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
        return pegarProcessadorLooca().getNome();
    }

    public String pegarModeloProcessadorLooca() {
        return pegarProcessadorLooca().getIdentificador();
    }

    public String pegarFrequenciaProcessadorLooca() {
        Long frequenciaProcessadorBytes = pegarProcessadorLooca().getFrequencia();
        return Conversor.formatarBytes(frequenciaProcessadorBytes);
    }

    public Integer pegarQtdProcessadorFisicoLooca() {
        return looca.getProcessador().getNumeroCpusFisicas();
    }

    public Integer pegarQtdProcessadorLogicoLooca() {
        return pegarProcessadorLooca().getNumeroCpusLogicas();
    }

    public void inserirDadosProcessador() {
        templateMySQL.getTemplateMySQl().update("""
                insert into processador (nomeProcessador, modeloProcessador, frequenciaProcessador,
                qtdProcessadorFisico, qtdProcessadorLogico, fkAtm) values
                (?, ?, ?, ?, ?, ?)
                """, pegarNomeProcessadorLooca(), pegarModeloProcessadorLooca(), pegarFrequenciaProcessadorLooca(), pegarQtdProcessadorFisicoLooca(), pegarQtdProcessadorLogicoLooca(), templateMySQL.pegarIdAtmMaisRecente());
    }
}
