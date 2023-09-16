package com.itineric;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link MyConfiguration}.
 */
public class MyConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'myConfiguration'.
   */
  public static BeanDefinition getMyConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MyConfiguration.class);
    beanDefinition.setTargetType(MyConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(MyConfiguration.class);
    beanDefinition.setInstanceSupplier(MyConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'myBean'.
   */
  private static BeanInstanceSupplier<MyBean> getMyBeanInstanceSupplier() {
    return BeanInstanceSupplier.<MyBean>forFactoryMethod(MyConfiguration.class, "myBean")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(MyConfiguration.class).myBean());
  }

  /**
   * Get the bean definition for 'myBean'.
   */
  public static BeanDefinition getMyBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(MyBean.class);
    beanDefinition.setInstanceSupplier(getMyBeanInstanceSupplier());
    return beanDefinition;
  }
}
