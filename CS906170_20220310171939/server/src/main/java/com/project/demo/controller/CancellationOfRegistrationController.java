package com.project.demo.controller;

import com.project.demo.entity.CancellationOfRegistration;
import com.project.demo.service.CancellationOfRegistrationService;
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
 *挂号取消：(CancellationOfRegistration)表控制层
 *
 */
@RestController
@RequestMapping("/cancellation_of_registration")
public class CancellationOfRegistrationController extends BaseController<CancellationOfRegistration,CancellationOfRegistrationService> {

    /**
     *挂号取消对象
     */
    @Autowired
    public CancellationOfRegistrationController(CancellationOfRegistrationService service) {
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
