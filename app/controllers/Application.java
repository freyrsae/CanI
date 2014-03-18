package controllers;

import FormObjects.DatesOfBirth;
import Models.CaniResults;
import Utils.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;
import views.html.about;
import views.html.frontPage;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;

public class Application extends Controller {

    private static final Form<DatesOfBirth> datesOfBirthForm = Form.form(DatesOfBirth.class);

    public static Result cani(String d1, String d2){

        DatesOfBirth datesOfBirth = new DatesOfBirth(d1, d2);

        CaniResults results = null;
        if(!"".equals(d1) && !"".equals(d2)){
            results = Calculations.calculateResult(datesOfBirth.day1, datesOfBirth.month1, datesOfBirth.year1,
                                                   datesOfBirth.day2, datesOfBirth.month2, datesOfBirth.year2 );
        }

        return ok(frontPage.render(results, datesOfBirthForm.fill(datesOfBirth)));
    }

    public static Result doCani(){

        DatesOfBirth datesOfBirth = datesOfBirthForm.bindFromRequest().get();

        String d1 = DateUtils.dateString(datesOfBirth.day1, datesOfBirth.month1, datesOfBirth.year1);
        String d2 = DateUtils.dateString(datesOfBirth.day2, datesOfBirth.month2, datesOfBirth.year2);

        return redirect(routes.Application.cani(d1, d2));
    }

    public static Result findBirthDay(String name){
        String bday = Celebrities.getBirthDay(name);
        if("".equals(bday))
            return internalServerError();
        else
            return ok(bday);
    }

    public static Result search(String q){
        String url =  "http://en.wikipedia.org/w/api.php?action=opensearch&format=json&search=" + URLEncoder.encode(q);
        try{
            JSONArray jsonArray = JsonReader.readJsonArrayFromUrl(url);
            return ok(jsonArray.get(1).toString());
        }catch (Exception e){
            System.out.println(e);
            return internalServerError("fail");
        }
    }

    public static Result about(){
        return ok(about.render());
    }

}
