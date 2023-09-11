package Bistro_BackEnd.controladores.mesa;

import Bistro_BackEnd.controladores.orden.OrdenBodyResponse;
import Bistro_BackEnd.controladores.orden.OrdenBodyResponseList;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.mesa.MesaServiceImp;
import Bistro_BackEnd.servicios.orden.OrdenService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping("/mesa")
public class ControladorMesa {

    @Autowired
    private MesaServiceImp mesaService;

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = OrdenBodyResponseList.class, responseContainer = "List"),
    })
    public ResponseEntity<List> listOrdenes() {
        return new ResponseEntity<> (mesaService.listAll(), HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = OrdenBodyResponse.class),
    })
    public ResponseEntity<MesaBodyResponse> getOrden(@PathVariable Integer id) throws ExcepcionIdInvalida {
        return new ResponseEntity<>(mesaService.getById(id), HttpStatus.OK);
    }

}
