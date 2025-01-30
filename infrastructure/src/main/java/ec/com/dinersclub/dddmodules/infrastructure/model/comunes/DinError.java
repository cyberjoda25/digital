package ec.com.dinersclub.dddmodules.infrastructure.model.comunes;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinError implements Serializable {
    private static final long serialVersionUID = -1413528962810806996L;

    private String tipo;

    private String fecha;

    private String origen;

    private String codigo;

    private Object codigoErrorProveedor;

    private String mensaje;

    private String detalle;


    public String getTipo() {
        return tipo;
    }

    @JsonSetter("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getFecha() {
        return fecha;
    }

    @JsonSetter("fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getOrigen() {
        return origen;
    }

    @JsonSetter("origen")
    public void setOrigen(String origen) {
        this.origen = origen;
    }


    public String getCodigo() {
        return codigo;
    }

    @JsonSetter("codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Object getCodigoErrorProveedor() {
        return codigoErrorProveedor;
    }

    @JsonSetter("codigoErrorProveedor")
    public void setCodigoErrorProveedor(Object codigoErrorProveedor) {
        this.codigoErrorProveedor = codigoErrorProveedor;
    }


    public String getMensaje() {
        return mensaje;
    }

    @JsonSetter("mensaje")
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public String getDetalle() {
        return detalle;
    }

    @JsonSetter("detalle")
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
