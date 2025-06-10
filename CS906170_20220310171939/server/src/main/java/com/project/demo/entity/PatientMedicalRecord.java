package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *患者病历：(PatientMedicalRecord)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PatientMedicalRecord")
public class PatientMedicalRecord implements Serializable {

    //PatientMedicalRecord编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_medical_record_id")
    private Integer patient_medical_record_id;
    // 科室编号
    @Basic
    private String department_number;
    // 科室类型
    @Basic
    private String department_type;
    // 科室名称
    @Basic
    private String department_name;
    // 预约姓名
    @Basic
    private String appointment_name;
    // 身份证
    @Basic
    private String id;
    // 预约人
    @Basic
    private Integer appointment_person;
    // 医生账号
    @Basic
    private Integer doctor_account;
    // 患病症状
    @Basic
    private String disease_symptoms;
    // 患病原因
    @Basic
    private String cause_of_disease;
    // 用药详情
    @Basic
    private String medication_details;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
