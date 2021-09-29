package br.com.shopping.cart.commons.shopping.cart.commons.model;

public interface BaseError {

    String getCode();

    String getDescription();

    boolean getAcceptParameters();

    default boolean disableStackTraceLog() {
        return false;
    }
}
