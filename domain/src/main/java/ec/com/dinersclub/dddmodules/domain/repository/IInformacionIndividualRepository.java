package ec.com.dinersclub.dddmodules.domain.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyRequestInformacionIndividual;
import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyResponseInformacionIndividual;
import ec.com.dinersclub.dto.RequestMs;
import ec.com.dinersclub.dto.ResponseMs;
import ec.com.dinersclub.excepciones.interfaces.AbstractMsExcepcion;

public interface IInformacionIndividualRepository {

    ResponseMs<DinBodyResponseInformacionIndividual> consultarInformacion(RequestMs<DinBodyRequestInformacionIndividual> query)
            throws AbstractMsExcepcion, IllegalAccessException, JsonProcessingException;
}
