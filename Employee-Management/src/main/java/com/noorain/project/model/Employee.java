package com.noorain.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String phone;
    private String email;
}



/*
// will u do this method for all fields noorain, not at all
then what ?
I will use lombok @Data , this annotation will give u all the getters , setters etc.

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


 */