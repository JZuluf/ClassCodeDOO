package co.edu.uco.ucobet.crosscutting.exceptions;

import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class DataUcoBetException extends UcoBetException {

	private static final long serialVersionUID = 1L;

	public DataUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DATA);
	}

	public static final DataUcoBetException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataUcoBetException(userMessage, technicalMessage, rootException);
	}

	public static final DataUcoBetException crear(final String userMessage) {
		return new DataUcoBetException(userMessage, userMessage, new Exception());
	}

	public static final DataUcoBetException crear(final String userMessage, final String technicalMessage) {
		return new DataUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
