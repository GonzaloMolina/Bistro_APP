package Bistro_BackEnd.dao.peticion;


import Bistro_BackEnd.model.empleado.Peticion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeticionDao extends CrudRepository<Peticion, Long> {
}
