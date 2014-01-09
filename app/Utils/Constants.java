package Utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: freyr
 * Date: 9/11/13
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Constants {

    public static final int defaultYear = 1990;

    public static SimpleDateFormat dateInText = new SimpleDateFormat("MMMM dd, yyyy");

    public static List<String> getMonthList(){

        List<String> list = new ArrayList<String>();
        list.add("");
        for (int i = 1; i <= 12; i++){
            list.add(Integer.toString(i));
        }

        return list;

        //return Arrays.asList(January, February, March, April, May, June,
        //        July, August, September, October, November, December);
    }

    public static List<String> dayList(){
        List<String> list = new ArrayList<String>();
        list.add("");

        for (int i = 1; i <= 31; i++){
            list.add(Integer.toString(i));
        }

        return list;
    }


    public static List<String> yearList(){
        List<String> list = new ArrayList<String>();

        for (int i = 1900; i <= 2000; i++){
            list.add(Integer.toString(i));
        }

        return list;
    }
}
