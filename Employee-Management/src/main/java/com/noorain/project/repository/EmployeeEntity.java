package com.noorain.project.repository;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="emp_db")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //in place of IDENTITY u can write AUTO too
    private Long id;                                     //id will get generated automatically
    private String name;
    private String phone;
    private String email;
}
