package com.solvd.Uver.exception;

public class MyBatisException extends RuntimeException {
    public MyBatisException(String message) {
        super(message);
    }

    public MyBatisException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyBatisException(Throwable cause) {
        super(cause);
    }
}
