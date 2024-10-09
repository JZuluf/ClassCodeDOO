package co.edu.uco.ucobet.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class CityDomain extends Domain {

	private String name;
	private StateDomain state;

	private CityDomain(final UUID id, final String name, final StateDomain state) {
		super(id);
		setName(name);
		setState(state);

	}

	public static final CityDomain create(final UUID id, final String name, final StateDomain state) {
		return new CityDomain(id, name, state);
	}

	static final CityDomain create() {
		return new CityDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, StateDomain.create());
	}

	public String getName() {
		return name;
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public UUID getId() {
		return super.getId();
	}

	public StateDomain getCountry() {
		return state;
	}

	private void setState(final StateDomain state) {
		this.state = ObjectHelper.getDefault(state, StateDomain.create());
	}
   
}
