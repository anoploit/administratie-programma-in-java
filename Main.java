import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/*
   Coded by anoploit
   10/05/2023
 */

public class Main {
    public static void main(String[] args) {
        // Een JSONParser object aanmaken om de string van het JSON bestand te kunnen
        // interpreteren.
        JSONParser parser = new JSONParser();

        System.out.println("hoi");

        try {
            // De JSON data inlezen vanuit het bestand 'vehicles.json'. Uiteraard letten op
            // je bestandspaden.
            Object obj = parser.parse(new FileReader("vehicles.json"));

            // De JSON data is opgebouwd uit een JSONObject met daarin een JSONArray van
            // vehicles. De data uit de JSON file moet worden omgezet tot Java-objecten,
            // maar omdat er niet van tevoren een datatype bekend is moet alles worden
            // getypecast.
            JSONObject json = (JSONObject) obj;
            JSONArray vehicles = (JSONArray) json.get("vehicles");

            // Voor elk vehicle in de array
            for (Object o : vehicles) {
                // Het vehicle omzetten naar een JSONObject (wederom ook weer typecasten)
                JSONObject vehicle = (JSONObject) o;

                // De verschillende eigenschappen van het vehicle printen
                System.out.println("Type: " + vehicle.get("type"));
                System.out.println("Make: " + vehicle.get("make"));
                System.out.println("Model: " + vehicle.get("model"));
                System.out.println("Year: " + vehicle.get("year"));
                System.out.println("Color: " + vehicle.get("color"));
                System.out.println("Price: " + vehicle.get("price"));
                System.out.println("Length: " + vehicle.get("length"));

                // De cargo_compartments van het vehicle omzetten naar een JSONArray
                JSONArray compartments = (JSONArray) vehicle.get("cargo_compartments");

                // Voor elke cargo_compartment in de array
                for (Object o2 : compartments) {
                    // Het cargo_compartment omzetten naar een JSONObject
                    JSONObject compartment = (JSONObject) o2;

                    // De naam en capaciteit van het cargo_compartment printen
                    System.out.println("Cargo Compartment: " + compartment.get("name"));
                    System.out.println("Capacity: " + compartment.get("capacity"));

                    // De inhoud van het cargo_compartment omzetten naar een JSONArray
                    JSONArray contents = (JSONArray) compartment.get("contents");

                    // Voor elke inhoud in de array
                    System.out.println("Contents:");
                    for (Object o3 : contents) {
                        // De inhoud van het cargo_compartment printen
                        System.out.println(o3);
                    }
                }
                System.out.println();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
