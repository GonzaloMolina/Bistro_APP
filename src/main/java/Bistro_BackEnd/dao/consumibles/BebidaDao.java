package Bistro_BackEnd.dao.consumibles;


import Bistro_BackEnd.model.consumibles.Bebida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaDao extends CrudRepository<Bebida, Long>{
}
