package ec.com.dinersclub.dddmodules.infrastructure.model.cnams013;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodyCnams013 implements Serializable {
    private static final long serialVersionUID = 1941241301313441980L;
    private Priminds priminds;



    public Priminds getPriminds() {
        return priminds;
    }
    @JsonSetter("PRIMINDS")
    public void setPriminds(Priminds priminds) {
        this.priminds = priminds;
    }

}
