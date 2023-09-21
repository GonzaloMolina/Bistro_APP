package Bistro_BackEnd.servicios.peticion;

import Bistro_BackEnd.controladores.peticion.PeticionBodyPost;
import Bistro_BackEnd.controladores.peticion.PeticionBodyResponse;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;

public interface PeticionService {

    PeticionBodyResponse getById(Integer id) throws ExcepcionIdInvalida;
    void createPeticion(PeticionBodyPost body) throws ExcepcionIdInvalida;
    void deletePeticion(Integer idEmpleado, Integer id) throws ExcepcionIdInvalida;
}
