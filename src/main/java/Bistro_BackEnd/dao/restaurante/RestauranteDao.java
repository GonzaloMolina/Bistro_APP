package Bistro_BackEnd.dao.restaurante;

import Bistro_BackEnd.model.restaurante.Restaurante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteDao extends CrudRepository<Restaurante, String> {
}
