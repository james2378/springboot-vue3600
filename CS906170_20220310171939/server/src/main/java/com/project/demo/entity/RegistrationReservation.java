package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *挂号预约：(RegistrationReservation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RegistrationReservation")
public class RegistrationReservation implements Serializable {

    //RegistrationReservation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_reservation_id")
    private Integer registration_reservation_id;
    // 科室编号
    @Basic
    private String department_number;
    // 科室类型
    @Basic
    private String department_type;
    // 科室名称
    @Basic
    private String department_name;
    // 医生姓名
    @Basic
    private String name_of_doctor;
    // 医生职位
    @Basic
    private String doctor_position;
    // 医生账号
    @Basic
    private Integer doctor_account;
    // 预约时间
    @Basic
    private Timestamp time_of_appointment;
    // 预约说明
    @Basic
    private String appointment_description;
    // 预约姓名
    @Basic
    private String appointment_name;
    // 身份证
    @Basic
    private String id;
    // 预约人
    @Basic
    private Integer appointment_person;
    // 时间段
    @Basic
    private String time_slot;
    // 预约号数
    @Basic
    private Integer reservation_number;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
