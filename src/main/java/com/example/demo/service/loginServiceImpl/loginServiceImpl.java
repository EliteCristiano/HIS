package com.example.demo.service.loginServiceImpl;

import com.example.demo.model.user;
import com.example.demo.dao.userDAO;
import com.example.demo.service.loginService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class loginServiceImpl implements loginService {
    public List<user> getUserList(String userName){
        List<user> userList = userDAO.getUserListByUsername(userName);
        return userList;
    }
    public List<user> getmatchUserList(String userName,String password){
        List<user> matchlist = userDAO.getMatchList(userName,password);
        return matchlist;
    }







}
