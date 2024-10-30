package co.edu.uco.ucobet.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CityDomain;
import co.edu.uco.ucobet.dto.CityDTO;

public class CityDTOAdapter implements Adapter<CityDomain, CityDTO> {

	private static final Adapter<CityDomain, CityDTO> instance = new CityDTOAdapter();
	
	private CityDTOAdapter() {
		
	}
	
	public static Adapter<CityDomain, CityDTO> getCityDTOAdapter(){
		return instance;
	}
	@Override
	public CityDomain adaptSource(final CityDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, CityDTO.create());
		return CityDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName(), null);
	}

	@Override
	public CityDTO adaptTarget(final CityDomain data) {
	    var domainToAdapt = ObjectHelper.getDefault(data, CityDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY, null));
		return CityDTO.create().setId("").setName(domainToAdapt.getName());
	}

	@Override
	public List<CityDTO> adaptTarget(final List<CityDomain> data) {
		
		var results = new ArrayList<CityDTO>();
		
		for (CityDomain domain : data) {
			results.add(adaptTarget(domain));
		}
		
		return results;
	}
}
