package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Assess;
import com.example.demo.model.Disease;
import com.example.demo.model.RegInformation;
import com.example.demo.model.medfirst;
import com.example.demo.utils.Response;
import io.github.biezhi.anima.Anima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.patientService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Date;



@RestController
public class DiagnoseController {
    @Autowired
    public patientService patientService;

    @RequestMapping(value = "/Paform")
    public String patientform(@RequestBody Map<String,String> param){
        int doctorid = Integer.parseInt(param.get("doctorID"));
        List<RegInformation> patientList = patientService.getunpatientlist(doctorid);
//        List<RegInformation> patientList = Anima.select().from(RegInformation.class).where("诊断状态=?",2).where("挂号医生ID=?",doctorid).all();
        List<HashMap> response = new LinkedList<>();
        for (RegInformation regi:patientList){
            HashMap<String, Object> responseMap = new HashMap<>();
            responseMap.put("medhisID",regi.getMedHisID());
            responseMap.put("regname",regi.getName());
            responseMap.put("paage",regi.getAge());
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/Diagnosed")
    public String patientforma(@RequestBody Map<String,String> param){
        int doctor = Integer.parseInt(param.get("doctorwho"));
        List<RegInformation> diagnosedList = patientService.getdonepatientlist(doctor);
//        List<RegInformation> diagnosedList = Anima.select().from(RegInformation.class).where("诊断状态=?",1).where("挂号医生ID=?",doctor).all();
        List<HashMap> response = new LinkedList<>();
        for (RegInformation regi:diagnosedList){
            HashMap<String, Object> responsemap = new HashMap<>();
            responsemap.put("medhis",regi.getMedHisID());
            responsemap.put("rename",regi.getName());
            responsemap.put("page",regi.getAge());
            response.add(responsemap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/adddiag")
    public String AddAllDiagnosed(@RequestBody Map<String,String> param){
        int medHis = Integer.parseInt(param.get("da_medhis"));
        List <RegInformation> medhislis = Anima.select().from(RegInformation.class).where("病历号=?",medHis).where("诊断状态=?",2).all();

        int regnum = 0;
        regnum = medhislis.get(0).getRegID();
        String mainmedd = param.get("da_mainmed");
        String nowmedd = param.get("da_nowmed");
        String nowtreat = param.get("da_nowtreat");
        String pastmedd = param.get("da_pastmed");
        String allergyy = param.get("da_allergy");
        String bodycheck = param.get("da_healthcheck");
        String checkadvice = param.get("da_advice");
        String attentionn = param.get("da_careful");
        int statediag = 2;

        medfirst medf = new medfirst();
        medf.setMedhisss(medHis);
        medf.setMainsituation(mainmedd);
        medf.setNowsituation(nowmedd);
        medf.setNowtreatment(nowtreat);
        medf.setPastsit(pastmedd);
        medf.setAllegyhis(allergyy);
        medf.setBodycheck(bodycheck);
        medf.setCheckadvice(checkadvice);
        medf.setAttention(attentionn);
        medf.setMedhisstate(statediag);
        medf.setRegiddd(regnum);
        medf.save();

        List <HashMap> response = new LinkedList<>();
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("code",100);
        response.add(responseMap);

        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/adddisease")
    public String AddDisease(@RequestBody Map<String,String> param){
        String disname = param.get("diseaseName");

        List<Disease> diseaseList = Anima.select().from(Disease.class).where("疾病名称=?",disname).all();
        int disID = diseaseList.get(0).getDiseaseID();

        int BLH = Integer.parseInt(param.get("binglihao"));

        List<RegInformation> regInformationList = Anima.select().from(RegInformation.class).where("病历号=?",BLH).where("诊断状态=?",2).all();
        int Registration = regInformationList.get(0).getRegID();

        Assess assess = new Assess();
        int assessID = (Anima.select().bySQL(int.class, "select MAX(诊断ID) from 诊断评估表").one())+1;
        assess.setAssessID(assessID);
        assess.setAssessRegID(Registration);
        assess.setAssessdiseaseID(disID);
        assess.setAssesskind(1);
        assess.setAssesstype(1);
        Date newdate = new Date();
        assess.setDiseasedate(String.valueOf(newdate));
        assess.setAssessmedID(BLH);
        assess.save();

        List <HashMap> response = new LinkedList<>();

        List<Assess> assessList = Anima.select().from(Assess.class).where("挂号ID=?",Registration).all();
        for (Assess as:assessList){
            HashMap<String, Object> responseMap = new HashMap<>();
            int IDofdisease = as.getAssessdiseaseID();
            List<Disease> diseaseList1 = Anima.select().from(Disease.class).where("疾病ID=?",IDofdisease).all();
            String nameofdisease = diseaseList1.get(0).getDiseasename();
            responseMap.put("DisName",nameofdisease);
            responseMap.put("Assesstype","初诊");
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));

    }
}
