package co.edu.uco.ucobet.businesslogic.usecase;

import co.edu.uco.ucobet.data.dao.DAOFactory;

public interface RuleWithFactory<T> {
	void execute(T data, DAOFactory factory);

}
