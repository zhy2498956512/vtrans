package com.example.vtrans.dao;

import com.example.vtrans.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("SELECT * FROM b_user WHERE user_mail = #{mail}")
    User testingMail(@Param("mail") String mail);

    @Select("SELECT * FROM b_user WHERE user_mail = #{mail} and user_pass = #{pass}")
    User getUser(@Param("mail") String mail,@Param("pass") String pass);

}
