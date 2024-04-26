package sistema.database.template;

import sistema.database.connection.ConexaoMySQL;
import sistema.database.model.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sistema.database.model.*;

public class TemplateMySQL {
    public ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
    public JdbcTemplate templateMySQl = conexaoMySQL.getConexaoBanco();

    public TemplateMySQL() {
    }

    public Integer pegarIdBancoMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from banco order by idBanco desc limit 1
                    """, new BeanPropertyRowMapper<>(BancoModel.class)).getIdBanco();
    }

    public Integer pegarIdAtmMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from atm order by idAtm desc limit 1
                    """, new BeanPropertyRowMapper<>(AtmModel.class)).getIdAtm();
    }

    public Integer pegarIdProcessadorMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from processador order by idProcessador desc limit 1
                    """, new BeanPropertyRowMapper<>(ProcessadorModel.class)).getIdProcessador();
    }

    public Integer pegarIdMemoriaMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from memoria order by idMemoria desc limit 1
                    """, new BeanPropertyRowMapper<>(MemoriaModel.class)).getIdMemoria();
    }

    public Integer pegarIdDiscoMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from disco order by idDisco desc limit 1
                    """, new BeanPropertyRowMapper<>(DiscoModel.class)).getIdDisco();
    }

    public Integer pegarIdRegistroMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from registro order by idRegistro desc limit 1
                    """, new BeanPropertyRowMapper<>(RegistroModel.class)).getIdRegistro();
    }

    public JdbcTemplate getTemplateMySQl() {
        return templateMySQl;
    }
}
