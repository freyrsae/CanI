package FormObjects;

import Utils.DateUtils;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: freyr
 * Date: 9/11/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatesOfBirth {

    public Integer day1, month1, year1;
    public Integer day2, month2, year2;

    public DatesOfBirth(){}

    public DatesOfBirth(Integer day1, Integer month1, Integer year1, Integer day2, Integer month2, Integer year2) {
        this.day1 = day1;
        this.month1 = month1;
        this.year1 = year1;
        this.day2 = day2;
        this.month2 = month2;
        this.year2 = year2;
    }

    public DatesOfBirth(String d1, String d2){
        this(
                DateUtils.extractDay(d1),
                DateUtils.extractMonth(d1),
                DateUtils.extractYear(d1),
                DateUtils.extractDay(d2),
                DateUtils.extractMonth(d2),
                DateUtils.extractYear(d2)
                );
    }
}
