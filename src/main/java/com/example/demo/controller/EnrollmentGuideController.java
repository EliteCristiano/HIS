package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.enrollment_guide;
import com.example.demo.utils.Response;
import io.github.biezhi.anima.Anima;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LSK.Reno on 2019/5/17 22:15.
 */


@RestController
@RequestMapping(value="/EnrollmentGuide")
public class EnrollmentGuideController {

    @RequestMapping(value={"/getEnrollmentGuide"})
    public String getEnrollmentGuide(){
        System.out.println("请求触发的路由：/EnrollmentGuide/getEnrollmentGuide");
        List<enrollment_guide> enrollment_guideList= Anima.select().from(enrollment_guide.class).all();
        List<HashMap> response=new LinkedList<>();

        for (enrollment_guide enrollment_guide:enrollment_guideList) {
            HashMap<String,Object> responseMap = new HashMap<>();
            responseMap.put("title",enrollment_guide.getEnrollment_guide_title() );
            responseMap.put("content",enrollment_guide.getEnrollment_guide_content());
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));

    }


}



















