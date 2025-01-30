package ec.com.dinersclub.dddmodules.infrastructure.model.comunes;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinHeader implements Serializable {
    private static final long serialVersionUID = 1227640850882841114L;


    private Object aplicacionId;

    private Object canalId;

    private String uuid;

    private Object ip;

    private String horaTransaccion;

    private Object llaveSimetrica;

    private Object usuario;

    private String hostname;

    private String moduloRPG;

    private String programa;

    private String libraryList;

    private String rutaPath;

    private String limpiarCache;

    private String comandoRPG;


    public Object getAplicacionId() {
        return aplicacionId;
    }

    @JsonSetter("aplicacionId")
    public void setAplicacionId(Object aplicacionId) {
        this.aplicacionId = aplicacionId;
    }


    public Object getCanalId() {
        return canalId;
    }

    @JsonSetter("canalId")
    public void setCanalId(Object canalId) {
        this.canalId = canalId;
    }


    public String getUuid() {
        return uuid;
    }

    @JsonSetter("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public Object getIp() {
        return ip;
    }

    @JsonSetter("ip")
    public void setIp(Object ip) {
        this.ip = ip;
    }


    public String getHoraTransaccion() {
        return horaTransaccion;
    }

    @JsonSetter("horaTransaccion")
    public void setHoraTransaccion(String horaTransaccion) {
        this.horaTransaccion = horaTransaccion;
    }


    public Object getLlaveSimetrica() {
        return llaveSimetrica;
    }

    @JsonSetter("llaveSimetrica")
    public void setLlaveSimetrica(Object llaveSimetrica) {
        this.llaveSimetrica = llaveSimetrica;
    }


    public Object getUsuario() {
        return usuario;
    }

    @JsonSetter("usuario")
    public void setUsuario(Object usuario) {
        this.usuario = usuario;
    }


    public String getHostname() {
        return hostname;
    }

    @JsonSetter("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getModuloRPG() {
        return moduloRPG;
    }

    @JsonSetter("moduloRPG")
    public void setModuloRPG(String moduloRPG) {
        this.moduloRPG = moduloRPG;
    }


    public String getPrograma() {
        return programa;
    }

    @JsonSetter("programa")
    public void setPrograma(String programa) {
        this.programa = programa;
    }


    public String getLibraryList() {
        return libraryList;
    }

    @JsonSetter("libraryList")
    public void setLibraryList(String libraryList) {
        this.libraryList = libraryList;
    }


    public String getRutaPath() {
        return rutaPath;
    }

    @JsonSetter("rutaPath")
    public void setRutaPath(String rutaPath) {
        this.rutaPath = rutaPath;
    }


    public String getLimpiarCache() {
        return limpiarCache;
    }

    @JsonSetter("limpiarCache")
    public void setLimpiarCache(String limpiarCache) {
        this.limpiarCache = limpiarCache;
    }


    public String getComandoRPG() {
        return comandoRPG;
    }

    @JsonSetter("comandoRPG")
    public void setComandoRPG(String comandoRPG) {
        this.comandoRPG = comandoRPG;
    }
}
