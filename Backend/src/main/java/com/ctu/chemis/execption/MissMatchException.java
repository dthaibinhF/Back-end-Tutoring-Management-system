package com.ctu.chemis.execption;

public class MissMatchException extends RuntimeException {
    public MissMatchException(String message) {
        super(message);
    }

    public MissMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissMatchException(Throwable cause) {
        super(cause);
    }
}
