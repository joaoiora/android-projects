package com.example.joao.desafioemprestimo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Joao on 21/10/2017.
 */
public class Dates {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static Date parse(final String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String format(Date date) {
        if (date == null) {
            return "";
        }
        return sdf.format(date);
    }

}
