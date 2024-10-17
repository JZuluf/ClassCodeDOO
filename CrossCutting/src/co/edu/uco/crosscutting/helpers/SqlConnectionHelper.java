package co.edu.uco.crosscutting.helpers;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.crosscutting.exceptions.UcoApplicationException;
import co.edu.uco.crosscutting.exceptions.enums.Layer;

public final class SqlConnectionHelper {
	
	private SqlConnectionHelper() {
		
	}
	
	public static boolean connectionIsNull(final Connection connection) {
		return ObjectHelper.isNull(connection);
	}
	
	public static boolean connectionIsOpen(final Connection connection) {
		try {
			return !connectionIsNull(connection) && connection.isClosed();
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada...";
			var technicalMessage = "Se ha presentado una excepción de tipo SQLException tratando de lleavr a cabo la validación de si la conexción estaba o no abierta. Por favor revise el log de errores para tener más detalles del error presentado... ";
			throw new UcoApplicationException(userMessage, technicalMessage, exception, Layer.DATA);
		}
	}
}
