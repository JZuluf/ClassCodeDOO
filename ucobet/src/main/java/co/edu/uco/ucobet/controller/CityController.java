package co.edu.uco.ucobet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.businesslogic.facade.city.RegisterNewCityFacade;
import co.edu.uco.ucobet.businesslogic.facade.city.impl.FindCityFacadeImpl;
import co.edu.uco.ucobet.businesslogic.facade.city.impl.RegisterNewCityFacadeImpl;
import co.edu.uco.ucobet.controller.response.GenerateResponse;
import co.edu.uco.ucobet.controller.response.concrete.CityResponse;
import co.edu.uco.ucobet.controller.response.concrete.GenericResponse;
import co.edu.uco.ucobet.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.dto.CityDTO;
import co.edu.uco.ucobet.initializer.UcobetApplication;
import co.edu.uco.crosscutting.exceptions.UcoApplicationException;

@RestController
@RequestMapping("/api/v1/cities")
public final class CityController {

	
	@GetMapping("/dummy")
	public CityDTO getDummy() {
		return CityDTO.create();
	}
	
	@PostMapping
	public ResponseEntity<GenericResponse> create(@RequestBody CityDTO city) {
		var messages = new ArrayList<String>();
		
		try {
			var registerNewCityFacade = new RegisterNewCityFacadeImpl() {
				
				@Override
				public void execute(CityDTO data) {
					// TODO Auto-generated method stub
					
				}
			};
			registerNewCityFacade.execute(city);
			
			messages.add("La ciudad se registro de forma satisfactoria");
			return GenerateResponse.genetareSuccessResponse(messages);
		} catch (final UcoBetException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GenerateResponse.genetareFailedResponse(messages);
			
		} catch (final UcoApplicationException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GenerateResponse.genetareFailedResponse(messages);
			
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GenericResponse> update(@PathVariable String id, @RequestBody CityDTO city) {
		city.setId(id);
		var messages = new ArrayList<String>();
		
		try {
			var findCityFacade = new FindCityFacadeImpl();
			findCityFacade.execute(city);
			
			messages.add("La ciudad se actualizo de forma satisfactoria");
			return GenerateResponse.genetareSuccessResponse(messages);
		} catch (final UcoBetException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GenerateResponse.genetareFailedResponse(messages);
			
		} catch (final UcoApplicationException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GenerateResponse.genetareFailedResponse(messages);
			
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<GenericResponse> delete(@PathVariable String id) {
		var messages = new ArrayList<String>();
		
		
		try {
			var findCityFacade = new FindCityFacadeImpl();
			findCityFacade.execute(getDummy());
			
			messages.add("La ciudad se elimino de forma satisfactoria");
			return GenerateResponse.genetareSuccessResponse(messages);
		} catch (final UcoBetException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GenerateResponse.genetareFailedResponse(messages);
			
		} catch (final UcoApplicationException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GenerateResponse.genetareFailedResponse(messages);
			
		}
	}
	
	@GetMapping
	public ResponseEntity<CityResponse> retrieveAll() {
		CityResponse responseWithData = new CityResponse();
		
		var messages = new ArrayList<String>();
		messages.add("Las ciudades se consultaron de manera satisfactoria");
		
		var list = new ArrayList<CityDTO>();
		
		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		return ((new GenerateResponse<CityResponse>()).generateSuccessResponseWithData(responseWithData));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CityResponse> retrieveById(@PathVariable String id) {
CityResponse responseWithData = new CityResponse();
		
		var messages = new ArrayList<String>();
		messages.add("La ciudade se consulto de forma satisfactoria");
		
		var list = new ArrayList<CityDTO>();
		
		list.add(getDummy());
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		return ((new GenerateResponse<CityResponse>()).generateSuccessResponseWithData(responseWithData));
	}
	
	
}
