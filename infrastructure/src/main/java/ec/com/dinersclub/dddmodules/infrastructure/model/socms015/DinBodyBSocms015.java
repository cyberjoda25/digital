package ec.com.dinersclub.dddmodules.infrastructure.model.socms015;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodyBSocms015 implements Serializable {
    private static final long serialVersionUID = -7040017293401748100L;

    private String portal;

	private String tipoIdentificacion;

    private String numIdentificacion;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String fechaNacimeinto;

    private String genero;

    private String estadoCivil;

    private String nacionalidad;

    private String desNacionalidad;

    private String cargo;

    private String telefonoDomicilio;

    private String telefonoCelular;

    private String email;

    private String otpEmail;

    private String direcDomicilio;

    private String hayError;

    private String codigoError;

    private String descripcionError;

    public String getPortal() {
		return portal;
	}
    @JsonSetter("XPORTAL")    
	public void setPortal(String portal) {
		this.portal = portal;
	}
    
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public DinBodyBSocms015(String tipoIdentificacion, String numIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numIdentificacion = numIdentificacion;
        this.primerNombre = "";
        this.segundoNombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.fechaNacimeinto = "";
        this.genero = "";
        this.estadoCivil = "";
        this.nacionalidad = "";
        this.desNacionalidad = "";
        this.cargo = "";
        this.telefonoDomicilio = "";
        this.telefonoCelular = "";
        this.email = "";
        this.otpEmail = "";
        this.direcDomicilio = "";
        this.hayError = "";
        this.codigoError = "";
        this.descripcionError = "";
    }

    public DinBodyBSocms015() {
    }

    @JsonSetter("XTIPID")
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }
    @JsonSetter("XNUMID")
    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }
    @JsonSetter("XPNOMB")
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }
    @JsonSetter("XSNOMB")
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }
    @JsonSetter("XPAPEL")
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }
    @JsonSetter("XSAPEL")
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getFechaNacimeinto() {
        return fechaNacimeinto;
    }
    @JsonSetter("XFECNA")
    public void setFechaNacimeinto(String fechaNacimeinto) {
        this.fechaNacimeinto = fechaNacimeinto;
    }

    public String getGenero() {
        return genero;
    }
    @JsonSetter("XGENER")
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
    @JsonSetter("XEDOCI")
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    @JsonSetter("XNACIO")
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDesNacionalidad() {
        return desNacionalidad;
    }
    @JsonSetter("XDESNA")
    public void setDesNacionalidad(String desNacionalidad) {
        this.desNacionalidad = desNacionalidad;
    }

    public String getCargo() {
        return cargo;
    }
    @JsonSetter("XCARGO")
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefonoDomicilio() {
        return telefonoDomicilio;
    }
    @JsonSetter("XTELDO")
    public void setTelefonoDomicilio(String telefonoDomicilio) {
        this.telefonoDomicilio = telefonoDomicilio;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }
    @JsonSetter("XTELCE")
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getEmail() {
        return email;
    }
    @JsonSetter("XEMAIL")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtpEmail() {
        return otpEmail;
    }
    @JsonSetter("XOTPEM")
    public void setOtpEmail(String otpEmail) {
        this.otpEmail = otpEmail;
    }

    public String getDirecDomicilio() {
        return direcDomicilio;
    }
    @JsonSetter("XDDOMI")
    public void setDirecDomicilio(String direcDomicilio) {
        this.direcDomicilio = direcDomicilio;
    }

    public String getHayError() {
        return hayError;
    }
    @JsonSetter("HAYERROR")
    public void setHayError(String hayError) {
        this.hayError = hayError;
    }

    public String getCodigoError() {
        return codigoError;
    }
    @JsonSetter("CODERR")
    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public String getDescripcionError() {
        return descripcionError;
    }
    @JsonSetter("DESERR")
    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }
}
