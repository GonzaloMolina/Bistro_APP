package Bistro_BackEnd.servicios.excepciones;

public class InvalidOrNullFieldException extends Exception {
    public InvalidOrNullFieldException(String fieldName) {
        super("Invalid value or non existing field: "+ fieldName);
    }
}
