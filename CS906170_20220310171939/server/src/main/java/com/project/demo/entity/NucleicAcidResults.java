package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *核酸结果：(NucleicAcidResults)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "NucleicAcidResults")
public class NucleicAcidResults implements Serializable {

    //NucleicAcidResults编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nucleic_acid_results_id")
    private Integer nucleic_acid_results_id;
    // 预约编号
    @Basic
    private String reservation_number;
    // 预约姓名
    @Basic
    private String appointment_name;
    // 身份证
    @Basic
    private String id;
    // 预约人
    @Basic
    private Integer appointment_person;
    // 检查结果
    @Basic
    private String inspection_results;
    // 医生账号
    @Basic
    private Integer doctor_account;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
