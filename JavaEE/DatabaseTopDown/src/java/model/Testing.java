/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sami
 */
@Entity
@XmlRootElement
public class Testing implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String type;
    private String value;

    public Testing(String value, String type) {
        this.type = type;
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Testing() {
        this.type = "email";
        this.value = "john@doe.com";
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
    
    public int getId() {
        return id;
    }
    
}
