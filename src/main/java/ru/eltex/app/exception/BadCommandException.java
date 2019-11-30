package ru.eltex.app.exception;

public class BadCommandException extends RuntimeException {

    private String errorMessage;

    public BadCommandException() {
        errorMessage = "{" +
                       "error:\"BadCommand\"" +
                       "}";
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
