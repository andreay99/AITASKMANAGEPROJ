import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    public static String getApiKey() throws IOException {
        Properties properties = new Properties();
        
        // Load from classpath (inside src/)
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("config.properties file not found");
            }
            properties.load(input);
        }
        return properties.getProperty("OPENAI_API_KEY");
    }
}