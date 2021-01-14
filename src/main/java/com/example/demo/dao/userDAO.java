package com.example.demo.dao;

import com.example.demo.model.user;
import io.github.biezhi.anima.Anima;

import java.util.List;

public class userDAO {
    public static List<user> getUserListByUsername(String userName){
        return Anima.select().from(user.class).where("登录名=?",userName).all();
    }
    public static List<user> getMatchList(String userName,String password){
        return Anima.select().from(user.class).where("登录名=?",userName).where("密码=?",password).all();
    }
}
