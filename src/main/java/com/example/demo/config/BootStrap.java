package com.example.demo.config;

import io.github.biezhi.anima.Anima;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by LSK.Reno on 2019/5/17 22:17.
 */
@Component
public class BootStrap implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception{
        Anima.open("jdbc:mysql://127.0.0.1:3306/hospital?serverTimezone=UTC", "root", "zhouxin19991010");
    }
}
