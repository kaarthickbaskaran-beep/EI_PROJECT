package SD;
import java.util.logging.Logger;

public class ConfigurationManager {
    private static volatile ConfigurationManager instance;  
    private static final Logger logger = AppLogger.getLogger();

    
    private String appTheme = "Light";
    private int timeout = 30;

    
    private ConfigurationManager() {
        logger.info("ConfigurationManager initialized.");
    }

    
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    
    public String getAppTheme() {
        return appTheme;
    }

    public void setAppTheme(String theme) {
        if (theme == null || theme.isBlank()) {
            logger.warning("Invalid theme provided.");
            throw new IllegalArgumentException("Theme cannot be null or blank.");
        }
        this.appTheme = theme;
        logger.info("App theme updated to: " + theme);
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        if (timeout <= 0) {
            logger.warning("Invalid timeout provided.");
            throw new IllegalArgumentException("Timeout must be positive.");
        }
        this.timeout = timeout;
        logger.info("Timeout updated to: " + timeout);
    }

    public void showConfig() {
        logger.info("Configuration -> Theme: " + appTheme + ", Timeout: " + timeout + "s");
    }
}
