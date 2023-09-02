package Bistro_BackEnd.dao.consumibles;

import Bistro_BackEnd.model.consumibles.Plato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoDao extends CrudRepository<Plato, Long> {
}
