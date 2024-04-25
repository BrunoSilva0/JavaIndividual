package sistema.database.model;

public class AtmModel {
    private Integer idAtm;
    private String sistemaOperacional;
    private Integer arquitetura;
    private Integer fkBanco;

    public AtmModel() {
    }

    public Integer getIdAtm() {
        return idAtm;
    }

    public void setIdAtm(Integer idAtm) {
        this.idAtm = idAtm;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(Integer arquitetura) {
        this.arquitetura = arquitetura;
    }

    public Integer getFkBanco() {
        return fkBanco;
    }

    public void setFkBanco(Integer fkBanco) {
        this.fkBanco = fkBanco;
    }

    @Override
    public String toString() {
        return "AtmModel{" +
                "idAtm=" + idAtm +
                ", sistemaOperacional='" + sistemaOperacional + '\'' +
                ", arquitetura=" + arquitetura +
                ", fkBanco=" + fkBanco +
                '}';
    }
}
