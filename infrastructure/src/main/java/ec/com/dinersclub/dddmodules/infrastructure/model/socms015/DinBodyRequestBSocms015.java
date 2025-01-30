package ec.com.dinersclub.dddmodules.infrastructure.model.socms015;

import com.fasterxml.jackson.annotation.JsonSetter;
import ec.com.dinersclub.dddmodules.infrastructure.model.comunes.DinHeader;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodyRequestBSocms015 implements Serializable {

    private static final long serialVersionUID = -5830503878735637869L;

    private DinHeader dinHeader;

    private DinBodyBSocms015 dinBody;

    public DinBodyBSocms015 getDinBody() {
        return dinBody;
    }

    @JsonSetter("dinBody")
    public void setDinBody(DinBodyBSocms015 dinBody) {
        this.dinBody = dinBody;
    }

    public DinHeader getDinHeader() {
        return dinHeader;
    }

    public void setDinHeader(DinHeader dinHeader) {
        this.dinHeader = dinHeader;
    }
}
