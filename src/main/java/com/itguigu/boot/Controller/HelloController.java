package com.itguigu.boot.Controller;

import com.itguigu.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody/*返回字符串*/

/*@RestController  相当于上面两个注解*/
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/hello")
    public String handle01(){
        return "hello spring boot 2 !";
    }

    @RequestMapping("/mycar")
    public Car mycar(){
        return car;
    }
}
