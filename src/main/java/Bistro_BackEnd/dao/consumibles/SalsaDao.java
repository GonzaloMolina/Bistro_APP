package Bistro_BackEnd.dao.consumibles;

import Bistro_BackEnd.model.consumibles.Salsa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalsaDao extends CrudRepository<Salsa, Long> {
}
