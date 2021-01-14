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
public class PrescribeController {
    @RequestMapping(value = "/UndiagnosedPatient")
    public String UndiagnosedPatient(@RequestBody Map<String,String> param){
        int doccID = Integer.parseInt(param.get("docID"));
        List<RegInformation> patientList = Anima.select().from(RegInformation.class).where("诊断状态=?",2).where("挂号医生ID=?",doccID).all();
        List<HashMap> response = new LinkedList<>();
        for (RegInformation regi:patientList){
            HashMap<String, Object> responseMap = new HashMap<>();
            responseMap.put("BLID",regi.getMedHisID());
            responseMap.put("prename",regi.getName());
            responseMap.put("preage",regi.getAge());
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/DiagnosedPatient")
    public String DiagnosedPatient(@RequestBody Map<String,String> param){
        int doccid = Integer.parseInt(param.get("docid"));
        List<RegInformation> diagnosedList = Anima.select().from(RegInformation.class).where("诊断状态=?",1).where("挂号医生ID=?",doccid).all();
        List<HashMap> response = new LinkedList<>();
        for (RegInformation regi:diagnosedList){
            HashMap<String, Object> responsemap = new HashMap<>();
            responsemap.put("bloid",regi.getMedHisID());
            responsemap.put("rename",regi.getName());
            responsemap.put("page",regi.getAge());
            response.add(responsemap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/Addprescribe")
    public String Addprescribe(@RequestBody Map<String,String> param){
        int presmedhisnumber = Integer.parseInt(param.get("pres_medhisnumber"));
        String prescribename = param.get("pres_name");

        List<RegInformation> listone = Anima.select().from(RegInformation.class).where("病历号=?",presmedhisnumber).where("诊断状态=?",2).all();

        int regNumber = listone.get(0).getRegID();
        int prescribeid = Anima.select().bySQL(int.class, "select MAX(处方ID) from 处方表").one();
        int prescribeID = prescribeid+1;
        int doctorID = Integer.parseInt(param.get("pres_doctorid"));
        int prescribeState = 1;

        prescribe newprescribe = new prescribe();
        newprescribe.setPrescribeID(prescribeID);
        newprescribe.setPrescribename(prescribename);
        newprescribe.setPresdoctorID(doctorID);
        newprescribe.setPresmedhisID(presmedhisnumber);
        newprescribe.setPresRegID(regNumber);
        newprescribe.setPresstate(prescribeState);
        newprescribe.save();

        List<HashMap> response = new LinkedList<>();
        List<prescribe> prescribeList = Anima.select().from(prescribe.class).where("病历ID=?",presmedhisnumber).where("处方状态=?",1).all();
        List<prescribe> doneList = Anima.select().from(prescribe.class).where("病历ID=?",presmedhisnumber).where("处方状态=?",2).all();

        for(prescribe presc:prescribeList){
            HashMap<String,Object> responseMap = new HashMap<>();
            String state = "";
            if(presc.getPresstate()==1){
                state = "暂存";
            }else if(presc.getPresstate()==2){
                state = "已开立";
            }
            responseMap.put("preName",presc.getPrescribename());
            responseMap.put("preState",state);
            response.add(responseMap);
        }

        for(prescribe prescri:doneList){
            HashMap<String,Object> responsemap = new HashMap<>();
            String State = "";
            if(prescri.getPresstate()==1){
                State = "暂存";
            }else if(prescri.getPresstate()==2){
                State = "已开立";
            }
            responsemap.put("preName",prescri.getPrescribename());
            responsemap.put("preState",State);
            response.add(responsemap);
        }
        return  JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/Addprescribedetail")
    public String AddprescribeDetail(@RequestBody Map<String,String> param){
        String presnamE = param.get("deta_presname");
        System.out.println(presnamE);
        List<prescribe> listtwo  = Anima.select().from(prescribe.class).where("处方名称=?",presnamE).all();
        int presID = listtwo.get(0).getPrescribeID();//处方ID
        int prescribed = Anima.select().bySQL(int.class, "select MAX(处方明细ID) from 处方明细").one();
        int presdetailID = prescribed+1;//处方明细ID
        String medicname = param.get("deta_medicinename");
        List<Medicine> listthree = Anima.select().from(Medicine.class).where("药品名称=?",medicname).all();
        int medicineId = listthree.get(0).getMediCineID();//药品ID
        String detailusage = param.get("deta_medicineusage");//用法
        String detaildosage = param.get("deta_medicinedosage");//用量
        String detailfrequency = param.get("deta_medicinefrequency");//频次
        int detailnumber = Integer.parseInt(param.get("deta_medicinenumber"));//数量
        int detailstate = 1;

        PrescribeDetail PD = new PrescribeDetail();
        PD.setPrescribedetailID(presdetailID);
        PD.setPrescribeofID(presID);
        PD.setMedicineID(medicineId);
        PD.setUsage(detailusage);
        PD.setDosage(detaildosage);
        PD.setMedfrequency(detailfrequency);
        PD.setMedicinenumber(detailnumber);
        PD.setDetailstate(detailstate);
        PD.save();

        List <HashMap> response = new LinkedList<>();
        List<PrescribeDetail> presdetaillist = Anima.select().from(PrescribeDetail.class).where("成药处方ID=?",presID).all();
        for(PrescribeDetail pred:presdetaillist){
            HashMap<String, Object> responseMap = new HashMap<>();
            int medid = pred.getMedicineID();
            List<Medicine> medilist = Anima.select().from(Medicine.class).where("药品ID=?",medid).all();
            String mediname = medilist.get(0).getMedicineName();
            double mediprice = medilist.get(0).getMedicineprice();
            responseMap.put("medName",mediname);
            responseMap.put("medPrice",mediprice);
            responseMap.put("medUsage",pred.getUsage());
            responseMap.put("medDosage",pred.getDosage());
            responseMap.put("medfrequency",pred.getMedfrequency());
            responseMap.put("medNumber",pred.getMedicinenumber());
            response.add(responseMap);
        }

        return JSON.toJSONString(new Response<>(response));

    }

    @RequestMapping(value = "/displaydetail")
    public String Displaydetail(@RequestBody Map<String,String> param){
        String prname = param.get("pressname");
        List<prescribe> prlist = Anima.select().from(prescribe.class).where("处方名称=?",prname).all();
        int prid = prlist.get(0).getPrescribeID();
        List<PrescribeDetail> prdetaillist = Anima.select().from(PrescribeDetail.class).where("成药处方ID=?",prid).all();
        List<HashMap> response = new LinkedList<>();
        for(PrescribeDetail PRD:prdetaillist){
            HashMap<String, Object> responseMap = new HashMap<>();

            int mediid = PRD.getMedicineID();
            List<Medicine> melist = Anima.select().from(Medicine.class).where("药品ID=?",mediid).all();
            String mediname = melist.get(0).getMedicineName();
            double mediprice = melist.get(0).getMedicineprice();
            responseMap.put("medName",mediname);
            responseMap.put("medPrice",mediprice);
            responseMap.put("medUsage",PRD.getUsage());
            responseMap.put("medDosage",PRD.getDosage());
            responseMap.put("medfrequency",PRD.getMedfrequency());
            responseMap.put("medNumber",PRD.getMedicinenumber());
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/changestate")
    public String ChangeState(@RequestBody Map<String,String> param){
        String nameofpre = param.get("nameofprescribe");//处方名字
        int numberofmed = Integer.parseInt(param.get("numberofmedhis"));//病历号

        List<prescribe> plist = Anima.select().from(prescribe.class).where("处方名称=?",nameofpre).all();
        int pID = plist.get(0).getPrescribeID();//得到处方ID
        int resultone = Anima.update().from(prescribe.class).set("处方状态",2).where("处方名称",nameofpre).execute();
        int resulttwo = Anima.update().from(PrescribeDetail.class).set("明细状态",2).where("成药处方ID",pID).execute();

        List<prescribe> Plist = Anima.select().from(prescribe.class).where("病历ID=?",numberofmed).where("处方状态=?",1).all();
        List<prescribe> pLIST = Anima.select().from(prescribe.class).where("病历ID=?",numberofmed).where("处方状态=?",2).all();
        List<HashMap> response = new LinkedList<>();

        for(prescribe pb:Plist){
            HashMap<String, Object> responseMap = new HashMap<>();
            responseMap.put("preName",pb.getPrescribename());
            String state = "";
            if(pb.getPresstate()==1){
                state = "暂存";
            }else if(pb.getPresstate()==2){
                state = "已开立";
            }

            responseMap.put("preState",state);
            response.add(responseMap);

        }

        for(prescribe pb:pLIST){
            HashMap<String, Object> responseMap = new HashMap<>();
            responseMap.put("preName",pb.getPrescribename());
            String state = "";
            if(pb.getPresstate()==1){
                state = "暂存";
            }else if(pb.getPresstate()==2){
                state = "已开立";
            }

            responseMap.put("preState",state);
            response.add(responseMap);

        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/deleteprescribe")
    public String DeleteAll(@RequestBody Map<String,String> param){
        String namePrescribe = param.get("namePre");
        int medID = Integer.parseInt(param.get("medID"));

        int PresID = 0;
        List<prescribe> listfour = Anima.select().from(prescribe.class).where("处方名称=?",namePrescribe).all();
        PresID = listfour.get(0).getPrescribeID();
        int resultdeletepre = Anima.delete().from(prescribe.class).where("处方名称",namePrescribe).execute();
        int resultdeleteprede = Anima.delete().from(PrescribeDetail.class).where("成药处方ID",PresID).execute();

        List<prescribe> afterdelete = Anima.select().from(prescribe.class).where("病历ID=?",medID).where("处方状态=?",1).all();
        List<prescribe> afterDelete = Anima.select().from(prescribe.class).where("病历ID=?",medID).where("处方状态=?",2).all();
        List<HashMap> response = new LinkedList<>();
        for(prescribe pb:afterdelete){
            HashMap<String, Object> responseMap = new HashMap<>();
            String PRState = "";
            if(pb.getPresstate()==1){
                PRState = "暂存";
            }else if(pb.getPresstate()==2){
                PRState = "已开立";
            }
            responseMap.put("preName",pb.getPrescribename());
            responseMap.put("preState",PRState);
            response.add(responseMap);
        }

        for(prescribe PB:afterDelete){
            HashMap<String,Object> responseMap = new HashMap<>();
            String stateofpres = "";
            if(PB.getPresstate()==1){
                stateofpres = "暂存";
            }else if(PB.getPresstate()==2){
                stateofpres = "已开立";
            }
            responseMap.put("preName",PB.getPrescribename());
            responseMap.put("preState",stateofpres);
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/createtemplate")
    public String CreateTemplate(@RequestBody Map<String,String> param){
        List<Template> templatelist = Anima.select().from(Template.class).all();
        List<HashMap> response = new LinkedList<>();
        for(Template tp:templatelist){
            HashMap<String,Object> responseMap = new HashMap<>();
            String range = "";
            if(tp.getUserange()==1){
                range = "全院";
            }else if(tp.getUserange()==2){
                range = "个人";
            }
            responseMap.put("temName",tp.getTempname());
            responseMap.put("temRange",range);
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/templatedetail")
    public String DisplaytemplateDetail(@RequestBody Map<String,String> param){
        String templatename = param.get("templatename");
        List<Template> temlist = Anima.select().from(Template.class).where("模板名称=?",templatename).all();
        int tempID = temlist.get(0).getTemplateID();
        List<TemplateDetail> temdetaillist = Anima.select().from(TemplateDetail.class).where("成药模板ID=?",tempID).all();
        List<HashMap> response = new LinkedList<>();
        for(TemplateDetail temd:temdetaillist){
            HashMap<String,Object> responseMap = new HashMap<>();
            int medID = temd.getMedicineoftemID();
            List<Medicine> medlist = Anima.select().from(Medicine.class).where("药品ID=?",medID).all();
            String medName = medlist.get(0).getMedicineName();
            double medPrice = medlist.get(0).getMedicineprice();
            responseMap.put("temdName",medName);
            responseMap.put("temdPrice",medPrice);
            responseMap.put("temdUsage",temd.getDetailusage());
            responseMap.put("temdDosage",temd.getDetaildosage());
            responseMap.put("temdfrequency",temd.getDetailfrequency());
            responseMap.put("temdNumber",temd.getDetailnumber());
            response.add(responseMap);
        }
        return JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/addtemplate")
    public String Addtemplatetoprescribe(@RequestBody Map<String,String> param){
        String temname = param.get("templatename");//处方模板名称
        int medicalnumber = Integer.parseInt(param.get("medicalhistory"));//病历号
        int prescribeid = Anima.select().bySQL(int.class, "select MAX(处方ID) from 处方表").one();
        int prescribeID = prescribeid + 1;//处方ID

        List<RegInformation> RegList = Anima.select().from(RegInformation.class).where("病历号=?",medicalnumber).where("诊断状态=?",2).all();
        int RegNumber = RegList.get(0).getRegID();//挂号ID
        int DoctorID = Integer.parseInt(param.get("doctorIDoftem"));//医生ID

        prescribe newTemplate = new prescribe();
        newTemplate.setPrescribeID(prescribeID);
        newTemplate.setPresRegID(RegNumber);
        newTemplate.setPresdoctorID(DoctorID);
        newTemplate.setPrescribename(temname);
        newTemplate.setPresmedhisID(medicalnumber);
        newTemplate.setPresstate(1);
        newTemplate.save();//存模板进处方表

        List<Template> template = Anima.select().from(Template.class).where("模板名称=?",temname).all();
        int templateId = template.get(0).getTemplateID();//得到模板ID
        List<TemplateDetail> templatedetail = Anima.select().from(TemplateDetail.class).where("成药模板ID=?",templateId).all();
        for(TemplateDetail TD:templatedetail){
            PrescribeDetail presde = new PrescribeDetail();
            int a = Anima.select().bySQL(int.class, "select MAX(处方明细ID) from 处方明细").one();
            int PrescribeDetailID = a+1;
            presde.setPrescribedetailID(PrescribeDetailID);
            presde.setPrescribeofID(prescribeID);
            presde.setMedicineID(TD.getMedicineoftemID());
            presde.setUsage(TD.getDetailusage());
            presde.setDosage(TD.getDetaildosage());
            presde.setMedfrequency(TD.getDetailfrequency());
            presde.setMedicinenumber(TD.getDetailnumber());
            presde.setDetailstate(1);
            presde.save();//存模板明细进处方明细表
        }

        List<HashMap> response = new LinkedList<>();
        List<prescribe> ListA = Anima.select().from(prescribe.class).where("病历ID=?",medicalnumber).where("处方状态=?",1).all();
        List<prescribe> ListB = Anima.select().from(prescribe.class).where("病历ID=?",medicalnumber).where("处方状态=?",2).all();

        for(prescribe PA:ListA){
            HashMap<String,Object> responseMap = new HashMap<>();
            String state = "";
            if(PA.getPresstate()==1){
                state = "暂存";
            }else if(PA.getPresstate()==2){
                state = "已开立";
            }
            responseMap.put("preName",PA.getPrescribename());
            responseMap.put("preState",state);
            response.add(responseMap);
        }

        for(prescribe PB:ListB){
            HashMap<String,Object> responsemap = new HashMap<>();
            String State = "";
            if(PB.getPresstate()==1){
                State = "暂存";
            }else if(PB.getPresstate()==2){
                State = "已开立";
            }
            responsemap.put("preName",PB.getPrescribename());
            responsemap.put("preState",State);
            response.add(responsemap);
        }



        return  JSON.toJSONString(new Response<>(response));
    }
}
