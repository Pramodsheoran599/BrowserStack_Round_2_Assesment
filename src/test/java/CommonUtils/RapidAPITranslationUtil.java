package CommonUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class RapidAPITranslationUtil {

    private static final String API_URL = "https://rapid-translate-multi-traduction.p.rapidapi.com/t";
    private static final String API_KEY = System.getenv("RAPID_API_TRANSLATE_KEY");
    private static final String HOST = "rapid-translate-multi-traduction.p.rapidapi.com";


    public static String translate(String text, String sourceLanguage, String targetLanguage) {

        try {
            // Request body
            JSONObject requestBody = new JSONObject();
            requestBody.put("from", sourceLanguage);  // Source language
            requestBody.put("to", targetLanguage);  // Target language
            requestBody.put("q", text);  // Text to be translated

            // Send the request using RestAssured
            Response response = RestAssured.given()
                    .header("Content-Type", "application/json")
                    .header("X-RapidAPI-Host", HOST)
                    .header("X-RapidAPI-Key", API_KEY)
                    .body(requestBody.toString())  // Attach the JSON body
                    .post(API_URL);

            if (response.statusCode() == 200) {

                // Parse the response JSON and extract translated text
                JSONArray jsonResponse = new JSONArray(response.getBody().asString());
                return jsonResponse.getString(0);
            }
            else {
                System.out.println(response.getBody().prettyPrint());
                return "Error: Unable to translate text. Status code: " + response.statusCode();
            }
        }
        catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
