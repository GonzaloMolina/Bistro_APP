package Bistro_BackEnd.dao.consumibles;

import Bistro_BackEnd.model.menu.PlatoM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoMDao extends CrudRepository<PlatoM, Long> {
}
