package Models;

import Utils.Constants;
import Utils.DateUtils;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: freyr
 * Date: 3/19/13
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class CaniResults {

    private int simpleResult;
    private String textResult;
    private Date firstRemarkable;
    private Date lastRemarkable;

    public CaniResults(){}

    public CaniResults(int simpleResult, String textResult, Date firstPossibleDate, Date lastRemarkable){
        this.simpleResult = simpleResult;
        this.textResult = textResult;
        this.firstRemarkable = firstPossibleDate;
        this.lastRemarkable = lastRemarkable;
    }

    public String getMessage(){
        String message = "";
        if(firstRemarkable.equals(lastRemarkable)){
            message = oneDateMessage();
        }
        else{
            message = twoDatesMessage();
        }

        return message;
    }

    private String oneDateMessage(){

        if(simpleResult > 0)
            return oneDatePossibleMessage();
        if(simpleResult == 0)
            return oneDateMaybeMessage();
        if(simpleResult < 0)
            return oneDateNotMessage();

        return "Something went wrong :(";
    }

    private String twoDatesMessage(){

        if(simpleResult > 0)
            return twoDatesPossibleMessage();
        if(simpleResult == 0)
            return twoDatesMaybeMessage();
        if(simpleResult < 0)
            return twoDatesNotMessage();

        return "This should never happen!";

    }

    private String oneDatePossibleMessage(){
        return "You're good, have been since " + Constants.dateInText.format(lastRemarkable);
    }

    private String oneDateMaybeMessage(){
        return "Wow! Today is the day!";
    }

    private String oneDateNotMessage(){
        return "No way, not until " + Constants.dateInText.format(firstRemarkable);
    }

    private String twoDatesPossibleMessage(){
        return "Yes you can, have been since " + Constants.dateInText.format(lastRemarkable);
    }

    private String twoDatesMaybeMessage(){
        return "Maybe, dates range from " + Constants.dateInText.format(firstRemarkable) + " to " + Constants.dateInText.format(lastRemarkable);
    }

    private String twoDatesNotMessage(){
        return "No way, dates range from " + Constants.dateInText.format(firstRemarkable) + " to " + Constants.dateInText.format(lastRemarkable);
    }
}
