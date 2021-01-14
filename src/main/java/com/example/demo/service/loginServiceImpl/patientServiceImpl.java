package com.example.demo.service.loginServiceImpl;

import com.example.demo.model.*;
import com.example.demo.dao.patientDAO;
import com.example.demo.service.patientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class patientServiceImpl implements patientService{
    public List<RegInformation> getunpatientlist(int doctorid){
        List<RegInformation> unPatientList = patientDAO.getUnpatient(doctorid);
        return unPatientList;
    }
    public List<RegInformation> getdonepatientlist(int doctor){
        List<RegInformation> donePatientList = patientDAO.getDonePatient(doctor);
        return donePatientList;
    }
}
