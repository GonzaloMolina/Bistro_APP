package Bistro_BackEnd.servicios.excepciones;

public class ExcepcionIdInvalida extends Exception{
    public ExcepcionIdInvalida(Long id) {
        super("Invalid ID "+ id);
    }

}
