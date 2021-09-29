package br.com.shopping.cart.commons.shopping.cart.commons.exception;

import br.com.shopping.cart.commons.shopping.cart.commons.model.BaseApplicationError;
import br.com.shopping.cart.commons.shopping.cart.commons.utils.Strings;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -5531865968472944168L;

    private final BaseApplicationError error;

    private final Object[] parameters;

    private final Object data;

    public ServiceException(BaseApplicationError error, Object... parameters) {
        super(Strings.formatMessage(error.getDescription(), parameters));
        this.error = error;
        this.parameters = parameters;
        this.data = null;
    }

    public ServiceException(Object data, BaseApplicationError error, Object... parameters) {
        super(Strings.formatMessage(error.getDescription(), parameters));
        this.error = error;
        this.parameters = parameters;
        this.data = data;
    }

    public ServiceException(Object data, BaseApplicationError error, Throwable cause, Object... parameters) {
        super(Strings.formatMessage(error.getDescription(), parameters), cause);
        this.error = error;
        this.parameters = parameters;
        this.data = data;
    }

    public BaseApplicationError getError() {
        return error;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public Object getData() {
        return data;
    }
}
