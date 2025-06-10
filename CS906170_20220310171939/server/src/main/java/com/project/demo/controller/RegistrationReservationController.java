package com.project.demo.controller;

import com.project.demo.entity.RegistrationReservation;
import com.project.demo.service.RegistrationReservationService;
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
 *挂号预约：(RegistrationReservation)表控制层
 *
 */
@RestController
@RequestMapping("/registration_reservation")
public class RegistrationReservationController extends BaseController<RegistrationReservation,RegistrationReservationService> {

    /**
     *挂号预约对象
     */
    @Autowired
    public RegistrationReservationController(RegistrationReservationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(registration_reservation_id) AS max FROM "+"registration_reservation";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `department_information` INNER JOIN `registration_reservation` ON department_information.department_number=registration_reservation.department_number WHERE department_information.remaining_number &#60; registration_reservation.reservation_number AND registration_reservation.registration_reservation_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"registration_reservation"+" WHERE "+"registration_reservation_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"无法预约!");
        }
        sql = "UPDATE `department_information` INNER JOIN `registration_reservation` ON department_information.department_number=registration_reservation.department_number SET department_information.remaining_number = department_information.remaining_number - registration_reservation.reservation_number WHERE registration_reservation.registration_reservation_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
