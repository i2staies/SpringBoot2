package com.itguigu.boot;

import com.itguigu.boot.bean.Pet;
import com.itguigu.boot.bean.User;
import com.itguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @SpringBootApplacation:
 *      这是一个springBoot应用，代表着这是所有springboot程序的入口
 */

//@SpringBootApplication自带类似于@ComponentScan扫描包的注解，两个注解只能存在一个
//主程序所在包及其下面所有子包里面的组件都会被默认扫描
// 若是非要定义在包外，也可通过String[] scanBasePackages() default {};来设置扫描包
@SpringBootApplication(scanBasePackages = "com.itguigu")
public class MainApplication {
    public static void main(String[] args) {
        //1. 返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
//        获取的是默认的加载的组件，例如springmvc中的dispact---等组件
//        2. 查看容器中的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
//        3. 从容器中获取组件,默认单实例
//        User user01 = run.getBean("user01",User.class);
//        User user02 = run.getBean("user01",User.class);
//        System.out.println(user01==user02);
//
//
//        MyConfig bean = run.getBean(MyConfig.class);
//
////        如果@Configuration(proxyBeanMethods = true) 就是代理对象调用方法。
////        springboot总会检查组件是否在容器中存在，保存组件单实例
//        Pet pet = bean.pet01();
//        Pet pet1 = bean.pet01();
//        System.out.println(pet==pet1);

        boolean tom01 = run.containsBean("tom01");
        System.out.println("容器中tom01组件 = " + tom01);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件 = " + user01);

    }
}
