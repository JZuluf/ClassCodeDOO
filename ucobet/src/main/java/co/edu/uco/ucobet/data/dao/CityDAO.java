package co.edu.uco.ucobet.data.dao;

import java.util.UUID;

import co.edu.uco.ucobet.entity.CityEntity;

public interface CityDAO extends CreateDAO<CityEntity>,UpdateDAO<CityEntity>,DeleteDAO<UUID>,RetrieveDAO<CityEntity, UUID>{

}
