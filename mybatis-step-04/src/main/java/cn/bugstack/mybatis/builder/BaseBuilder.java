package cn.bugstack.mybatis.builder;

import cn.bugstack.mybatis.session.Configuration;

/**
 * @author sonarone
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
