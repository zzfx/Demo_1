package com.offcn.controller;

import com.offcn.dao.PersonRepository;
import com.offcn.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    //查询指定用户名的用户
    @RequestMapping("/getPerson")
    public Person getPerson(String name){
        return personRepository.getPerson(name);
    }

    //模糊查询
    @RequestMapping("/getPersonByNameLike")
    public List<Person> getPersonByNameLike(String name){
        return personRepository.getPersonByNameLike(name);
    }

    //查询名字符合，并且年龄大于12的用户
    @RequestMapping("/getPersonByNameAndAge")
    public List<Person> getPersonByNameAndAge(String name,Integer age){
        return personRepository.getPersonByNameAndAge(name,age);
    }

    //使用原始sql查询年龄大于45的用户
    @RequestMapping("/getPersonByAge")
    public List<Person> getPersonByAge(Integer age){
        return personRepository.getPersonByAge(age);
    }
}
