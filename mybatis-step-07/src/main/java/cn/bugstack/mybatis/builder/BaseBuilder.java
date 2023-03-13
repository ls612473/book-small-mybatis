package cn.bugstack.mybatis.builder;

import cn.bugstack.mybatis.session.Configuration;
import cn.bugstack.mybatis.type.TypeAliasRegistry;

/**
 * @author sonarone
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
