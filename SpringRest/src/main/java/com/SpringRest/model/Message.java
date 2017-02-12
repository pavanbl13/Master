package com.SpringRest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;

@XmlRootElement(name="player")
@JsonTypeName( value = "player" )
//@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME) 
public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3530909266333794453L;
	String name;
    String text;
    
    public Message(){
        
    }
     
    public Message(String value) {
    	String [] values = value.split("\\|");
        this.name = values[0];
        this.text = values[1];
    }
 
    @XmlElement
    public String getName() {
        return name;
    }
     
    @XmlElement
    public String getText() {
        return text;
    }

}
