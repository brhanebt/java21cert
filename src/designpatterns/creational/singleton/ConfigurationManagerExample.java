package designpatterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;

class ConfigurationManager {
    private static ConfigurationManager mysqlConnection;
    private Map<String, String> config;

    private ConfigurationManager() {
        config = new HashMap<>();
        // Example config values
        config.put("database.url", "jdbc:mysql://localhost:3306/mydb");
        config.put("database.user", "root");
        config.put("database.password", "password");
    }

    public static synchronized ConfigurationManager getMysqlConnection() {
        if (mysqlConnection == null) {
        	mysqlConnection = new ConfigurationManager();
        }
        return mysqlConnection;
    }

    public String get(String key) {
        return config.get(key);
    }

    public void set(String key, String value) {
        config.put(key, value);
    }
}

public class ConfigurationManagerExample {
    public static void main(String[] args) {
        ConfigurationManager config = ConfigurationManager.getMysqlConnection();
        System.out.println("DB URL: " + config.get("database.url"));
        System.out.println("DB User: " + config.get("database.user"));
        // Set a new config value
        config.set("app.name", "MyApp");
        System.out.println("App Name: " + config.get("app.name"));
    }
}
