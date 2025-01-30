package ec.com.dinersclub.dddmodules.application.cqrs.queries;

import com.fasterxml.jackson.core.JsonProcessingException;
import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyRequestInformacionIndividual;
import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyResponseInformacionIndividual;
import ec.com.dinersclub.dddmodules.domain.repository.IInformacionIndividualRepository;
import ec.com.dinersclub.dto.RequestMs;
import ec.com.dinersclub.dto.ResponseMs;
import ec.com.dinersclub.excepciones.interfaces.AbstractMsExcepcion;
import ec.com.dinersclub.validador.violation.SimpleValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class InformacionIndividualQueryServiceImpl implements IInformacionIndividualQueryService {
    @Inject
    SimpleValidator simpleValidator;

    @Inject
    IInformacionIndividualRepository informacionIndividualRepository;

    @Override
    public ResponseMs<DinBodyResponseInformacionIndividual> consultarInformacionIndividualCliente(RequestMs<DinBodyRequestInformacionIndividual> query) throws AbstractMsExcepcion, IllegalAccessException, JsonProcessingException {
        simpleValidator.ejecutar(query);
        return informacionIndividualRepository.consultarInformacion(query);
    }
}
