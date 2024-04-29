package database.model;

public class DiscoModel {

    private Integer idDisco;
    private String modeloDisco;
    private String volumeDisco;
    private Integer fkAtm;

    public DiscoModel() {

    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public String getModeloDisco() {
        return modeloDisco;
    }

    public void setModeloDisco(String modeloDisco) {
        this.modeloDisco = modeloDisco;
    }

    public String getVolumeDisco() {
        return volumeDisco;
    }

    public void setVolumeDisco(String volumeDisco) {
        this.volumeDisco = volumeDisco;
    }


    public Integer getFkAtm() {
        return fkAtm;
    }

    public void setFkAtm(Integer fkAtm) {
        this.fkAtm = fkAtm;
    }

    @Override
    public String toString() {
        return "DiscoModel{" +
                "idDisco=" + idDisco +
                ", modeloDisco='" + modeloDisco + '\'' +
                ", volumeDisco='" + volumeDisco + '\'' +
                ", fkAtm=" + fkAtm +
                '}';
    }
}
