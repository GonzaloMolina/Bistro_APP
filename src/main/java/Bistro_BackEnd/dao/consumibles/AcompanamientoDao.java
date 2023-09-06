package Bistro_BackEnd.dao.consumibles;

import Bistro_BackEnd.model.consumibles.Acompanamiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompanamientoDao extends CrudRepository<Acompanamiento, Long> {
}