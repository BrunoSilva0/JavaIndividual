package database.model;

public class RegistroDispositivoUsbConectadoModel {
    private Integer idRegistroDispositivoUsbConectado;
    private Integer fkRegistro;
    private Integer fkDispositivoUsb;
    private Boolean conectado;

    public RegistroDispositivoUsbConectadoModel() {
    }

    public Integer getIdRegistroDispositivoUsbConectado() {
        return idRegistroDispositivoUsbConectado;
    }

    public void setIdRegistroDispositivoUsbConectado(Integer idRegistroDispositivoUsbConectado) {
        this.idRegistroDispositivoUsbConectado = idRegistroDispositivoUsbConectado;
    }

    public Integer getFkRegistro() {
        return fkRegistro;
    }

    public void setFkRegistro(Integer fkRegistro) {
        this.fkRegistro = fkRegistro;
    }

    public Integer getFkDispositivoUsb() {
        return fkDispositivoUsb;
    }

    public void setFkDispositivoUsb(Integer fkDispositivoUsb) {
        this.fkDispositivoUsb = fkDispositivoUsb;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }

    @Override
    public String toString() {
        return "\nRegistroDispositivoUsbConectadoModel{" +
                "idRegistroDispositivoUsbConectado=" + idRegistroDispositivoUsbConectado +
                ", fkRegistro=" + fkRegistro +
                ", fkDispositivoUsb=" + fkDispositivoUsb +
                ", conectado=" + conectado +
                '}';
    }
}
