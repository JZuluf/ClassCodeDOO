package co.edu.uco.ucobet.data.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.ucobet.data.dao.CityDAO;
import co.edu.uco.ucobet.data.dao.StateDAO;
import co.edu.uco.ucobet.data.impl.sql.SqlDAO;
import co.edu.uco.ucobet.entity.CityEntity;
import co.edu.uco.ucobet.entity.StateEntity;

public final class CitySqlServerDAO extends SqlDAO implements CityDAO{

	protected CitySqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(final CityEntity data) {
		
		final StringBuilder statement = new StringBuilder();
		statement.append("INSERT INTO City(id, name, state) VALUES (?, ?) ");
		
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			preparedStatement.setObject(1, data.getId());
			preparedStatement.setObject(2, data.getName());
			preparedStatement.setObject(3, data.getState().getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = "Se ha presenntado un problema tratando de llevar a cabo el registro de información del nuevo país. Por favor intente de nuevo y si el problema persiste reporte el problema...";
			var technicalMessage = "Se ha presentado un problema al tratar de registrar la información en el nuevo país de la base de datos SQL.Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";	
				
			throw DataUcoBetException.crear(userMessage, technicalMessage, exception);
			
		}
		
	}

	@Override
	public void update(final CityEntity data) {
		
		final StringBuilder statement = new StringBuilder();
		statement.append("UPDATE City SET name = ?, state = ? WHERE id = ?");
		
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			preparedStatement.setObject(1, data.getName());
			preparedStatement.setObject(2, data.getState().getId());
			preparedStatement.setObject(3, data.getId());
			
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = "Se ha presenntado un problema tratando de llevar a cabo la modificación de información del nuevo país. Por favor intente de nuevo y si el problema persiste reporte el problema...";
			var technicalMessage = "Se ha presentado un problema al tratar de modificar la información en el nuevo país de la base de datos SQL.Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";	
				
			throw DataUcoBetException.crear(userMessage, technicalMessage, exception);
			
		}
		
	}

	@Override
	public void delete(UUID data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("DELETE FROM City Where id = ?");
		
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			preparedStatement.setObject(1, data);
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = "Se ha presenntado un problema tratando de llevar a cabo la eliminación de información del nuevo país. Por favor intente de nuevo y si el problema persiste reporte el problema...";
			var technicalMessage = "Se ha presentado un problema al tratar de eliminación la información en el nuevo país de la base de datos SQL.Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";	
				
			throw DataUcoBetException.crear(userMessage, technicalMessage, exception);
			
		}
	}

	@Override
	public CityEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
