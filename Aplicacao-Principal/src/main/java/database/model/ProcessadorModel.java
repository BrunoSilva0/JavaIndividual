package database.model;

public class ProcessadorModel {
    private Integer idProcessador;
    private String nomeProcessador;
    private String modeloProcessador;
    private String frequenciaProcessador;
    private Integer qtdProcessadorFisico;
    private Integer qtdProcessadorLogico;
    private Integer fkAtm;

    public ProcessadorModel() {
    }

    public Integer getIdProcessador() {
        return idProcessador;
    }

    public void setIdProcessador(Integer idProcessador) {
        this.idProcessador = idProcessador;
    }

    public String getNomeProcessador() {
        return nomeProcessador;
    }

    public void setNomeProcessador(String nomeProcessador) {
        this.nomeProcessador = nomeProcessador;
    }

    public String getModeloProcessador() {
        return modeloProcessador;
    }

    public void setModeloProcessador(String modeloProcessador) {
        this.modeloProcessador = modeloProcessador;
    }

    public String getFrequenciaProcessador() {
        return frequenciaProcessador;
    }

    public void setFrequenciaProcessador(String frequenciaProcessador) {
        this.frequenciaProcessador = frequenciaProcessador;
    }

    public Integer getQtdProcessadorFisico() {
        return qtdProcessadorFisico;
    }

    public void setQtdProcessadorFisico(Integer qtdProcessadorFisico) {
        this.qtdProcessadorFisico = qtdProcessadorFisico;
    }

    public Integer getQtdProcessadorLogico() {
        return qtdProcessadorLogico;
    }

    public void setQtdProcessadorLogico(Integer qtdProcessadorLogico) {
        this.qtdProcessadorLogico = qtdProcessadorLogico;
    }

    public Integer getFkAtm() {
        return fkAtm;
    }

    public void setFkAtm(Integer fkAtm) {
        this.fkAtm = fkAtm;
    }

    @Override
    public String toString() {
        return "ProcessadorModel{" +
                "idProcessador=" + idProcessador +
                ", nomeProcessador='" + nomeProcessador + '\'' +
                ", modeloProcessador='" + modeloProcessador + '\'' +
                ", frequenciaProcessador='" + frequenciaProcessador + '\'' +
                ", qtdProcessadorFisico=" + qtdProcessadorFisico +
                ", qtdProcessadorLogico=" + qtdProcessadorLogico +
                ", fkAtm=" + fkAtm +
                '}';
    }
}
