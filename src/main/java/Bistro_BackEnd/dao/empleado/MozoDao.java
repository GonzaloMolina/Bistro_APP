package Bistro_BackEnd.dao.empleado;

import Bistro_BackEnd.model.empleado.Mozo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MozoDao extends CrudRepository<Mozo, Long> {

    @Query("SELECT u FROM Mozo u WHERE u.email = :email")
    public Mozo getUserByUsername(@Param("email") String email);
}
