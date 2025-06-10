package com.project.demo.controller;

import com.project.demo.entity.PatientMedicalRecord;
import com.project.demo.service.PatientMedicalRecordService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *患者病历：(PatientMedicalRecord)表控制层
 *
 */
@RestController
@RequestMapping("/patient_medical_record")
public class PatientMedicalRecordController extends BaseController<PatientMedicalRecord,PatientMedicalRecordService> {

    /**
     *患者病历对象
     */
    @Autowired
    public PatientMedicalRecordController(PatientMedicalRecordService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
