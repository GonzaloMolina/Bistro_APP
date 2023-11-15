package Bistro_BackEnd.controladores.restaurante;

import Bistro_BackEnd.controladores.empleado.LogInBody;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;
import Bistro_BackEnd.servicios.restaurante.RestauranteService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping("/restaurante")
public class ControladorRestaurante {
    @Autowired
    private RestauranteService service;

    //LogIn
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/logIn", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity logIn(@RequestBody LogInBody body) throws InvalidOrNullFieldException {
        try{ return new ResponseEntity<>(service.logIn(body), HttpStatus.OK); }
        catch (Exception error) { return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //get_info
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/getInfo", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity getInfo(@RequestBody LogInBody body) throws InvalidOrNullFieldException {
        try{ return new ResponseEntity<>(service.getInfo(body), HttpStatus.OK); }
        catch (Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //Put_request
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PutMapping(value = "/updateState", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity updateState(@RequestBody StateBody body) throws InvalidOrNullFieldException {
        try{
            return new ResponseEntity<>(service.updateState(body), HttpStatus.OK);
        }
        catch (Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //Post_createMozo
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/employee", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity createEmployee(@RequestBody MozoBody body) throws InvalidOrNullFieldException {
        try{
            return new ResponseEntity<>(service.createEmployee(body), HttpStatus.OK);
        }
        catch (Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //Delete_employee
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/deleteEmployee", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity deleteEmployee(@RequestBody DeleteBody body) throws InvalidOrNullFieldException {
        try{
            return new ResponseEntity<>(service.deleteEmployee(body), HttpStatus.OK);
        }
        catch (Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //Post_createMesa
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/table", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity createTable(@RequestBody MesaBody body) throws InvalidOrNullFieldException {
        try{
            return new ResponseEntity<>(service.createTable(body), HttpStatus.OK);
        }
        catch (Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //Post_createMesa
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/register", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity Register(@RequestBody RestauranteBody body) throws InvalidOrNullFieldException {
        try{
            service.register(body);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }
        catch (Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //Delete_mesa
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/deleteTable", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity deleteTable(@RequestBody DeleteBody body) throws InvalidOrNullFieldException {
        try{
            return new ResponseEntity<>(service.deleteTable(body), HttpStatus.OK);
        }
        catch (Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }


}
