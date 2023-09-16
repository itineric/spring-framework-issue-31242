package com.itineric;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor
{
  private static final Logger _logger = LoggerFactory.getLogger(MyBeanFactoryPostProcessor.class);
  @Override
  public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory)
    throws BeansException
  {
    for (final String name : beanFactory.getBeanDefinitionNames())
    {
      if ("myBean".equals(name))
      {
        final BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
        _logger.info("name: " + name);
        _logger.info("getBeanClassName: " + beanDefinition.getBeanClassName());
      }
    }
  }
}
