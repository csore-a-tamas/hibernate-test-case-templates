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
public class A{

    @Id
    @GeneratedValue
    private Integer id;
    
    private String someField;
    
    @OneToOne(cascade = CascadeType.ALL)
    private B b;
    
    @OneToOne(cascade = CascadeType.ALL)
    private C c;

    @OneToOne(cascade = CascadeType.ALL)
    private D d;

    public A() {
    }

    public A(Integer id) {
        this.id = id;
    }

    public A(String someField) {
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

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }
}
