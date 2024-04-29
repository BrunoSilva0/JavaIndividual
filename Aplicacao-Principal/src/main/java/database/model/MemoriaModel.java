package database.model;

public class MemoriaModel {

    private Integer idMemoria;
    private String tamanhoTotal;
    private Integer fkAtm;


    public MemoriaModel() {
    }


    public Integer getIdMemoria() {
        return idMemoria;
    }

    public void setIdMemoria(Integer idMemoria) {
        this.idMemoria = idMemoria;
    }

    public String getTamanhoTotal() {
        return tamanhoTotal;
    }

    public void setTamanhoTotal(String tamanhoTotal) {
        this.tamanhoTotal = tamanhoTotal;
    }

    public Integer getFkAtm() {
        return fkAtm;
    }

    public void setFkAtm(Integer fkAtm) {
        this.fkAtm = fkAtm;
    }

    @Override
    public String toString() {
        return "MemoriaModel{" +
                "idMemoria=" + idMemoria +
                ", tamanhoTotal='" + tamanhoTotal + '\'' +
                ", fkAtm=" + fkAtm +
                '}';
    }
}

