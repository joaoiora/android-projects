package br.ucb.desafioacademia.utils;

/**
 * Created by João Carlos Iora on 01/09/17.
 */
public class StringUtils {

    /**
     * @param string
     * @return
     */
    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }

    /**
     *
     * @param string
     * @return
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

}
