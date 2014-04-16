package dzhao.common.config.service;


import dzhao.common.config.api.ConfigService;
import dzhao.common.config.api.ConfigServiceFactory;
import dzhao.common.config.api.domain.ConfigSourceType;
import dzhao.common.config.domain.MySampleConfiguration;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ConfigServiceFactoryTest {

    private static ConfigServiceFactory factory = ConfigServiceFactoryImpl.newInstance();

    @Test
    public void sanity(){
        Assert.assertNotNull("null Property plugin service", factory.getConfigService(ConfigSourceType.PROPERTIES));
        Assert.assertNotNull("null xml plugin service", factory.getConfigService(ConfigSourceType.XML));
        Assert.assertNotNull("null ini plugin service", factory.getConfigService(ConfigSourceType.INI));
    }

    @Test
    public void test(){

        ConfigService propertiesConfigservice = factory.getConfigService(ConfigSourceType.PROPERTIES);
        ConfigService xmlConfigservice = factory.getConfigService(ConfigSourceType.XML);
        ConfigService iniConfigservice = factory.getConfigService(ConfigSourceType.INI);

        MySampleConfiguration object = propertiesConfigservice.getConfig(MySampleConfiguration.class);

        // verify primitive types
        Assert.assertEquals("incorrect string key value", "testString", object.getTestStringKey());
        Assert.assertEquals("incorrect boolean key value", true, object.isTestBooleanKey());
        Assert.assertEquals("incorrect int key value", 100, object.getTestIntKey());
        Assert.assertEquals("incorrect char key value", 'A', object.getTestCharKey());
        Assert.assertEquals("incorrect byte key value", 1, object.getTestByteKey());
        Assert.assertEquals("incorrect short key value", 1, object.getTestShortKey());
        Assert.assertEquals("incorrect double key value", 10.15d, object.getTestDoubleKey());
        Assert.assertEquals("incorrect float key value", 10.15f, object.getTestFloatKey());
        Assert.assertEquals("incorrect long key value", 10000L, object.getTestLongKey());
        Assert.assertEquals("incorrect array key value", Arrays.asList("aa", "bb", "cc", "dd") , Arrays.asList(object.getTestArrayKey()));

        // verify Object types
        Assert.assertEquals("incorrect Boolean object key value", Boolean.TRUE, object.getTestBooleanObjectKey());
        Assert.assertEquals("incorrect Integer object key value", Integer.valueOf(100), object.getTestIntObjectKey());
        Assert.assertEquals("incorrect Long object key value", Long.valueOf(10000L), object.getTestLongObjectKey());
        Assert.assertEquals("incorrect FLoat object key value", Float.valueOf(10.15f), object.getTestFloatObjectKey());
        Assert.assertEquals("incorrect Double object key value", Double.valueOf(10.15d), object.getTestDoubleObjectKey());
        Assert.assertEquals("incorrect Short object key value", Short.valueOf("1"), object.getTestShortObjectKey());
        Assert.assertEquals("incorrect Byte object key value", Byte.valueOf("1"), object.getTestByteObjectKey());
        Assert.assertEquals("incorrect List object key value", Arrays.asList("aa", "bb", "cc", "dd"), object.getTestListObjectKey());


    }
}
