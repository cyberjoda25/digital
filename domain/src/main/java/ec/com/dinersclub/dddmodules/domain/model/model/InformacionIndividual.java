package ec.com.dinersclub.dddmodules.domain.model.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class InformacionIndividual implements Serializable {
    private static final long serialVersionUID = -5066163805019682132L;

    private String primerNombreCliente;

    private String segundoNombreCliente;

    private String primerApellidosCliente;

    private String segundoApellidosCliente;

    private String fechaNacimiento;

    private String genero;

    private String estadoCivil;

    private String nacionalidad;

    private String desNacionalidad;

    private String cargo;

    private String telefonoDomicilio;

    private String telefonoCelular;

    private String email;

    private String otpEmail;

    private String direccionDomicilio;

    private String imagenPerfil;

    public String getPrimerNombreCliente() {
        return primerNombreCliente;
    }

    public void setPrimerNombreCliente(String primerNombreCliente) {
        this.primerNombreCliente = primerNombreCliente;
    }

    public String getSegundoNombreCliente() {
        return segundoNombreCliente;
    }

    public void setSegundoNombreCliente(String segundoNombreCliente) {
        this.segundoNombreCliente = segundoNombreCliente;
    }

    public String getPrimerApellidosCliente() {
        return primerApellidosCliente;
    }

    public void setPrimerApellidosCliente(String primerApellidosCliente) {
        this.primerApellidosCliente = primerApellidosCliente;
    }

    public String getSegundoApellidosCliente() {
        return segundoApellidosCliente;
    }

    public void setSegundoApellidosCliente(String segundoApellidosCliente) {
        this.segundoApellidosCliente = segundoApellidosCliente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefonoDomicilio() {
        return telefonoDomicilio;
    }

    public void setTelefonoDomicilio(String telefonoDomicilio) {
        this.telefonoDomicilio = telefonoDomicilio;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesNacionalidad() {
        return desNacionalidad;
    }

    public void setDesNacionalidad(String desNacionalidad) {
        this.desNacionalidad = desNacionalidad;
    }

    public String getOtpEmail() {
        return otpEmail;
    }

    public void setOtpEmail(String otpEmail) {
        this.otpEmail = otpEmail;
    }
}
