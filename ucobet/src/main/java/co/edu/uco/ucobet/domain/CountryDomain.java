package co.edu.uco.ucobet.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class CountryDomain extends Domain {

	private String name;

	private CountryDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}

	public static final CountryDomain create(final UUID id, final String name) {
		return new CountryDomain(id, name);
	}

	static final CountryDomain create() {
		return new CountryDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	@Override
	public UUID getId() {
		return super.getId();
	}
}