package Utils;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: freyr
 * Date: 9/14/13
 * Time: 11:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class Celebrities {

    private static LinkedHashMap<String, String> celebMap = new LinkedHashMap<>();
    public static final String KATE_MIDDLETON = "Kate Middleton";

    public static final String PRINCE_WILLIAM = "Prince William";
    public static final String KIM_KARDASHIAN = "Kim Kardashian";
    public static final String KANYE_WEST = "Kanye West";
    public static final String MILEY_CYRUS = "Miley Cyrus";
    public static final String PRINCE_HARRY = "Prince Harry";
    public static final String LEA_MICHELE = "Lea Michele";
    public static final String BEYONCE_KNOWLES = "Beyonce Knowles";
    public static final String ANGELINA_JOLIE = "Angelina Jolie";
    public static final String JENNIFER_GARNER = "Jennifer Garner";
    public static final String BEN_AFFLECK = "Ben Affleck";
    public static final String JENNIFER_ANISTON = "Jennifer Aniston";
    public static final String HEIDI_KLUM = "Heidi Klum";
    public static final String SELENA_GOMEZ = "Selena Gomez";
    public static final String REESE_WITHERSPOON = "Reese Witherspoon";
    public static final String MICHAEL_JACKSON = "Michael Jackson";
    public static final String LADY_GAGA = "Lady Gaga";
    public static final String JUSTIN_BIEBER = "Justin Bieber";
    public static final String EMINEM = "Eminem";
    public static final String JOHNNY_DEPP = "Johnny Depp";
    public static final String WILL_SMITH = "Will Smith";
    public static final String KATY_PERRY = "Katy Perry";
    public static final String LEONARDO_DI_CAPRIO = "Leonardo DiCaprio";
    public static final String CRISTIANO_RONALDO = "Cristiano Ronaldo";
    public static final String MARILYN_MANSON = "Marilyn Manson";
    public static final String ROGER_FEDERER = "Roger Federer";
    public static final String LIONEL_MESSI = "Lionel Messi";
    public static final String SHAKIRA = "Shakira";
    public static final String RIHANNA = "Rihanna";
    public static final String AVRIL_LAVIGNE = "Avril Lavigne";
    public static final String BRITNEY_SPEARS = "Britney Spears";
    public static final String ROBERT_PATTINSON = "Robert Pattinson";
    public static final String BRAD_PITT = "Brad Pitt";
    public static final String CAMERON_DIAZ = "Cameron Diaz";
    public static final String ADELE = "Adele";
    public static final String BARACK_OBAMA = "Barack Obama";
    public static final String JUSTIN_TIMBER_LAKE = "Justin Timberlake";
    public static final String BOB_MARLEY = "Bob Marley";
    public static final String AKON = "Akon";
    public static final String RICHIE_MC_CAW = "Richie McCaw";


    public static Map<String, String> getCelebritiesMap(){
        if(!celebMap.isEmpty())
            return celebMap;
        addToMap(celebMap, KATE_MIDDLETON);
        addToMap(celebMap, PRINCE_WILLIAM);
        addToMap(celebMap, KIM_KARDASHIAN);
        addToMap(celebMap, KANYE_WEST);
        addToMap(celebMap, MILEY_CYRUS);
        addToMap(celebMap, PRINCE_HARRY);
        addToMap(celebMap, LEA_MICHELE);
        addToMap(celebMap, BEYONCE_KNOWLES);
        addToMap(celebMap, ANGELINA_JOLIE);
        addToMap(celebMap, JENNIFER_GARNER);
        addToMap(celebMap, BEN_AFFLECK);
        addToMap(celebMap, JENNIFER_ANISTON);
        addToMap(celebMap, HEIDI_KLUM);
        addToMap(celebMap, SELENA_GOMEZ);
        addToMap(celebMap, REESE_WITHERSPOON);
        addToMap(celebMap, MICHAEL_JACKSON);
        addToMap(celebMap, JUSTIN_BIEBER);
        addToMap(celebMap, LADY_GAGA);
        addToMap(celebMap,EMINEM);
        addToMap(celebMap,JOHNNY_DEPP);
        addToMap(celebMap,WILL_SMITH);
        addToMap(celebMap,KATY_PERRY);
        addToMap(celebMap,LEONARDO_DI_CAPRIO);
        addToMap(celebMap,CRISTIANO_RONALDO);
        addToMap(celebMap,MARILYN_MANSON);
        addToMap(celebMap,ROGER_FEDERER);
        addToMap(celebMap, LIONEL_MESSI);
        addToMap(celebMap,SHAKIRA);
        addToMap(celebMap, RIHANNA);
        addToMap(celebMap, AVRIL_LAVIGNE);
        addToMap(celebMap, BRITNEY_SPEARS);
        addToMap(celebMap, ROBERT_PATTINSON);
        addToMap(celebMap, BRAD_PITT);
        addToMap(celebMap, CAMERON_DIAZ);
        addToMap(celebMap, ADELE);
        addToMap(celebMap, JUSTIN_TIMBER_LAKE);
        addToMap(celebMap, BOB_MARLEY);
        addToMap(celebMap, AKON);
        addToMap(celebMap, RICHIE_MC_CAW);

        return celebMap;
    }

    public static  void addToMap(Map<String, String> map, String name){
        map.put(name, getBirthDay(name));
    }

    public static String getBirthDay(String name){

        try{
            Document doc = Jsoup.connect("http://en.wikipedia.org/wiki/" + urlify(name)).get();
            Element bday = doc.select("span.bday").first();
            return bday.text();
        }catch (Exception e) {
            System.out.println(e);
        }

        return "";
    }

    private static String urlify(String s){
        return s.replace(" ", "_");
    }

    public static int firstBreak(int size){
        final int main = size/3;
        final int remainder = size%3 > 0 ? 1 : 0;
        return main + remainder;
    }

    public static int secondBreak(int size){
        final int main = (size/3)*2;
        int extra = 0;
        if(size%3 == 1){
            extra = 1;
        }
        if(size%3 == 2){
            extra = 2;
        }
        return main + extra;
    }

}
