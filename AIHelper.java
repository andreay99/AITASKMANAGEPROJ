import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class AIHelper {
    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY;

    static {
        try {
            API_KEY = ConfigLoader.getApiKey();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load API key", e);
        }
    }

    public static String getSuggestions(String prompt) throws IOException {
        // ✅ Construct JSON correctly
        String requestBody = "{" +
        "\"model\": \"gpt-3.5-turbo\", " +
        "\"messages\": [{\"role\": \"user\", \"content\": \"" + prompt.replace("\"", "\\\"") + "\"}], " +
        "\"max_tokens\": 100, " +
        "\"temperature\": 0.7" +
        "}";

        // ✅ Debugging: Print JSON request before sending
        System.out.println("🚀 JSON Request Body:\n" + requestBody);

        // ✅ Create and configure HTTP connection
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setDoOutput(true);

        // ✅ Send JSON request
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // ✅ Read response
        int status = connection.getResponseCode();
        InputStream inputStream = (status < 300) ? connection.getInputStream() : connection.getErrorStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        connection.disconnect();

        return response.toString();
    }

    public static void main(String[] args) {
        try {
            String prompt = "Suggest task prioritization for: 1. Finish report by tomorrow. 2. Fix app bugs.";
            String suggestions = getSuggestions(prompt);
            System.out.println("AI Suggestions:\n" + suggestions);
        } catch (IOException e) {
            System.err.println("Error fetching suggestions: " + e.getMessage());
        }
    }
}