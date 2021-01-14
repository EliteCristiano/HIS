package com.example.demo.service;

import com.example.demo.model.user;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface loginService {
    List<user> getUserList(String userName);
    List<user> getmatchUserList(String userName,String password);
}
