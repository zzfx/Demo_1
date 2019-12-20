package com.offcn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "tb_person")   //如果数据库中表的名称与该实体类的名称不一致使用该注解
public class Person {

    @Id   //该注解表示对应数据库中该列是注解
    @GeneratedValue   //该注解表示在数据库中注解是自动增长的
//    @Column(name="pid")   //如果数据库中的主键名称与实体类中的不一致时使用该注解
    private Long id;

    @Column(name = "name",nullable =true, length = 225)
    private String name;

    @Column(name="age",nullable = true,length = 3)
    private Integer age;
}
