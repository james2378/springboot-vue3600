package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *挂号取消：(CancellationOfRegistration)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CancellationOfRegistration")
public class CancellationOfRegistration implements Serializable {

    //CancellationOfRegistration编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancellation_of_registration_id")
    private Integer cancellation_of_registration_id;
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
    private String doctor_account;
    // 取消时间
    @Basic
    private Timestamp cancel_time;
    // 取消人
    @Basic
    private Integer canceller;
    // 取消原因
    @Basic
    private String cancellation_reason;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
