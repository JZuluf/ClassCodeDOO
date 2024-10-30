package co.edu.uco.ucobet.businesslogic.adapter.entity;

import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.StateDomain;
import co.edu.uco.ucobet.entity.StateEntity;

public class StateEntityAdapter implements Adapter<StateDomain, StateEntity>{
	
	private static final Adapter<StateDomain, StateEntity> instance = new StateEntityAdapter();
	
	private StateEntityAdapter() {
		
	}
	
	public static Adapter<StateDomain, StateEntity> getStateEntityAdapter(){
		return instance;
	}
	
	@Override
	public StateDomain adaptSource(StateEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new StateEntity());
		return StateDomain.create(entityToAdapt.getId(), entityToAdapt.getName(), null);
	}

	@Override
	public StateEntity adaptTarget(StateDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, StateDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY, null));
		
		var entityToAdapt = new StateEntity();
		entityToAdapt.setId(domainToAdapt.getId());
		entityToAdapt.setName(domainToAdapt.getName());
		
		return entityToAdapt;
	}

	@Override
	public List<StateEntity> adaptTarget(List<StateDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}
	

}