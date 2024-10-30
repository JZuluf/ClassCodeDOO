package co.edu.uco.ucobet.data.impl.sql;

import java.sql.Connection;

import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;

public class SqlDAO {
	
	private Connection connection;
	
	protected SqlDAO(final Connection connection) {
		setConnection(connection);
	}
	
	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(final Connection connection) {
		SqlConnectionHelper.validateIfConnectionIsClosed(connection);
		this.connection = connection;
	}
}
