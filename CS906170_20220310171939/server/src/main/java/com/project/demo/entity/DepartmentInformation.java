package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *科室信息：(DepartmentInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DepartmentInformation")
public class DepartmentInformation implements Serializable {

    //DepartmentInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_information_id")
    private Integer department_information_id;
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
    // 医生头像
    @Basic
    private String doctor_head;
    // 医生账号
    @Basic
    private Integer doctor_account;
    // 时间段
    @Basic
    private String time_slot;
    // 剩余号数
    @Basic
    private Integer remaining_number;
    // 科室简介
    @Basic
    private String department_profile;
    // 点击数
    @Basic
    private Integer hits;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
