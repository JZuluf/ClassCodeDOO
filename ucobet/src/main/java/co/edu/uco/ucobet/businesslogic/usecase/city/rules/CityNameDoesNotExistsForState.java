package co.edu.uco.ucobet.businesslogic.usecase.city.rules;

import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.domain.CityDomain;

public interface CityNameDoesNotExistsForState  {

	void execute(CityDomain data, DAOFactory factory);

}
