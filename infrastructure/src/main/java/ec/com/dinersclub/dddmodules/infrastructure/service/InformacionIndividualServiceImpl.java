package ec.com.dinersclub.dddmodules.infrastructure.service;

import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyRequestInformacionIndividual;
import ec.com.dinersclub.dddmodules.domain.model.dto.DinBodyResponseInformacionIndividual;
import ec.com.dinersclub.dddmodules.domain.repository.IInformacionIndividualRepository;
import ec.com.dinersclub.dddmodules.infrastructure.helper.InformacionIndividualMapper;
import ec.com.dinersclub.dddmodules.infrastructure.repository.BSocms015Repository;
import ec.com.dinersclub.dddmodules.infrastructure.repository.Cnams013Repository;
import ec.com.dinersclub.dddmodules.infrastructure.repository.Socms015Repository;
import ec.com.dinersclub.dto.RequestMs;
import ec.com.dinersclub.dto.ResponseMs;
import ec.com.dinersclub.excepciones.interfaces.AbstractMsExcepcion;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class InformacionIndividualServiceImpl implements IInformacionIndividualRepository {

    @Inject
    InformacionIndividualMapper informacionIndividualMapper;
   
    @Inject
    Socms015Repository socms015Repository;
    
    @Inject
    BSocms015Repository bsocms015Repository;
    

    @Inject
    Cnams013Repository cnams013Repository;

    @Override
    public ResponseMs<DinBodyResponseInformacionIndividual> consultarInformacion(RequestMs<DinBodyRequestInformacionIndividual> query) throws AbstractMsExcepcion {
    	
    	if ( query.getDinHeader().getAplicacionId() != null ) {

        	if (!query.getDinHeader().getAplicacionId().equals("PPM") ) {
    	        var bsocms015Response = this.bsocms015Repository.ejecutarBSOCMS15(query);
    	        var cnams013Response = this.cnams013Repository.ejecutarCnams013(query);
    	        var image = cnams013Response.getPimavat();
    	        var informacionResponse = this.informacionIndividualMapper.toInformacionIndividual(bsocms015Response, image);	
    	        return new ResponseMs<>(query.getDinHeader(), new DinBodyResponseInformacionIndividual(informacionResponse));
        	}
        	else
        	{
    	        var socms015Response = this.socms015Repository.ejecutarSOCMS15(query);
    	        var cnams013Response = this.cnams013Repository.ejecutarCnams013(query);
    	        var image = cnams013Response.getPimavat();
    	        var informacionResponse = this.informacionIndividualMapper.toInformacionIndividual(socms015Response, image);	
    	        return new ResponseMs<>(query.getDinHeader(), new DinBodyResponseInformacionIndividual(informacionResponse));    		
        	}    		
    		
    	}
    	else
    	{
	        var bsocms015Response = this.bsocms015Repository.ejecutarBSOCMS15(query);
	        var cnams013Response = this.cnams013Repository.ejecutarCnams013(query);
	        var image = cnams013Response.getPimavat();
	        var informacionResponse = this.informacionIndividualMapper.toInformacionIndividual(bsocms015Response, image);	
	        return new ResponseMs<>(query.getDinHeader(), new DinBodyResponseInformacionIndividual(informacionResponse));
    	}


    }


}
