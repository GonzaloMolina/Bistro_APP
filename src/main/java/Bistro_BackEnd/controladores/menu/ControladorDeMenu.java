package Bistro_BackEnd.controladores.menu;

import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.menu.MenuService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
public class ControladorDeMenu {

    @Autowired
    private MenuService menuService;

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = MenuResponseBody.class),
    })
    public ResponseEntity<MenuResponseBody> getMenu(@PathVariable Integer id) throws ExcepcionIdInvalida {
        return new ResponseEntity<>(menuService.getById(id), HttpStatus.OK);
    }
}
