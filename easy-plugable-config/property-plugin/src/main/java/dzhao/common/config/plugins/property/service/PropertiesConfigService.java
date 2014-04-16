package dzhao.common.config.plugins.property.service;

import com.google.inject.Inject;
import dzhao.common.config.api.domain.ConfigSourceType;
import dzhao.common.config.service.AbstractFileConfigService;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.net.URL;

public class PropertiesConfigService extends AbstractFileConfigService{

    @Inject
    public PropertiesConfigService(){
        URL url = PropertiesConfigService.class.getClassLoader().getResource("configuration.properties");
        try {
            configuration = new PropertiesConfiguration(url);
        } catch (ConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public ConfigSourceType getSourceType() {
        return ConfigSourceType.PROPERTIES;
    }
}
