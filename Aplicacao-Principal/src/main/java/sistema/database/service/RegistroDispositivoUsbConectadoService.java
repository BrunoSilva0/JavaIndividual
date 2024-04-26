package sistema.database.service;

import sistema.database.model.DispositivoUsbModel;
import sistema.database.model.RegistroModel;
import sistema.database.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class RegistroDispositivoUsbConectadoService {
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();
    DispositivoUsbService dispositivoUsbService = new DispositivoUsbService();

    public List<DispositivoUsb> pegarListaDispositivoUsbConectadoLooca() {
        return looca.getDispositivosUsbGrupo().getDispositivosUsbConectados();
    }

//    Insere e coleta todos os dados necessários para a tabela
    public void inserirDadosRegistroUsb() {
        List<DispositivoUsb> listaDispositivoUsb = dispositivoUsbService.pegarListaDispositivoUsbLooca();
        Integer fkRegistro = 0;
        Integer fkDispositivoUsb = 0;

        for (int i = 0; i < pegarListaDispositivoUsbConectadoLooca().size(); i++) {
            String nomeDispositivoUsbConectado = pegarListaDispositivoUsbConectadoLooca().get(i).getNome();
            Boolean conectado = false;

            if (listaDispositivoUsb.get(i).getNome().equals(nomeDispositivoUsbConectado)) {
                conectado = true;
            }

            fkRegistro = templateMySQL.getTemplateMySQl().queryForObject("""
                select * from registro where idRegistro = ?;
                """, new BeanPropertyRowMapper<>(RegistroModel.class), templateMySQL.pegarIdRegistroMaisRecente()).getIdRegistro();

            fkDispositivoUsb = templateMySQL.getTemplateMySQl().queryForObject("""
                select * from dispositivousb where idDispositivoUsb = ?;
                """, new BeanPropertyRowMapper<>(DispositivoUsbModel.class), i+1).getIdDispositivoUsb();

            templateMySQL.getTemplateMySQl().update("""
                    insert into registroDispositivousbconectado (fkRegistro, fkDispositivoUsb, conectado) values (?, ?, ?)
                    """,fkRegistro, fkDispositivoUsb, conectado);
        }
    }
}
