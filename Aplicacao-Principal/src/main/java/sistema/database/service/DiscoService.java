package sistema.database.service;

import sistema.database.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.util.Conversor;

import java.util.List;

public class DiscoService {

    Conversor conversor = new Conversor();
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();

    public DiscoGrupo pegarDiscoGrupoLooca() {
        return looca.getGrupoDeDiscos();
    }

    public List<Disco> pegarListaDiscoLooca() {
        return pegarDiscoGrupoLooca().getDiscos();
    }

    public List<Volume> pegarListaVolumeLooca() {
        return pegarDiscoGrupoLooca().getVolumes();
    }

    public void inserirPegarModeloVolumeDiscoLooca() {
        for (int i = 0; i < pegarListaDiscoLooca().size(); i++) {
            String modeloDisco = pegarListaDiscoLooca().get(i).getModelo();
            String volumeDisco = Conversor.formatarBytes(pegarListaVolumeLooca().get(i).getTotal());

            templateMySQL.getTemplateMySQl().update("""
                insert into Disco (modeloDisco, volumeDisco, fkAtm) values
                    (?, ?, ?);
                """, modeloDisco, volumeDisco, templateMySQL.pegarIdAtmMaisRecente()
            );
        }
    }
}
