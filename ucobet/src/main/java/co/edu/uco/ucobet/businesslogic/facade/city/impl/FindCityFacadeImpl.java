package co.edu.uco.ucobet.businesslogic.facade.city.impl;

import java.util.List;

import co.edu.uco.ucobet.businesslogic.adapter.dto.CityDTOAdapter;
import co.edu.uco.ucobet.businesslogic.facade.city.FindCityFacade;
import co.edu.uco.ucobet.businesslogic.usecase.city.impl.FindCityImpl;
import co.edu.uco.ucobet.businesslogic.usecase.city.impl.RegisterNewCityImpl;
import co.edu.uco.ucobet.crosscutting.exceptions.BusinessLogicUcoBetException;
import co.edu.uco.ucobet.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.data.dao.enums.DAOSource;
import co.edu.uco.ucobet.dto.CityDTO;

public final class FindCityFacadeImpl implements FindCityFacade {
	
	

	@Override
	public List<CityDTO> execute(final CityDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			var findCityUseCase = new FindCityImpl(factory);
			var cityDomain = CityDTOAdapter.getCityDTOAdapter().adaptSource(data);
			
			return CityDTOAdapter.getCityDTOAdapter().adaptTarget(findCityUseCase.execute(cityDomain));
			
		} catch (final UcoBetException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMEssage ="Se ha presentado un problema tratando de consultar la informacion de las ciudades...";
			var technicalMEssage="Se ha presentado un problema inseperado consultando la informacion de las ciudades. por favor revise el log de errores para tener mas detalles...";
			
			throw BusinessLogicUcoBetException.crear(userMEssage, technicalMEssage, exception);
		} finally {
			factory.closeConnection();
		}
	
	}

}
