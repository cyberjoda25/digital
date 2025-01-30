package ec.com.dinersclub.dddmodules.infrastructure.model.cnams013;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class Primoutds implements Serializable {
    private static final long serialVersionUID = 9150826682908004639L;


    private String pimavat;

    private String vcodmen;

    private String vmens;

    private String vfectr;

    private String vhortr;

    public String getPimavat() {
        return pimavat;
    }

    @JsonSetter("PIMAVAT")
    public void setPimavat(String pimavat) {
        this.pimavat = pimavat;

    }

    public String getVcodmen() {
        return vcodmen;
    }

    @JsonSetter("VCODMEN")
    public void setVcodmen(String vcodmen) {
        this.vcodmen = vcodmen;
    }

    public String getVmens() {
        return vmens;
    }

    @JsonSetter("VMENS")
    public void setVmens(String vmens) {
        this.vmens = vmens;
    }


    public String getVfectr() {
        return vfectr;
    }

    @JsonSetter("VFECTR")
    public void setVfectr(String vfectr) {
        this.vfectr = vfectr;
    }


    public String getVhortr() {
        return vhortr;
    }

    @JsonSetter("VHORTR")
    public void setVhortr(String vhortr) {
        this.vhortr = vhortr;
    }

}
