package Bistro_BackEnd.dao.peticion;


import Bistro_BackEnd.model.empleado.Solicitud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudDao extends CrudRepository<Solicitud, Long> {
}
