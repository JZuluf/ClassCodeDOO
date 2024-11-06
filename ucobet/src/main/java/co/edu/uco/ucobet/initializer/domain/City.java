package co.edu.uco.ucobet.initializer.domain;

import java.util.UUID;

public class City {
    
    private String name;
    private UUID id;

    public City(String name, UUID id) {
        this.id = id;
        this.name = name;
    }

    public String getName() {  // Cambiado a public
        return name;
    }
    public void setName(String name) {  // Cambiado a public
        this.name = name;
    }
    public UUID getId() {  // Cambiado a public
        return id;
    }
    public void setId(UUID id) {  // Cambiado a public
        this.id = id;
    }
}