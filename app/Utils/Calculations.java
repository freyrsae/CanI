package Utils;

import Models.CaniResults;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: freyr
 * Date: 9/12/13
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculations {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private static final long fourteenYears = 441806400;  //14*365*24*60*60

    public static CaniResults calculateResult(Integer day1, Integer month1, Integer year1, Integer day2, Integer month2, Integer year2){

        //Calculating the first and last possible dates for example if day is not given, only month and year
        Date firstPossible1 = firstPossible(day1, month1, year1);
        Date lastPossible1 = lastPossible(day1, month1, year1);
        Date firstPossible2 = firstPossible(day2, month2, year2);
        Date lastPossible2 = lastPossible(day2, month2, year2);

        // calculating both possible dates
        Date remarkableDate1 = calculate(firstPossible1, lastPossible2);
        Date remarkableDate2 = calculate(firstPossible2, lastPossible1);

        Date firstRemarkable = remarkableDate1.before(remarkableDate2) ? remarkableDate1 : remarkableDate2;
        Date laterRemarkable = remarkableDate1.before(remarkableDate2) ? remarkableDate2 : remarkableDate1;

        Date current = new Date();

        if(current.after(laterRemarkable)){
            return new CaniResults(1, "", firstRemarkable, laterRemarkable);
        }

        if(current.after(firstRemarkable)){
            return new CaniResults(0, "", firstRemarkable, laterRemarkable);
        }

        if(current.before(firstRemarkable)){
            return new CaniResults(-1, "", firstRemarkable, laterRemarkable);
        }

        return new CaniResults(0, "", firstRemarkable, laterRemarkable);
    }

    private static Date calculate(Date d1, Date d2){

        Date currentDate = new Date();
        Long currentTime = currentDate.getTime();

        Long olderAge = d1.before(d2) ? currentTime - d1.getTime() : currentTime - d2.getTime();
        Long youngerAge = d1.before(d2) ? currentTime - d2.getTime() : currentTime - d1.getTime();

        Long timeUntil = olderAge/1000 - 2*youngerAge/1000 + fourteenYears;

        return new Date(currentTime + timeUntil*1000);
    }

    private static Date firstPossible(Integer d, Integer m, Integer y){

        Integer month = m != null && isMonth(m) ? m : 1;
        Integer day = d != null && d > 0 ? d : 1;

        Date date = null;

        try {
            date = sdf.parse(day + "-" + month + "-" + y);
        } catch (ParseException e) {}

        return date;
    }

    private static Date lastPossible(Integer d, Integer m, Integer y){

        Integer month = m != null && isMonth(m) ? m : 12;
        Integer day = d != null && d > 0 ? d : lastDayOfMonth(month);

        Date date = null;

        try {
            date = sdf.parse(day + "-" + month + "-" + y);
        } catch (ParseException e) {}

        return date;
    }

    private static int lastDayOfMonth(Integer month){

        if(month == null)
            return 0;

        if(month.equals(2))
            return 28;

        if(month.equals(4)
                || month.equals(6)
                || month.equals(9)
                || month.equals(11))
            return 30;

        return 31;

    }

    private static boolean isMonth(Integer month){
        return month != null && month >= 1 && month <= 12;
    }

}
