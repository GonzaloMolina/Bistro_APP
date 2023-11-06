package Bistro_BackEnd.controladores.empleado;

import Bistro_BackEnd.servicios.empleado.MozoService;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.excepciones.InvalidOrNullFieldException;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mozo")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.OPTIONS,RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
public class ControladorDeMozo {
    @Autowired
    private MozoService mozoService;

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = MozoResponseBodyList.class, responseContainer = "List"),
    })
    public ResponseEntity listMozos() {
        try{ return new ResponseEntity<>(mozoService.listAll(), HttpStatus.OK); }
        catch(Exception error) { return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = MozoResponseBody.class),
    })
    public ResponseEntity getMozo(@PathVariable Integer id) throws ExcepcionIdInvalida {
        try{ return new ResponseEntity<>(mozoService.getById(id), HttpStatus.OK); }
        catch(Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //get_ONE
    @GetMapping(value = "/{id}/solicitudes", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = MozoResponseBody.class),
    })
    public ResponseEntity getMozoSolicitudes(@PathVariable Integer id) throws ExcepcionIdInvalida {
        try{ return new ResponseEntity<>(mozoService.getRequestById(id), HttpStatus.OK); }
        catch(Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //LogIn
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/logIn", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity logIn(@RequestBody LogInBody body) throws ExcepcionIdInvalida, InvalidOrNullFieldException {
        try {
            LogInResponseBody res = mozoService.logIn(body);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }
}
