package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.RegInformation;
import com.example.demo.model.Department;
import com.example.demo.model.user;
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
import java.util.Date;


@RestController
public class RegController {
    @RequestMapping(value = "/Reg")
    public String Search(@RequestBody Map<String,String> param){
        String idcardid = param.get("patient_idcard");
        List <RegInformation> medhislist = Anima.select().from(RegInformation.class).where("身份证号=?",idcardid).all();

        int newmedhis = Anima.select().bySQL(int.class, "select MAX(病历号) from 患者历次挂号信息").one();

        int code = 0;

        int p_regID = 0;
        int p_medhisid = 0;
        String p_name = "";
        int p_sex =0;
        String p_born = "";
        int p_age = 0;
        String p_address = "";
        String p_currdate = "";
        String p_noon = "";
        int p_departmentid = 0;
        int p_doctorid = 0;
        int p_rankid = 0;
        int p_settletypeid = 0;
        int p_ornot = 0;
        String p_regtime = "";
        int p_clerkID = 0;
        int p_digstate = 0;

        if(medhislist.size()==0){
            code = 123;
            p_medhisid = newmedhis+1;
        }else{
            code = 200;
            p_name = medhislist.get(0).getName();
            p_sex = medhislist.get(0).getSexID();
            p_born = medhislist.get(0).getDatedate();
            p_age = medhislist.get(0).getAge();
            p_address = medhislist.get(0).getAddress();
            p_medhisid = medhislist.get(0).getMedHisID();
        }
        List<HashMap> response = new LinkedList<>();

        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("code",code);
        responseMap.put("p_name",p_name);
        responseMap.put("p_sex",p_sex);
        responseMap.put("p_born",p_born);
        responseMap.put("p_age",p_age);
        responseMap.put("p_address",p_address);
        responseMap.put("p_medhisid",p_medhisid);

        response.add(responseMap);
//        for (RegInformation regInformation:medhislist){
//            String name = regInformation.getName();
//        }
        System.out.println(JSON.toJSONString(new Response<>(code,response)));
        return JSON.toJSONString(new Response<>(code,response));

    }

    @RequestMapping(value = "/departmentOptions",method=RequestMethod.GET)
    public String departmentOptions(){
        List<Department> departmentList = Anima.select().from(Department.class).all();

        List<HashMap> response = new LinkedList<>();
        for (Department department:departmentList){
            HashMap<String, Object> responseMap = new HashMap<>();

            responseMap.put("depID",department.getDepID());
            responseMap.put("depname",department.getDepname());
            //每个HashMap中都有两个键值对
            response.add(responseMap);
        }

        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/doctorOptions")
    public String DocotorOptions(@RequestBody Map<String,String> param){
        int depid = Integer.parseInt(param.get("d_department"));//前端方法传入的键值对
        List<user> usList = Anima.select().from(user.class).where("科室ID=?",depid).all();//Anima调用SQL语句
        List<HashMap> response = new LinkedList<>();
        for (user us:usList){
            HashMap<String, Object> responseMap = new HashMap<>();
            responseMap.put("usID",us.getId());
            responseMap.put("usRealname",us.getRealname());

            response.add(responseMap);
        }

        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/regrankOptions")
    public String RegrankOptions(@RequestBody Map<String,String> param){
        int doctorid = Integer.parseInt(param.get("d_doctor"));
        List<user> userList = Anima.select().from(user.class).where("用户ID=?",doctorid).all();
        List<HashMap> response = new LinkedList<>();
        for(user uss:userList){
            HashMap<String, Object> responseMap = new HashMap<>();
            responseMap.put("rankID",uss.getRankID());
            if(uss.getRankID()==1){
                responseMap.put("rankname","专家号");
            }else {
                responseMap.put("rankname","普通号");
            }
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/addmedhis")
    public String AddAll(@RequestBody Map<String,String> param){

        int papa_idcard = Integer.parseInt(param.get("pa_idcard"));
        String papa_name = param.get("pa_name");
        int papa_sex = Integer.parseInt(param.get("pa_sex"));
        int papa_age = Integer.parseInt(param.get("pa_age"));
        String papa_regdate = param.get("pa_RegDate");
        String papa_address = param.get("pa_Address");
        String papa_noon = param.get("pa_noon");
        String papa_birth = param.get("pa_birth");
        int papa_department = Integer.parseInt(param.get("pa_department"));
        int papa_doctor = Integer.parseInt(param.get("pa_doctor"));
        int papa_rank = Integer.parseInt(param.get("pa_rank"));
        int papa_settlementrank = Integer.parseInt(param.get("pa_settlementrank"));
        int papa_ornot = Integer.parseInt(param.get("pa_ornot"));
        int papa_medhis = Integer.parseInt(param.get("pa_medhis"));

        int newregid = Anima.select().bySQL(int.class, "select MAX(挂号ID) from 患者历次挂号信息").one();
        //String currentdate = String.valueOf(new Date());
        String currenttime = String.valueOf(System.currentTimeMillis());
        int settlerid = Integer.parseInt(param.get("pa_operatorid"));
        int state = 2;

        RegInformation regin = new RegInformation();//新建挂号信息类 插入一条挂号信息
        regin.setRegID(newregid+1);
        regin.setMedHisID(papa_medhis);
        regin.setName(papa_name);
        regin.setSexID(papa_sex);
        regin.setDatedate(papa_birth);
        regin.setAge(papa_age);
        regin.setAddress(papa_address);
        regin.setCurrdate(papa_regdate);
        regin.setNoon(papa_noon);
        regin.setDepartmentid(papa_department);
        regin.setDoctorid(papa_doctor);
        regin.setRankid(papa_rank);
        regin.setSettletypeid(papa_settlementrank);
        regin.setOrnot(papa_ornot);
        regin.setRegtime(currenttime);
        regin.setClerkID(settlerid);
        regin.setIdcard(papa_idcard);
        regin.setDiagnosestate(state);
        regin.save();//Information saved
        List<HashMap> response = new LinkedList<>();
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("code",200);//res[0]的键值对 “code”是键 200是值
        response.add(responseMap);
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/getinvoice",method=RequestMethod.GET)
    public String getinvoice(){
        int invoiceID = (Anima.select().bySQL(int.class, "select MAX(发票ID) from 发票").one())+1;
        List<HashMap> response = new LinkedList<>();
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("invoiceID",invoiceID);
        response.add(responseMap);
        return JSON.toJSONString(new Response<>(response));


    }

}
