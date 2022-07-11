package com.itguigu.boot.bean;

import lombok.*;

@Data
//lombok插件的注解，编译时自动生成get，set等方法
@ToString
//lombok插件的注解，编译时自动生成ToString等方法
@NoArgsConstructor
//lombok插件的注解，无参构造器
@AllArgsConstructor
//lombok插件的注解，全参构造器
@EqualsAndHashCode
//lombok插件的注解，equals和hashcode方法
public class Pet {
    private String name;

}
