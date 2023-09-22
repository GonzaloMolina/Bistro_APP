package Bistro_BackEnd.dao.menu;

import Bistro_BackEnd.model.menu.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDao extends CrudRepository<Menu, Long> {
}
