package com.itguigu.boot.Controller;

import com.itguigu.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody/*返回字符串*/
@Slf4j
/*@RestController  相当于上面两个注解*/
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/hello")
    public String handle01(){
        log.info("日志进来了！");
        return "hello spring boot 2 !";
    }

    @RequestMapping("/mycar")
    public Car mycar(){
        return car;
    }
}
