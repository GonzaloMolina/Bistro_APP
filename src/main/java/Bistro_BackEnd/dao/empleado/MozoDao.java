package Bistro_BackEnd.dao.empleado;

import Bistro_BackEnd.empleado.Mozo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MozoDao extends CrudRepository<Mozo, Long> {
}
