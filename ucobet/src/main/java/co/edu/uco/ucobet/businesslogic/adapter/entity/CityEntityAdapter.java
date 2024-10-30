package co.edu.uco.ucobet.businesslogic.adapter.entity;

import java.util.List;

import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CityDomain;
import co.edu.uco.ucobet.entity.CityEntity;

public final class CityEntityAdapter implements Adapter<CityEntity, CityDomain>{
	
	private static final Adapter<CityEntity, CityDomain> instance = new CityEntityAdapter();
	
	private CityEntityAdapter() {
		
	}
	
	public static Adapter<CityEntity, CityDomain> getCityEntityAdapter(){
		return instance;
	}

	@Override
	public CityEntity adaptSource(CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDomain adaptTarget(CityEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDomain> adaptTarget(List<CityEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}



}