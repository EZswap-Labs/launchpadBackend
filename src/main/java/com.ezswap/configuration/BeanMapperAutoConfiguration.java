package com.ezswap.configuration;

import com.ezswap.common.beanmapper.BeanMapperTemplate;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnClass(ModelMapper.class)
@Configuration
@Slf4j
public class BeanMapperAutoConfiguration {

  private ModelMapper modelMapper(boolean ignoreNull) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper
        .getConfiguration()
        // 是否忽略空属性
        .setSkipNullEnabled(ignoreNull)
        .setAmbiguityIgnored(true)
        .setImplicitMappingEnabled(true)
        .setFullTypeMatchingRequired(false)
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        .setMethodAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
    return modelMapper;
  }

  @ConditionalOnMissingBean(BeanMapperTemplate.class)
  @Bean
  public BeanMapperTemplate beanMapperTemplate() {
    return new BeanMapperTemplate(modelMapper(false), modelMapper(true));
  }
}
