package dzhao.common.config.plugins.property;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dzhao.common.config.api.ConfigSource;
import org.junit.Before;

public class AbstractTest {
    protected Injector injector;
    protected ConfigSource service;
    @Before
    public void setUp(){
        injector = Guice.createInjector(new TestModule());
        service = injector.getInstance(ConfigSource.class);
    }
}
