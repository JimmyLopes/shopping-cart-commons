package br.com.shopping.cart.commons.shopping.cart.commons.utils;

import org.slf4j.helpers.MessageFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static br.com.shopping.cart.commons.shopping.cart.commons.utils.Numbers.ZERO;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Strings {

    public static final String EMPTY = "";

    private Strings() {
    }

    public static String formatMessage(String message, Object... parameters) {
        var quantity = countMatches(message, "{}");
        if (isNull(parameters)) {
            parameters = getList(new Object[quantity], ZERO, quantity);
        } else if (parameters.length < quantity) {
            parameters = getList(parameters, parameters.length, quantity);
        }
        var response = MessageFormatter.arrayFormat(message, parameters).getMessage();
        return isNotBlank(response) ? response.trim() : response;
    }

    private static Object[] getList(Object[] parameters, Integer init, Integer end) {
        var parametersList = new ArrayList<>(Arrays.asList(parameters));
        IntStream.range(init, end).forEach(n -> parametersList.add(EMPTY));
        return parametersList.toArray();
    }
}
