package Bistro_BackEnd.dao.orden;

import Bistro_BackEnd.model.Orden.Orden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDao extends CrudRepository<Orden, Long> {
}
