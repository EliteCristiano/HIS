package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.new_entrance_policy;
import com.example.demo.utils.Response;
import io.github.biezhi.anima.Anima;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by LSK.Reno on 2019/5/20 9:39.
 */

@RestController()
@RequestMapping(value = "/newEntrancePolicy")
public class newEntrancePolicyController {
    @RequestMapping(value = {"/getNewEntrancePolicy"})
    public String NewEntrancePolicy(){
        System.out.println("请求触发的路由：/newEntrancePolicy/getNewEntrancePolicy");
        List<new_entrance_policy> newEntrancePolicyList= Anima.select().from(new_entrance_policy.class).all();
        List<HashMap> response=new LinkedList<>();

        for (new_entrance_policy newEntrancePolicy:newEntrancePolicyList) {
            HashMap<String,Object> responseMap = new HashMap<>();
            responseMap.put("title",newEntrancePolicy.getNew_entrance_policy_title() );
            responseMap.put("content",newEntrancePolicy.getNew_entrance_policy_content() );
            responseMap.put("province",newEntrancePolicy.getNew_entrance_policy_province() );

            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value={"/getProvince/getNewEntrancePolicy"})
    public String getParam(@RequestBody Map<String,String> param){
        System.out.println("请求触发的路由：/newEntrancePolicy/getProvince/getNewEntrancePolicy");
        System.out.println("得到的province参数值："+param.get("province"));
        String province = param.get("province");
        List<new_entrance_policy> specialProvince_newEntrancePolicyList= Anima.select().from(new_entrance_policy.class).where("new_entrance_policy_province=?",province ).all();
        List<HashMap> response=new LinkedList<>();

        for (new_entrance_policy newEntrancePolicy:specialProvince_newEntrancePolicyList) {
            HashMap<String,Object> responseMap = new HashMap<>();
            responseMap.put("title",newEntrancePolicy.getNew_entrance_policy_title() );
            responseMap.put("content",newEntrancePolicy.getNew_entrance_policy_content() );
            responseMap.put("province",newEntrancePolicy.getNew_entrance_policy_province() );

            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }








}
