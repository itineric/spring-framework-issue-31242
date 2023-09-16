See https://github.com/spring-projects/spring-framework/issues/31242


Expected output is:

```
INFO 1609667 --- [           main] c.itineric.MyBeanFactoryPostProcessor    : name: myBean
INFO 1609667 --- [           main] c.itineric.MyBeanFactoryPostProcessor    : getBeanClassName: com.itineric.MyBean
```

And it is working with following dependency (and previous versions):
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>3.1.1</version>
</dependency>
```

When switching to version 3.1.2
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>3.1.2</version>
</dependency>
```
output changes to (bean class name is now null)
```
INFO 1611385 --- [           main] c.itineric.MyBeanFactoryPostProcessor    : name: myBean
INFO 1611385 --- [           main] c.itineric.MyBeanFactoryPostProcessor    : getBeanClassName: null
```
More precisely, the fault is with the spring-boot version that switches from 6.0.10 to 6.0.11.


To build and reproduce:
> mvn -Pnative package

> target/native-hello-world



## Point of interest:

The AOT generation process of spring boot 6.0.10, generates the following for MyBean inside target/spring-aot/main/sources/com/itineric/MyConfiguration__BeanDefinitions.java
```
  public static BeanDefinition getMyBeanBeanDefinition() {
    Class<?> beanType = MyBean.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getMyBeanInstanceSupplier());
    return beanDefinition;
  }
```

With spring boot 6.0.11 we get:
```
  public static BeanDefinition getMyBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(MyBean.class);
    beanDefinition.setInstanceSupplier(getMyBeanInstanceSupplier());
    return beanDefinition;
  }
```

This makes the bug appear. Changing the generated class from 6.0.11 with the one of 6.0.10 and building the native image again gives the expected output.
