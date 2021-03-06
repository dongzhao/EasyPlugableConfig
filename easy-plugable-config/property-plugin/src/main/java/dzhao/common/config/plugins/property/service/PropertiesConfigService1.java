/*
package dzhao.common.config.plugins.property.service;

import com.google.inject.Inject;
import dzhao.common.config.api.ConfigSource;
import dzhao.common.config.api.annotation.ConfigFieldInfo;
import dzhao.common.config.api.annotation.ConfigInfo;
import dzhao.common.config.api.domain.ConfigObject;
import dzhao.common.config.api.domain.ConfigSourceType;
import dzhao.common.config.util.ConfigUtil;
import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Map;

public class PropertiesConfigService1 implements ConfigSource{

    private static String DOT = ".";

    //private PropertiesConfiguration configuration;
    private AbstractConfiguration configuration;

    @Inject
    public PropertiesConfigService1(){
        URL url = PropertiesConfigService1.class.getClassLoader().getResource("configuration.properties");
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

    @Override
    public <T extends ConfigObject> T getConfig(Class<T> clazz) {
        T configuration = null;
        try {
            configuration = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        ConfigInfo info = clazz.getAnnotation(ConfigInfo.class);

        StringBuilder configKeyPrefix = new StringBuilder();

        String prefix = info.prefix().trim();
        if(prefix.isEmpty()){
            prefix = ConfigUtil.format(clazz.getSimpleName(), DOT);
        }
        configKeyPrefix.append(prefix + DOT);

        for(Field field : clazz.getDeclaredFields())  {
            ConfigFieldInfo fieldInfo = field.getAnnotation(ConfigFieldInfo.class);
            String fieldName = fieldInfo.prefix().trim();
            if(fieldName.isEmpty()){
                fieldName = ConfigUtil.format(field.getName(), DOT) ;
            }
            field.setAccessible(true);
            Object objValue = getValue(configKeyPrefix.toString() + fieldName, field);
            try {
                field.set(configuration, objValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            field.setAccessible(false);
        }
        return configuration;
    }

    @Override
    public Map<String, Object> asMap() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Object getValue(String key, Field field) {
        synchronized (configuration) {
            return ConfigUtil.getValue(configuration, key, field);
        }
    }
}
*/
