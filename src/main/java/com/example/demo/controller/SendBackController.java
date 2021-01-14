package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.*;
import com.example.demo.utils.Response;
import io.github.biezhi.anima.Anima;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class SendBackController {
    @RequestMapping(value = "/searchpatient")
    public String SearchPatient(@RequestBody Map<String,String> param){
        int MHN = Integer.parseInt(param.get("mhn"));
        List<RegInformation> listEleven = Anima.select().from(RegInformation.class).where("病历号=?",MHN).where("诊断状态=?",2).all();
        List<HashMap> response = new LinkedList<>();
        if(listEleven.size()==0){
            HashMap<String, Object> responseMap = new HashMap<>();
            responseMap.put("responsecode",123);
            responseMap.put("sendMediclNumber","");
            responseMap.put("sendName","");
            responseMap.put("sendRegID","");
            responseMap.put("sendIDcard","");
            response.add(responseMap);
        }else{
            HashMap<String, Object> responseMap = new HashMap<>();
            responseMap.put("responsecode",200);
            responseMap.put("sendMediclNumber",listEleven.get(0).getMedHisID());
            responseMap.put("sendName",listEleven.get(0).getName());
            responseMap.put("sendRegID",listEleven.get(0).getRegID());
            responseMap.put("sendIDcard",listEleven.get(0).getIdcard());
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/confirmsendback")
    public String ConfirmSendback(@RequestBody Map<String,String> param){
        int confirmreg = Integer.parseInt(param.get("confirmReg"));
        int result = Anima.update().from(RegInformation.class).set("诊断状态",4).where("挂号ID=?",confirmreg).execute();
        List<HashMap> response = new LinkedList<>();
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("Coderesponse",123);
        response.add(responseMap);
        return JSON.toJSONString(new Response<>(response));


    }
}
