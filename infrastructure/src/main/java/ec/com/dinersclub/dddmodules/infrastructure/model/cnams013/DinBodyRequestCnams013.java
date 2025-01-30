package ec.com.dinersclub.dddmodules.infrastructure.model.cnams013;

import com.fasterxml.jackson.annotation.JsonSetter;
import ec.com.dinersclub.dddmodules.infrastructure.model.comunes.DinHeader;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodyRequestCnams013 implements Serializable {
    private static final long serialVersionUID = -8235908253340432009L;



    private DinHeader dinHeader;

    private DinBodyCnams013 dinBodyCnams013;


    public DinHeader getDinHeader() {
        return dinHeader;
    }

    @JsonSetter("dinHeader")
    public void setDinHeader(DinHeader dinHeader) {
        this.dinHeader = dinHeader;
    }


    public DinBodyCnams013 getDinBody() {
        return dinBodyCnams013;
    }

    @JsonSetter("dinBody")
    public void setDinBody(DinBodyCnams013 dinBodyCnams013) {
        this.dinBodyCnams013 = dinBodyCnams013;
    }
}
