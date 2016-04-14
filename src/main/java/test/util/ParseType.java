package test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by on 08.04.16.
 */
public class ParseType {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseStringToDate(String date) {
        Date fDate;
        try {
            fDate = dateFormat.parse(date);
        } catch (ParseException e) {
            fDate = null;
        }
        return fDate;
    }

    public static Double parseStringToDouble(String salary) {

        Double dSalary;
        try {
            dSalary = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            dSalary = null;
        }

        return dSalary;
    }

    public static Integer parseStringToInteger(String id) {

        Integer integer;
        try {
            integer = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            integer = null;
        }
        return integer;
    }
}
