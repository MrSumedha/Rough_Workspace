package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Solution {

	public static void main(String[] args) {
		String DEFAULT_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
		Date now = new Date();
		SimpleDateFormat sdfLocal = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		sdfLocal.setTimeZone(TimeZone.getDefault());
		SimpleDateFormat sdfIst = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		sdfIst.setTimeZone(TimeZone.getTimeZone("IST"));
		try {
			System.out.println(sdfLocal.parse(sdfIst.format(now)));
		} catch (ParseException e) {
		}
	}
}
