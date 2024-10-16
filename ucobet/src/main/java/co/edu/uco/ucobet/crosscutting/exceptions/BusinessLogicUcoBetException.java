package co.edu.uco.ucobet.crosscutting.exceptions;

import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class BusinessLogicUcoBetException extends UcoBetException {

	private static final long serialVersionUID = 1L;

	public BusinessLogicUcoBetException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.BUSINESSLOGIC);
	}

	public static final BusinessLogicUcoBetException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new BusinessLogicUcoBetException(userMessage, technicalMessage, rootException);
	}

	public static final BusinessLogicUcoBetException crear(final String userMessage) {
		return new BusinessLogicUcoBetException(userMessage, userMessage, new Exception());
	}

	public static final BusinessLogicUcoBetException crear(final String userMessage, final String technicalMessage) {
		return new BusinessLogicUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
