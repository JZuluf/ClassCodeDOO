package co.edu.uco.ucobet.crosscutting.exceptions;

import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class DTOUcoBetException extends UcoBetException {

	private static final long serialVersionUID = 1L;

	public DTOUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DTO);
	}

	public static final DTOUcoBetException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DTOUcoBetException(userMessage, technicalMessage, rootException);
	}

	public static final DTOUcoBetException crear(final String userMessage) {
		return new DTOUcoBetException(userMessage, userMessage, new Exception());
	}

	public static final DTOUcoBetException crear(final String userMessage, final String technicalMessage) {
		return new DTOUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
