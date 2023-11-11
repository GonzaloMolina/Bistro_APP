package Bistro_BackEnd.controladores.mesa;

import Bistro_BackEnd.controladores.orden.OrdenBodyResponse;
import Bistro_BackEnd.controladores.orden.OrdenBodyResponseList;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import Bistro_BackEnd.servicios.mesa.MesaServiceImp;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
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
    public ResponseEntity listTable() {
        try { return new ResponseEntity<> (mesaService.listAll(), HttpStatus.OK); }
        catch (Exception error) { return new ResponseEntity<> (error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = OrdenBodyResponse.class),
    })
    public ResponseEntity getTable(@PathVariable Integer id) throws ExcepcionIdInvalida {
        try{ return new ResponseEntity<>(mesaService.getById(id), HttpStatus.OK); }
        catch (Exception error){ return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }

    //Release
    @GetMapping(value = "/{id}/release", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = OrdenBodyResponse.class),
    })
    public ResponseEntity releaseTable(@PathVariable Integer id) throws ExcepcionIdInvalida {
        try{ return new ResponseEntity<>(mesaService.releaseTable(id), HttpStatus.OK); }
        catch (Exception error) { return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST); }
    }
}
