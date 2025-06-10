package com.project.demo.controller;

import com.project.demo.entity.NucleicAcidResults;
import com.project.demo.service.NucleicAcidResultsService;
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
 *核酸结果：(NucleicAcidResults)表控制层
 *
 */
@RestController
@RequestMapping("/nucleic_acid_results")
public class NucleicAcidResultsController extends BaseController<NucleicAcidResults,NucleicAcidResultsService> {

    /**
     *核酸结果对象
     */
    @Autowired
    public NucleicAcidResultsController(NucleicAcidResultsService service) {
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
