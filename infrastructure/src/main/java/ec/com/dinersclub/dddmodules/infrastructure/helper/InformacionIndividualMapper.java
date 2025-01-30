package ec.com.dinersclub.dddmodules.infrastructure.helper;

import ec.com.dinersclub.dddmodules.domain.model.model.InformacionIndividual;
import ec.com.dinersclub.dddmodules.infrastructure.model.socms015.DinBodyBSocms015;
import ec.com.dinersclub.dddmodules.infrastructure.model.socms015.DinBodySocms015;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InformacionIndividualMapper {

    public InformacionIndividual toInformacionIndividual(DinBodyBSocms015 dinBodyBSocms015, String image){
        var informacionIndividual = new InformacionIndividual();
        var date = toDate(dinBodyBSocms015);
        informacionIndividual.setPrimerNombreCliente(dinBodyBSocms015.getPrimerNombre());
        informacionIndividual.setSegundoNombreCliente(dinBodyBSocms015.getSegundoNombre());
        informacionIndividual.setPrimerApellidosCliente(dinBodyBSocms015.getPrimerApellido());
        informacionIndividual.setSegundoApellidosCliente(dinBodyBSocms015.getSegundoApellido());
        informacionIndividual.setFechaNacimiento(date);
        informacionIndividual.setGenero(dinBodyBSocms015.getGenero());
        informacionIndividual.setEstadoCivil(dinBodyBSocms015.getEstadoCivil());
        informacionIndividual.setNacionalidad(dinBodyBSocms015.getNacionalidad());
        informacionIndividual.setDesNacionalidad(dinBodyBSocms015.getDesNacionalidad());
        informacionIndividual.setCargo(dinBodyBSocms015.getCargo());
        informacionIndividual.setTelefonoDomicilio(dinBodyBSocms015.getTelefonoDomicilio());
        informacionIndividual.setTelefonoCelular(dinBodyBSocms015.getTelefonoCelular());
        informacionIndividual.setEmail(dinBodyBSocms015.getEmail());
        informacionIndividual.setOtpEmail(dinBodyBSocms015.getOtpEmail());
        informacionIndividual.setDireccionDomicilio(dinBodyBSocms015.getDirecDomicilio());
        informacionIndividual.setImagenPerfil(image);
        return informacionIndividual;
    }

    public String toDate(DinBodyBSocms015 dinBodyBSocms015){
        String str = dinBodyBSocms015.getFechaNacimeinto();
        var anio = str.substring(0,4);
        var mes =  str.substring(4,6);
        var dia = str.substring(6,8);
        String date = anio +"-"+mes+"-"+dia;
        return date;
    }
    
    public InformacionIndividual toInformacionIndividual(DinBodySocms015 dinBodySocms015, String image){
        var informacionIndividual = new InformacionIndividual();
        var date = toDate(dinBodySocms015);
        informacionIndividual.setPrimerNombreCliente(dinBodySocms015.getPrimerNombre());
        informacionIndividual.setSegundoNombreCliente(dinBodySocms015.getSegundoNombre());
        informacionIndividual.setPrimerApellidosCliente(dinBodySocms015.getPrimerApellido());
        informacionIndividual.setSegundoApellidosCliente(dinBodySocms015.getSegundoApellido());
        informacionIndividual.setFechaNacimiento(date);
        informacionIndividual.setGenero(dinBodySocms015.getGenero());
        informacionIndividual.setEstadoCivil(dinBodySocms015.getEstadoCivil());
        informacionIndividual.setNacionalidad(dinBodySocms015.getNacionalidad());
        informacionIndividual.setDesNacionalidad(dinBodySocms015.getDesNacionalidad());
        informacionIndividual.setCargo(dinBodySocms015.getCargo());
        informacionIndividual.setTelefonoDomicilio(dinBodySocms015.getTelefonoDomicilio());
        informacionIndividual.setTelefonoCelular(dinBodySocms015.getTelefonoCelular());
        informacionIndividual.setEmail(dinBodySocms015.getEmail());
        informacionIndividual.setOtpEmail(dinBodySocms015.getOtpEmail());
        informacionIndividual.setDireccionDomicilio(dinBodySocms015.getDirecDomicilio());
        informacionIndividual.setImagenPerfil(image);
        return informacionIndividual;
    }

    public String toDate(DinBodySocms015 dinBodySocms015){
        String str = dinBodySocms015.getFechaNacimeinto();
        var anio = str.substring(0,4);
        var mes =  str.substring(4,6);
        var dia = str.substring(6,8);
        String date = anio +"-"+mes+"-"+dia;
        return date;
    }    
}
