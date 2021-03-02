package mappe.del1.hospital.exception;

import java.io.Serial;

public class RemoveException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public RemoveException(String message) {
        super(message);
    }
}
