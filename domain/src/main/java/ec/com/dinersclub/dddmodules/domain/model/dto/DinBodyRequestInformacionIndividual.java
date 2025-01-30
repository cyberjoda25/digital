package ec.com.dinersclub.dddmodules.domain.model.dto;

import ec.com.dinersclub.validador.anotacion.NotNullValidator;
import ec.com.dinersclub.validador.order.Level1;
import ec.com.dinersclub.validador.order.Level2;
import ec.com.dinersclub.validador.order.Level3;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.validation.GroupSequence;
import java.io.Serializable;

@RegisterForReflection
@GroupSequence({DinBodyRequestInformacionIndividual.class, Level1.class, Level2.class, Level3.class})
public class DinBodyRequestInformacionIndividual implements Serializable {
    private static final long serialVersionUID = 7186235506208606294L;

    @NotNullValidator(message = "El valor de campo tipoIdentificacion es requerido.", code = "0002", groups = Level1.class)
    private String tipoIdentificacion;

    @NotNullValidator(message = "El valor de campo identificacion es requerido.", code = "0002", groups = Level1.class)
    private String identificacion;

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
