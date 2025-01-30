package ec.com.dinersclub.dddmodules.infrastructure.model.cnams013;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;
@RegisterForReflection
public class Priminds implements Serializable {
    private static final long serialVersionUID = 608498147671324193L;
    private String pidunic;
    private String pidcanal;

    public Priminds(String pidunic, String pidcanal) {
        this.pidunic = pidunic;
        this.pidcanal = pidcanal;
    }

    public String getPidunic() {
        return pidunic;
    }
    @JsonSetter("PIDUNIC")
    public void setPidunic(String pidunic) {
        this.pidunic = pidunic;
    }

    public String getPidcanal() {
        return pidcanal;
    }
    @JsonSetter("PIDCANAL")
    public void setPidcanal(String pidcanal) {
        this.pidcanal = pidcanal;
    }
}
