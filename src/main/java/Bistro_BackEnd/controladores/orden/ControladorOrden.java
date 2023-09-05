package Bistro_BackEnd.controladores.orden;

import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;
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
@RequestMapping("/orden")
public class ControladorOrden {

    @Autowired
    private OrdenService ordenService;

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = OrdenBodyResponseList.class, responseContainer = "List"),
    })
    public ResponseEntity<List> listOrdenes() {
        return new ResponseEntity<> (ordenService.list(), HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = OrdenBodyResponse.class),
    })
    public ResponseEntity<OrdenBodyResponse> getOrden(@PathVariable Integer id) throws ExcepcionIdInvalida {
        return new ResponseEntity<>(ordenService.getById(id), HttpStatus.OK);
    }

    //ADD_ONE
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/new", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<Integer> addOrder(@RequestBody OrdenBodyPost ordenBody) throws InvalidOrNullFieldException, ExcepcionIdInvalida {
        return new ResponseEntity<>(ordenService.save(ordenBody), HttpStatus.OK);
    }

    //DELETE_ONE exception for id
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<String> deleteOrder(@PathVariable Integer id) throws ExcepcionIdInvalida {
        ordenService.delete(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    //update exception for id and body
    @PutMapping(value = "/", produces = { "application/json" },consumes = { "application/json" })
    public  ResponseEntity updateUser(@RequestBody OrdenBodyPut ordenBody) throws ExcepcionIdInvalida, InvalidOrNullFieldException {
        ordenService.update(ordenBody);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
