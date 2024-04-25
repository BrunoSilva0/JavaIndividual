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
                    select * from Banco order by idBanco desc limit 1
                    """, new BeanPropertyRowMapper<>(BancoModel.class)).getIdBanco();
    }

    public Integer pegarIdAtmMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from Atm order by idAtm desc limit 1
                    """, new BeanPropertyRowMapper<>(AtmModel.class)).getIdAtm();
    }

    public Integer pegarIdProcessadorMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from Processador order by idProcessador desc limit 1
                    """, new BeanPropertyRowMapper<>(ProcessadorModel.class)).getIdProcessador();
    }

    public Integer pegarIdMemoriaMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from Memoria order by idMemoria desc limit 1
                    """, new BeanPropertyRowMapper<>(MemoriaModel.class)).getIdMemoria();
    }

    public Integer pegarIdDiscoMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from Disco order by idDisco desc limit 1
                    """, new BeanPropertyRowMapper<>(DiscoModel.class)).getIdDisco();
    }

    public Integer pegarIdRegistroMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from Registro order by idRegistro desc limit 1
                    """, new BeanPropertyRowMapper<>(RegistroModel.class)).getIdRegistro();
    }

    public JdbcTemplate getTemplateMySQl() {
        return templateMySQl;
    }
}
