package Bistro_BackEnd.controladores.peticion;

import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.peticion.PeticionService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping("/peticion")
public class ControladorPeticion {

    @Autowired
    private PeticionService service;

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a petition",response = PeticionBodyResponse.class),
    })
    public ResponseEntity<PeticionBodyResponse> getOrden(@PathVariable Integer id) throws ExcepcionIdInvalida {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    //ADD_ONE
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful creation of a petition",response = String.class),
    })
    @PostMapping(value = "/new", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<String> addOrder(@RequestBody PeticionBodyPost ordenBody) throws ExcepcionIdInvalida {
        service.createPeticion(ordenBody);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    //DELETE_ONE exception for id
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/{idEmpleado}/{id}", produces = { "application/json" })
    public ResponseEntity<String> deleteOrder(@PathVariable Integer idEmpleado,@PathVariable Integer id) throws ExcepcionIdInvalida {
        service.deletePeticion(idEmpleado, id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
