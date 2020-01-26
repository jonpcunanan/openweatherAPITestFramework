package config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class ConfigLoader {
    private Configuration config;

    public ConfigLoader() throws ConfigurationException {
        loadConfig();
    }
    public void loadConfig() throws ConfigurationException {
        File propertiesFile = new File(
                getClass().getClassLoader().getResource("app.properties").getFile()
        );
        config = loadConfig(propertiesFile);
    }

    public static Configuration loadConfig(File propertiesFile) throws ConfigurationException {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder;
        builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                .configure(params.fileBased()
                        .setFile(propertiesFile));
        Configuration config = null;
        try {
            //logger.debug("Loading Properties File: " + propertiesFile);
            config = builder.getConfiguration();

        } catch (ConfigurationException cex) {
            //logger.error(cex.getMessage());
            throw cex;
        }
        return config;
    }

    public Configuration getConfig() {
        return config;
    }
}
