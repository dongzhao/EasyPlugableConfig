package dzhao.common.config.api;

import dzhao.common.config.api.domain.ConfigSourceType;

public interface ConfigServiceFactory {
    ConfigService getConfigService(ConfigSourceType type);
}
