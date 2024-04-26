package sistema.database.service;

import sistema.database.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.util.Conversor;

public class MemoriaService {
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();

    public Memoria pegarMemoriaLooca() {
        return looca.getMemoria();
    }

    public String pegarTamanhoTotalLooca() {
        Long tamanhoTotal = pegarMemoriaLooca().getTotal();
        return Conversor.formatarBytes(tamanhoTotal);
    }

    public void inserirDadosMemoria(){
        templateMySQL.getTemplateMySQl().update("""
                    insert into memoria (tamanhoTotal, fkAtm) values
                    (?, ?);
                """, pegarTamanhoTotalLooca(), templateMySQL.pegarIdAtmMaisRecente());
    }
}

