package shuo.laoma.dynamic.c87;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurableStrategyDemo {

	public static IService createService() {
        try {
            Properties prop = new Properties();
            String fileName = "data/c87/config.properties";
            prop.load(new FileInputStream(fileName));
            String className = prop.getProperty("service");
            Class<?> cls = Class.forName(className);
            return (IService) cls.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        IService service = createService();
        service.action();
    }
    
}
