package sistema.database.model;

public class DispositivoUsbModel {
    private Integer idDispositivoUsb;
    private String nomeDispositivo;
    private Integer fkAtm;

    public DispositivoUsbModel() {
    }

    public Integer getIdDispositivoUsb() {
        return idDispositivoUsb;
    }

    public void setIdDispositivoUsb(Integer idDispositivoUsb) {
        this.idDispositivoUsb = idDispositivoUsb;
    }

    public String getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    public Integer getFkAtm() {
        return fkAtm;
    }

    public void setFkAtm(Integer fkAtm) {
        this.fkAtm = fkAtm;
    }

    @Override
    public String toString() {
        return "DispositivoUsbModel{" +
                "idDispositivoUsb=" + idDispositivoUsb +
                ", nomeDispositivo='" + nomeDispositivo + '\'' +
                ", fkAtm=" + fkAtm +
                '}';
    }
}
