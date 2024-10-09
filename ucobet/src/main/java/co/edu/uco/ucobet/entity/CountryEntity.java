package co.edu.uco.ucobet.entity;

import java.util.UUID;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.dto.CountryDTO;

public class CountryEntity extends DomainEntity{
	
	private String name;
	
	public CountryEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	public void setId(final UUID id) {
		super.setId(id);
	}
	
	public UUID getId() {
		return super.getId();
	}	
	
}
