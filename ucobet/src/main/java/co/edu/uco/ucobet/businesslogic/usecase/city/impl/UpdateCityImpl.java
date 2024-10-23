package co.edu.uco.ucobet.businesslogic.usecase.city.impl;

import co.edu.uco.ucobet.businesslogic.usecase.city.UpdateCity;
import co.edu.uco.ucobet.domain.CityDomain;

public class UpdateCityImpl implements UpdateCity{

	private DAOFactory daoFactory;
	
	public UpdateCityImpl(DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}
	
	
	
	@Override
	public void execute(final CityDomain data) {
		// TODO Auto-generated method stub
		
	}

}
