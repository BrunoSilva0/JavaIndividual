package sistema.database.service;

import sistema.database.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;

import java.util.List;

public class DispositivoUsbService {
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();

    public DispositivosUsbGrupo pegarDispositivosUsbGrupoLooca() {
        return looca.getDispositivosUsbGrupo();
    }

    public List<DispositivoUsb> pegarListaDispositivoUsbLooca() {
        return pegarDispositivosUsbGrupoLooca().getDispositivosUsb();
    }

    public void inserirPegarNomeDispositivo() {
        for (int i = 0; i < pegarListaDispositivoUsbLooca().size(); i++) {
            String nomeDispositivo = pegarListaDispositivoUsbLooca().get(i).getNome();

            templateMySQL.getTemplateMySQl().update("""
                    insert into DispositivoUsb (nomeDispositivo, fkAtm) values (?, ?)
                    """, nomeDispositivo, templateMySQL.pegarIdAtmMaisRecente());
        }
    }
}
