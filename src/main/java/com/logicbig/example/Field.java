package com.logicbig.example;

import java.io.Serializable;
import java.util.List;


public class Field implements Serializable {

private String label;
private String value;
private String type;




public Field() {
}



public Field(String label) {
    this.label = label;
}

public String getLabel() {
    return label;
}

public void setLabel(String label) {
    this.label = label;
}

public String getValue() {
    return value;
}

public void setValue(String value) {
    this.value = value;
}



@Override
public String toString()
{
    return "Field [label=" + label + ", value=" + value + "]";
}



public String getType()
{
    return type;
}



public void setType(String type)
{
    this.type = type;
}







}
