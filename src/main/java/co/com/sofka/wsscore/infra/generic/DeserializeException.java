package co.com.sofka.wsscore.infra.generic;

public class DeserializeException extends RuntimeException {
    public DeserializeException(Throwable cause) {
        super(cause);
        System.out.println("infra 12" + cause);
    }
}