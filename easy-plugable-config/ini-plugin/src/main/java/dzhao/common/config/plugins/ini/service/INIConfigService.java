package dzhao.common.config.plugins.ini.service;

import com.google.inject.Inject;
import dzhao.common.config.api.domain.ConfigSourceType;
import dzhao.common.config.service.AbstractFileConfigService;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.INIConfiguration;

import java.net.URL;

public class INIConfigService extends AbstractFileConfigService{

    @Inject
    public INIConfigService(){
        URL url = INIConfigService.class.getClassLoader().getResource("configuration.ini");
        try {
            configuration = new INIConfiguration(url);
        } catch (ConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public ConfigSourceType getSourceType() {
        return ConfigSourceType.INI;
    }
}
