package com.project.demo.controller;

import com.project.demo.entity.DepartmentInformation;
import com.project.demo.service.DepartmentInformationService;
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
 *科室信息：(DepartmentInformation)表控制层
 *
 */
@RestController
@RequestMapping("/department_information")
public class DepartmentInformationController extends BaseController<DepartmentInformation,DepartmentInformationService> {

    /**
     *科室信息对象
     */
    @Autowired
    public DepartmentInformationController(DepartmentInformationService service) {
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
