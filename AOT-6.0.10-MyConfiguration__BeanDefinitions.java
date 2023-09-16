package com.itineric;

import java.lang.Class;
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
    Class<?> beanType = MyConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
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
    Class<?> beanType = MyBean.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getMyBeanInstanceSupplier());
    return beanDefinition;
  }
}
