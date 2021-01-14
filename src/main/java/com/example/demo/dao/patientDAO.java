package com.example.demo.dao;
import com.example.demo.model.*;
import io.github.biezhi.anima.Anima;

import java.util.List;


public class patientDAO {
    public static List<RegInformation> getUnpatient(int doctorid){
        return Anima.select().from(RegInformation.class).where("诊断状态=?",2).where("挂号医生ID=?",doctorid).all();
    }
    public static List<RegInformation> getDonePatient(int doctor){
        return Anima.select().from(RegInformation.class).where("诊断状态=?",1).where("挂号医生ID=?",doctor).all();
    }
}
