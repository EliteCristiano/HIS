package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.*;

import java.util.List;

@Service
public interface patientService {
    List<RegInformation> getunpatientlist(int doctorid);
    List<RegInformation> getdonepatientlist(int doctor);
}
