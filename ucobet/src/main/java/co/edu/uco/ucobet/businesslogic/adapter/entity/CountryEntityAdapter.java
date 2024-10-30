package co.edu.uco.ucobet.businesslogic.adapter.entity;

import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CountryDomain;
import co.edu.uco.ucobet.entity.CountryEntity;


public class CountryEntityAdapter implements Adapter<CountryDomain, CountryEntity>{
	
	private static final Adapter<CountryDomain, CountryEntity> instance = new CountryEntityAdapter();
	
	private CountryEntityAdapter() {
		
	}
	
	public static Adapter<CountryDomain, CountryEntity> getCountryEntityAdapter(){
		return instance;
	}

	@Override
	public CountryDomain adaptSource(CountryEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new CountryEntity());
		return CountryDomain.create(entityToAdapt.getId(), entityToAdapt.getName());
	}

	@Override
	public CountryEntity adaptTarget(CountryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		
		var entityToAdapt = new CountryEntity();
		entityToAdapt.setId(domainToAdapt.getId());
		entityToAdapt.setName(domainToAdapt.getName());
		
		return entityToAdapt;
	}

	@Override
	public List<CountryEntity> adaptTarget(List<CountryDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}
	

}