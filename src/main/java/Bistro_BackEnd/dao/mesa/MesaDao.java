package Bistro_BackEnd.dao.mesa;

import Bistro_BackEnd.Mesa.Mesa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaDao extends CrudRepository<Mesa, Long> {
}
