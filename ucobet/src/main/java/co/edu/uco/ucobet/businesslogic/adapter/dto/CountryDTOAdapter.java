package co.edu.uco.ucobet.businesslogic.adapter.dto;

import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CountryDomain;
import co.edu.uco.ucobet.domain.StateDomain;
import co.edu.uco.ucobet.dto.CountryDTO;
import co.edu.uco.ucobet.dto.StateDTO;

public class CountryDTOAdapter implements Adapter<CountryDomain, CountryDTO> {

	private static final Adapter<CountryDomain, CountryDTO> instance = new CountryDTOAdapter();
	
	private CountryDTOAdapter() {
		
	}
	
	public static Adapter<CountryDomain, CountryDTO> getSCountryDTOAdapter(){
		return instance;
	}
	@Override
	public CountryDomain adaptSource(final CountryDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, CountryDTO.create());
		return CountryDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
	}

	@Override
	public CountryDTO adaptTarget(final CountryDomain data) {
	    var domainToAdapt = ObjectHelper.getDefault(data, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		return CountryDTO.create().setId("").setName(domainToAdapt.getName());
	}

	@Override
	public List<CountryDTO> adaptTarget(List<CountryDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}


}
