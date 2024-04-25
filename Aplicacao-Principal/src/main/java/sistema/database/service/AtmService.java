package sistema.database.service;

import sistema.database.model.AtmModel;
import sistema.database.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class AtmService {
    Looca looca = new Looca();
    AtmModel atmModel = new AtmModel();
    TemplateMySQL templateMySQL = new TemplateMySQL();

    public Sistema pegarSistemaLooca() {
        return looca.getSistema();
    }

    public String pegarSistemaOperacionalLooca() {
        return pegarSistemaLooca().getSistemaOperacional();
    }

    public Integer pegarArquiteturaLooca() {
        return pegarSistemaLooca().getArquitetura();
    }

    public void inserirDadosAtm() {
        templateMySQL.getTemplateMySQl().update("""
                insert into Atm (sistemaOperacional, arquitetura, fkBanco) values (?, ?, ?)
                """, pegarSistemaOperacionalLooca(), pegarArquiteturaLooca(), templateMySQL.pegarIdBancoMaisRecente());
    }
}
