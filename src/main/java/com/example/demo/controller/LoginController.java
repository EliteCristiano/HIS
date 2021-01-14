package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.user;
import com.example.demo.service.loginService;
import com.example.demo.utils.Response;
import io.github.biezhi.anima.Anima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by LSK.Reno on 2019/3/14 16:13.
 */

@RestController
public class LoginController {
    @Autowired
    public loginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String Login(@RequestBody Map<String,String> param) {
        int code = 0;
        System.out.println("请求触发的路由：/login");
        System.out.println("得到的userName参数值：" + param.get("admin_account"));
        System.out.println("得到的password参数值：" + param.get("admin_password"));
        String userName = param.get("admin_account");
        String password = param.get("admin_password");

        List<user> userList= loginService.getUserList(userName);
        List<user> matchUser = loginService.getmatchUserList(userName,password);

//        List<user> userList= Anima.select().from(user.class).where("登录名=?",userName).all();
//        List<user> matchUser= Anima.select().from(user.class).where("登录名=?",userName).where("密码=?",password).all();


        int userID = 0;
        int departmentID = 0;
        String jobID = "";
        String ornot = "";
        String realname = "";
        String type = "";
        if (userList.size()==0){
            code = 123; //123表示无此用户，用户名错误
        }else if (matchUser.size()==0){
            code = 124;
        }else if (matchUser.size()==1){
            code = 200;

            userID = userList.get(0).getId();
            departmentID = userList.get(0).getDepartmentID();
            jobID = userList.get(0).getJobID();
            ornot = userList.get(0).getOrnot();
            realname = userList.get(0).getRealname();
            type = userList.get(0).getType();
        }
        List<HashMap> response = new LinkedList<>();

        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("code",code);
        responseMap.put("userID",userID);
        responseMap.put("departmentID",departmentID);
        responseMap.put("jobID",jobID);
        responseMap.put("ornot",ornot);
        responseMap.put("realname",realname);
        responseMap.put("type",type);
        responseMap.put("userName",userName);

        response.add(responseMap);

        System.out.println(JSON.toJSONString(new Response<>(code,response)));
        return JSON.toJSONString(new Response<>(code,response));
    }
}

