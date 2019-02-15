/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hibernate.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Csore_A_Tamas
 */
@Entity
public class D{

    @Id
    @GeneratedValue
    private Integer id;
    
    private String someField;
    
    @OneToOne(cascade = CascadeType.ALL)
    private E e;

    public D() {
    }

    public D(Integer id) {
        this.id = id;
    }

    public D(String someField) {
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

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
