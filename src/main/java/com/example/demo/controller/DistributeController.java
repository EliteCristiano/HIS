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
public class DistributeController {
    @RequestMapping(value = "/searchmedicine")
    public String SearchMedicine(@RequestBody Map<String,String> param){
        int medicalnumber = Integer.parseInt(param.get("medicalno"));
        List<prescribe> prescribeList = Anima.select().from(prescribe.class).where("病历ID=?",medicalnumber).where("处方状态=?",3).all();
        List<HashMap> response = new LinkedList<>();


        if(prescribeList.size()==0){
            HashMap<String, Object> responseMap = new HashMap<>();
            responseMap.put("rescode",123);
            responseMap.put("dismedicinename","");
            responseMap.put("dismedicineprice","");
            responseMap.put("dismedicinenumber","");
            responseMap.put("disdoctor","");
            responseMap.put("disprescribe","");
            response.add(responseMap);
        }else {
            for(prescribe pres:prescribeList){
                int presID = pres.getPrescribeID();
                List<PrescribeDetail> prescribeDetails = Anima.select().from(PrescribeDetail.class).where("成药处方ID=?",presID).all();
                for (PrescribeDetail predet:prescribeDetails){
                    HashMap<String, Object> responseMap = new HashMap<>();

                    int medID = predet.getMedicineID();
                    List<Medicine> medicines = Anima.select().from(Medicine.class).where("药品ID=?",medID).all();
                    String medname = medicines.get(0).getMedicineName();
                    double medprice = medicines.get(0).getMedicineprice();

                    int doctorid = pres.getPresdoctorID();
                    List<user>userList = Anima.select().from(user.class).where("用户ID=?",doctorid).all();
                    String namedoctor=userList.get(0).getRealname();


                    responseMap.put("dismedicinename",medname);
                    responseMap.put("rescode",200);
                    responseMap.put("dismedicineprice",medprice);
                    responseMap.put("dismedicinenumber",predet.getMedicinenumber());
                    responseMap.put("disdoctor",namedoctor);
                    responseMap.put("disprescribe",pres.getPrescribename());

                    response.add(responseMap);
                }
            }
        }
        return  JSON.toJSONString(new Response<>(response));

    }

    @RequestMapping(value = "/distributemedicine")
    public String DistributeMedicine(@RequestBody Map<String,String> param){
        int medhisNo = Integer.parseInt(param.get("medicalhisNo"));
        List<prescribe>prescribeList = Anima.select().from(prescribe.class).where("病历ID=?",medhisNo).where("处方状态=?",3).all();
        for (prescribe pp:prescribeList){
            int preID = prescribeList.get(0).getPrescribeID();
            int result = Anima.update().from(prescribe.class).set("处方状态",4).where("处方ID",preID).execute();
            int Result = Anima.update().from(PrescribeDetail.class).set("明细状态",4).where("成药处方ID",preID).execute();

        }
        List<HashMap> response = new LinkedList<>();
        HashMap<String,Object> responseMap = new HashMap<>();
        responseMap.put("rcode",200);
        response.add(responseMap);
        return  JSON.toJSONString(new Response<>(response));


    }
}
