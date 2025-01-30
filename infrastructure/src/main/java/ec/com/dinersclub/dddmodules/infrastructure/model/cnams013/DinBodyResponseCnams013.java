package ec.com.dinersclub.dddmodules.infrastructure.model.cnams013;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodyResponseCnams013 implements Serializable {
    private static final long serialVersionUID = -2927107575708045443L;


    private Primoutds primoutds;


    public Primoutds getPrimoutds() {
        return primoutds;
    }

    @JsonSetter("PRIMOUTDS")
    public void setPrimoutds(Primoutds primoutds) {
        this.primoutds = primoutds;
    }
}
