package ru.eltex.app.exception;

public class OrderNotFoundException extends RuntimeException {

    private String errorMessage;

    public OrderNotFoundException() {
        errorMessage = "{" +
                        "error:\"OrderNotFound\"" +
                        "}";
    }

    @Override
    public String toString() {
        return errorMessage;
    }

    @Override
    public String getMessage() {
        return "error: OrderNotFound";
    }
}
