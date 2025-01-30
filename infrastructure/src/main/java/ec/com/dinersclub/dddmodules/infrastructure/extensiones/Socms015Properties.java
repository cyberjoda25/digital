package ec.com.dinersclub.dddmodules.infrastructure.extensiones;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Socms015Properties {


    @ConfigProperty(name = "as400.socms015.comandoRPG")
    String comandoRPG;

    @ConfigProperty(name = "as400.socms015.hostname")
    String hostname;

    @ConfigProperty(name = "as400.socms015.libraryList")
    String libraryList;

    @ConfigProperty(name = "as400.socms015.limpiarCache")
    String limpiarCache;

    @ConfigProperty(name = "as400.socms015.moduloRPG")
    String moduloRPG;

    @ConfigProperty(name = "as400.socms015.rutaPath")
    String rutaPath;

    @ConfigProperty(name = "as400.socms015.programa")
    String programa;

    public String getComandoRPG() {
        return comandoRPG;
    }

    public String getHostname() {
        return hostname;
    }

    public String getLibraryList() {
        return libraryList;
    }

    public String getLimpiarCache() {
        return limpiarCache;
    }

    public String getModuloRPG() {
        return moduloRPG;
    }

    public String getRutaPath() {
        return rutaPath;
    }

    public String getPrograma() {
        return programa;
    }
}
