import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String url = "https://dochorizon.klippa.com/api/services/document_capturing/v1/financial";
        String apiKey = "insert API key";

        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("x-api-key", apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            String data = "{\"components\":{\"keyword_matching\":{\"rules\":[{\"id\":\"string\",\"keywords\":[\"string\"],\"regex\":\"string\"}]},\"relation_matching\":{\"assignments\":{\"customer\":{\"fallback_id\":\"string\",\"force_id\":\"string\",\"groups\":[\"string\"]},\"merchant\":{\"fallback_id\":\"string\",\"force_id\":\"string\",\"groups\":[\"string\"]}},\"relations\":[{\"bank_account_number\":\"string\",\"city\":\"string\",\"coc_number\":\"string\",\"country\":\"string\",\"email\":\"string\",\"groups\":[\"string\"],\"id\":\"string\",\"name\":\"string\",\"phone\":\"string\",\"preferred_currency\":\"string\",\"street_name\":\"string\",\"street_number\":\"string\",\"vat_number\":\"string\",\"website\":\"string\",\"zipcode\":\"string\"}]}},\"configuration\":{\"slug\":\"string\"},\"documents\":[{\"content_type\":\"string\",\"data\":\"string\",\"file_id\":\"string\",\"filename\":\"string\",\"page_ranges\":\"string\",\"password\":\"string\",\"url\":\"string\"}],\"preset\":{\"slug\":\"string\"},\"result_mapping\":[null]}";

            connection.setDoOutput(true);
            connection.getOutputStream().write(data.getBytes());

            int responseCode = connection.getResponseCode();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response status code: " + responseCode);
            System.out.println("Response body: " + response.toString());

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
