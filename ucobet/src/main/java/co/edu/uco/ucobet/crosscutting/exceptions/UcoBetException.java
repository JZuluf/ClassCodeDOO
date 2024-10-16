package co.edu.uco.ucobet.crosscutting.exceptions;

import co.edu.uco.crosscutting.exceptions.UcoApplicationException;
import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class UcoBetException extends UcoApplicationException {

	private static final long serialVersionUID = 1L;

	public UcoBetException(final String userMessage, final String technicalMessage, final Exception rootException,
			final Layer layer) {
		super(userMessage, technicalMessage, rootException, layer);
	}

	public static UcoBetException crear(final String userMessage, final String technicalMessage,
			final Exception rootException, final Layer layer) {
		return new UcoBetException(userMessage, technicalMessage, rootException, layer);
	}

	public static UcoBetException crear(final String userMessage) {
		return new UcoBetException(userMessage, userMessage, new Exception(), Layer.GENERAL);
	}

	public static UcoBetException crear(final String userMessage, final String technicalMessage) {
		return new UcoBetException(userMessage, technicalMessage, new Exception(), Layer.GENERAL);
	}

}
