package Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: freyr
 * Date: 9/13/13
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateUtils {

    private final static String minus = "-";

    public static String dateString(Integer d, Integer m, Integer y){

        StringBuilder sb = new StringBuilder();
        sb.append(y != null ? String.format("%04d", y) : "0000");
        sb.append(minus);
        sb.append(m != null ? String.format("%02d", m) : "00");
        sb.append(minus);
        sb.append(d != null ? String.format("%02d", d) : "00");

        return sb.toString();
    }

    public static Integer extractYear(String d){ return extractInterval(d, 0, d.indexOf(minus)); }
    public static Integer extractMonth(String d){ return extractInterval(d, d.indexOf(minus) + 1, d.lastIndexOf(minus)); }
    public static Integer extractDay(String d){ return extractInterval(d, d.lastIndexOf(minus) + 1, d.length()); }

    private static Integer extractInterval(String d, int start, int stop){
        try{
            return Integer.valueOf(d.substring(start, stop));
        }catch (Exception e){}

        return Constants.defaultYear;
    }

    public static String formatDateToHuman(String s){
        return extractDay(s) + "." + extractMonth(s) + "." + extractYear(s);
    }

}
