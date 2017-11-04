package com.example.joao.desafiocotacao;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class DateUtils {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static Date toDate(long epoch) {
		return new Date(epoch * 1000);
	}

	public static String toString(Date date) {
		return sdf.format(date);
	}


}
