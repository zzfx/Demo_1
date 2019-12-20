package com.offcn.dao;

import com.offcn.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    //查询指定用户名的用户
    @Query("select p from Person p where p.name=:name")
    public Person getPerson(@Param("name")String name);

    //模糊查询
    @Query("select p from Person p where p.name like %:name% ")
    public List<Person> getPersonByNameLike(@Param("name")String name);

    //查询名字符合，并且年龄大于12的用户
    @Query("select p from Person p where p.name=?1 and p.age >= ?2")
    public List<Person> getPersonByNameAndAge(@Param("name")String name,@Param("age")Integer age);

    //使用原始sql查询年龄大于45的用户
    @Query(value = "select * from person p where p.age >= ?",nativeQuery = true)
    public List<Person> getPersonByAge(@Param("age")Integer age);


}
