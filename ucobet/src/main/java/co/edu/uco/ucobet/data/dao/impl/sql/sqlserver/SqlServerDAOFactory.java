package co.edu.uco.ucobet.data.dao.impl.sql.sqlserver;

import java.sql.Connection;

import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;
import co.edu.uco.ucobet.data.dao.CityDAO;
import co.edu.uco.ucobet.data.dao.CountryDAO;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.data.dao.StateDAO;
import co.edu.uco.ucobet.data.impl.sql.sqlserver.CitySqlServerDAO;
import co.edu.uco.ucobet.data.impl.sql.sqlserver.CountrySqlServerDAO;
import co.edu.uco.ucobet.data.impl.sql.sqlserver.StateSqlServerDAO;

public final class SqlServerDAOFactory extends DAOFactory {

	private Connection connection;

	public SqlServerDAOFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		SqlConnectionHelper.validateIfConnectionIsOpen(connection);
		var connectionString = "jdbc:sqlserver://ucobet-server.database.windows.net:1433;database=ucobet-db;user=ucobetdbuser;password=uc0b3tdbus3r!;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		connection = SqlConnectionHelper.openConnection(connectionString);
	}

	@Override
	public void initTransaction() {
		SqlConnectionHelper.initTransaction(connection);
	}

	@Override
	public void commitTransaction() {
		SqlConnectionHelper.commitTransaction(connection);
	}

	@Override
	public void rollbackTransaction() {
		SqlConnectionHelper.rollbackTransaction(connection);
	}

	@Override
	public void closeConnection() {
		SqlConnectionHelper.closeConnection(connection);
	}

	@Override
	public CityDAO getCityDAO() {
		return new CitySqlServerDAO(connection);
	}

	@Override
	public StateDAO getStateDAO() {
		return new StateSqlServerDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountrySqlServerDAO(connection);
	}

}
