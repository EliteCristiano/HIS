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
import java.util.Date;

@RestController
public class FeeController {
    @RequestMapping(value = "/searchforfee")
    public String SearchForFee(@RequestBody Map<String,String> param){
        int medicalhistory = Integer.parseInt(param.get("MedHisNumber"));
        List<prescribe> prescrilist = Anima.select().from(prescribe.class).where("病历ID=?",medicalhistory).where("处方状态=?",2).all();

        String nameofpatient = "";
        List<RegInformation> listSeven = Anima.select().from(RegInformation.class).where("病历号=?",medicalhistory).all();
        nameofpatient = listSeven.get(0).getName();

        List<HashMap> response = new LinkedList<>();

        if(prescrilist.size()==0){
            HashMap<String,Object> responseMap = new HashMap<>();
            responseMap.put("code",123);
            responseMap.put("feemedHis","");
            responseMap.put("feeName","");
            responseMap.put("feeMedicine","");
            responseMap.put("feeMedicinePrice","");
            responseMap.put("feeMedicineNumber","");
            responseMap.put("feeState","");
            response.add(responseMap);

        }else{
            for(prescribe feepre:prescrilist){
                int feepreID = feepre.getPrescribeID();
                List<PrescribeDetail> presdelist = Anima.select().from(PrescribeDetail.class).where("成药处方ID=?",feepreID).all();
                for(PrescribeDetail feepredetail:presdelist){
                    int medicineIDFee = feepredetail.getMedicineID();
                    List<Medicine> listEight = Anima.select().from(Medicine.class).where("药品ID=?",medicineIDFee).all();
                    String medicinenameFee = listEight.get(0).getMedicineName();
                    double pricefee = listEight.get(0).getMedicineprice();
                    int medicinenumberfee = feepredetail.getMedicinenumber();


                    HashMap<String,Object> responseMap = new HashMap<>();
                    responseMap.put("code",200);
                    responseMap.put("feemedHis",medicalhistory);
                    responseMap.put("feeName",nameofpatient);
                    responseMap.put("feeMedicine",medicinenameFee);
                    responseMap.put("feeMedicinePrice",pricefee);
                    responseMap.put("feeMedicineNumber",medicinenumberfee);
                    responseMap.put("feeState","已开立");
                    response.add(responseMap);


                }
            }

        }


        return  JSON.toJSONString(new Response<>(response));

    }

    @RequestMapping(value = "/getinvoice")
    public String GetInvoiceNumber(@RequestBody Map<String,String> param){
        int invoiceid  = Anima.select().bySQL(int.class, "select MAX(发票ID) from 发票").one();
        int invoiceID = invoiceid+1;
        int mNumber = Integer.parseInt(param.get("medicalNumber"));
        List<RegInformation> listNine = Anima.select().from(RegInformation.class).where("病历号=?",mNumber).all();
        String paName = listNine.get(0).getName();

        List<HashMap> response = new LinkedList<>();
        HashMap<String,Object> responseMap = new HashMap<>();
        responseMap.put("invoiceID",invoiceID);
        responseMap.put("PatientName",paName);
        response.add(responseMap);
        return  JSON.toJSONString(new Response<>(response));
    }

    @RequestMapping(value = "/settletotalfee")
    public String SettelTotal(@RequestBody Map<String,String> param){
        int InvoiceID = Integer.parseInt(param.get("in_invoicenumber"));
        double InvoiceMoney = Double.parseDouble(param.get("in_voicemoney"));
        String InvoiceDate = String.valueOf(new Date());
        int InvoiceOperator = Integer.parseInt(param.get("operator"));
        int InvoiceSettleWay = Integer.parseInt(param.get("in_settleway"));

        int InvoiceMedical = Integer.parseInt(param.get("in_medical"));
        List<prescribe> listTen = Anima.select().from(prescribe.class).where("病历ID=?",InvoiceMedical).where("处方状态=?",2).all();
        int InvoiceRegNumber = listTen.get(0).getPresRegID();

        invoice In = new invoice();
        In.setInvoiceID(InvoiceID);
        In.setInvoicemoney(InvoiceMoney);
        In.setTimeoffee(InvoiceDate);
        In.setOperatorID(InvoiceOperator);
        In.setSettleway(InvoiceSettleWay);
        In.setRegFeeID(InvoiceRegNumber);
        In.setRedinvoiceID(0);
        In.save();

        for(prescribe pe:listTen){
            int presvribeid = pe.getPrescribeID();
            int result = Anima.update().from(prescribe.class).set("处方状态",3).where("处方ID=?",presvribeid).execute();
            int Result = Anima.update().from(PrescribeDetail.class).set("明细状态",3).where("成药处方ID=?",presvribeid).execute();
        }
        List<HashMap> response = new LinkedList<>();
        HashMap<String,Object> responseMap = new HashMap<>();
        responseMap.put("returncode",200);
        response.add(responseMap);
        return  JSON.toJSONString(new Response<>(response));


    }
}
