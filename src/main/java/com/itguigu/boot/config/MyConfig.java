package com.itguigu.boot.config;

import com.itguigu.boot.bean.Car;
import com.itguigu.boot.bean.Pet;
import com.itguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

import javax.naming.NamingEnumeration;

/*
* 1. 配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
* 2. 配置类MyConfig本身也是一个组件
* 3. proxyBeanMethods: 是不是代理bean的方法
* 4.@Import({User.class,Pet.class})
*       在容器自动创建出这两个类型的组件，默认组件名字为全类名
* */

@Import({User.class,Pet.class})
@Configuration(proxyBeanMethods = true)  //告诉springboot这是一个配置类 == 配置文件
//@ConditionalOnBean(name="tom01") //存在tom01组件时才能注入user01组件，也可作用在类上
//@ConditionalOnMissingBean(name = "tom") //当此类中不存在tom时，才能注入类中的组件
@EnableConfigurationProperties(Car.class)
//1. 开启Car属性配置绑定功能
//2. 把这个car这个组件自动注册到容器中
//例如： 导进来的包需要配置properties文件中的属性，不能通过@Component来加入容器
@ImportResource("classpath:beans.xml")   //将xml文件重新解析(springboot不解析xml文件)，放到容器当中，生成组件
public class MyConfig {

    @Bean //给容器中添加组件，以方法名作为组件的id。返回类型就是组件类型。返回的值就是组件在容器中的实例
    public User user01(){

//        若是proxyBeanMethods = true，可以实现，user组件依赖了Pet组件
//        若是proxyBeanMethods = false，虽然可以实现，但这是重新定义的一个Pet，并不是容器中的Pet
        User zhangsan = new User("张三", 18);
        zhangsan.setPet(pet01());
        return zhangsan;
    }

    @Bean("tom01") //可以自定义名字   //讲解@Conditional注解时加上注释
    public Pet pet01(){
        return new Pet("tomcat");
    }
}
