package co.edu.uco.ucobet.initializer.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.initializer.domain.City;

@Repository
public class CityRepository {
    
    public final List<City> cities; 
    
    public CityRepository() {
        
        this.cities = new ArrayList<>();
        
        this.cities.add(new City("Medellin", UUIDHelper.generate())); 
        this.cities.add(new City("Cartagena", UUIDHelper.generate()));
        this.cities.add(new City("Bogota", UUIDHelper.generate()));
        
    }
    
    public List<City> getCities(){
        return cities;
    }
    
    public City getById(UUID id) {
        return this.cities.stream()
                .filter(city -> city.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public City save(City city) {
        
        if (this.getById(city.getId()) != null ) {
            throw new RuntimeException("La ciudad ya existe...");
        }
        
        this.cities.add(city);
        return city;
        
    }
    
    public void delete(UUID id) {
        City cityToDelete = this.getById(id);
        
        if (cityToDelete == null) {
            throw new RuntimeException("La ciudad no existe.");
        }
        
        this.cities.remove(cityToDelete);
    }
}