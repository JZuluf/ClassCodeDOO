package co.edu.uco.ucobet.initializer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.initializer.domain.City;
import co.edu.uco.ucobet.initializer.repository.CityRepository;

@RestController
@RequestMapping("/cities") // Corrección de la ruta
public class CityController {

    private final CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/all")
    public List<City> getAll() {
        return this.cityRepository.getCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable UUID id) {
        City city = this.cityRepository.getById(id);
        if (city == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra
        }
        return ResponseEntity.ok(city); // Devuelve 200 y la ciudad encontrada
    }

    @PostMapping("/new")
    public City saveNew(@RequestBody City city) {
        return this.cityRepository.save(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.cityRepository.delete(id);
    }
}