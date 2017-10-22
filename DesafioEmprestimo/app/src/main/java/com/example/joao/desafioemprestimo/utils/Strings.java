package com.example.joao.desafioemprestimo.utils;

/**
 * Created by Joao on 21/10/2017.
 */
public class Strings {

    public static boolean isEmpty(final String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNotEmpty(final String string) {
        return !isEmpty(string);
    }

    public static boolean isBlank(final String string) {
        return string == null || string.trim().isEmpty();
    }

    public static boolean isNotBlank(final String string) {
        return !isBlank(string);
    }

}
