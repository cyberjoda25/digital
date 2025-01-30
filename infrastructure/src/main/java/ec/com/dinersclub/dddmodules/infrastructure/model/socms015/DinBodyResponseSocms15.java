package ec.com.dinersclub.dddmodules.infrastructure.model.socms015;

import com.fasterxml.jackson.annotation.JsonSetter;
import ec.com.dinersclub.dddmodules.infrastructure.model.comunes.DinError;
import ec.com.dinersclub.dddmodules.infrastructure.model.comunes.DinHeader;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodyResponseSocms15 implements Serializable {


    private static final long serialVersionUID = 8221546867558075606L;

    private DinHeader dinHeader;

    private DinBodyBSocms015 dinBody;

    private DinError dinError;


    public DinHeader getDinHeader() {
        return dinHeader;
    }

    @JsonSetter("dinHeader")
    public void setDinHeader(DinHeader dinHeader) {
        this.dinHeader = dinHeader;
    }


    public DinBodyBSocms015 getDinBody() {
        return dinBody;
    }

    @JsonSetter("dinBody")
    public void setDinBody(DinBodyBSocms015 dinBody) {
        this.dinBody = dinBody;
    }


    public DinError getDinError() {
        return dinError;
    }

    @JsonSetter("dinError")
    public void setDinError(DinError dinError) {
        this.dinError = dinError;
    }

}
