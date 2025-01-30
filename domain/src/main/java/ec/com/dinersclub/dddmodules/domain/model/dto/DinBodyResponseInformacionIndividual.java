package ec.com.dinersclub.dddmodules.domain.model.dto;

import ec.com.dinersclub.dddmodules.domain.model.model.InformacionIndividual;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodyResponseInformacionIndividual implements Serializable {
    private static final long serialVersionUID = 6585675585684515111L;

    private InformacionIndividual data;

    public DinBodyResponseInformacionIndividual(InformacionIndividual data) {
        this.data = data;
    }

    public DinBodyResponseInformacionIndividual() {
    }

    public InformacionIndividual getData() {
        return data;
    }

    public void setData(InformacionIndividual data) {
        this.data = data;
    }
}
