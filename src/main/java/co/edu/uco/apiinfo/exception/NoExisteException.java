package co.edu.uco.apiinfo.exception;

public class NoExisteException extends RuntimeException {

    public NoExisteException(String mensaje){
        super(mensaje);
    }

}
