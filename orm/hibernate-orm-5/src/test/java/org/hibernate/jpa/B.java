/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hibernate.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Csore_A_Tamas
 */
@Entity
public class B{

    @Id
    @GeneratedValue
    private Integer id;
    
    private String someField;

    public B() {
    }

    public B(Integer id) {
        this.id = id;
    }

    public B(String someField) {
        this.someField = someField;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }   
}
