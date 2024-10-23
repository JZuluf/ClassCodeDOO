package co.edu.uco.ucobet.businesslogic.adapter.entity;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CountryDomain;
import co.edu.uco.ucobet.domain.StateDomain;
import co.edu.uco.ucobet.entity.CountryEntity;
import co.edu.uco.ucobet.entity.StateEntity;

public class StateEntityAdapter implements Adapter<StateDomain, StateEntity>{
	
	private static final Adapter<StateDomain, StateEntity> instance = new StateEntityAdapter();
	
	private StateEntityAdapter() {
		
	}

	@Override
	public CountryDomain adaptSource(StateEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new CountryEntity());
		return CountryDomain.create(entityToAdapt.getId(), entityToAdapt.getName());
	}

	@Override
	public CountryEntity adaptTarget(StateDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		
		var entityToAdapt = new CountryEntity();
		entityToAdapt.setId(domainToAdapt.getId());
		entityToAdapt.setName(domainToAdapt.getName());
		
		return entityToAdapt;
	}
	

}