package co.edu.uco.ucobet.data.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.ucobet.data.dao.StateDAO;
import co.edu.uco.ucobet.data.impl.sql.SqlDAO;
import co.edu.uco.ucobet.entity.CityEntity;
import co.edu.uco.ucobet.entity.StateEntity;

public class StateSqlServerDAO extends SqlDAO implements StateDAO{
	
	public StateSqlServerDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public StateEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
