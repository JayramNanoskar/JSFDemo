package com.logicbig.example;

import java.util.List;
import java.util.Map;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;


public class CheckBox
{
    private String treeName;

    private String controlId;
    
    private String controlType;
    
    private String label;
   
    private String name;
    
    private Map<String,String> checkList;
    
    private List<FluidGridItem> checkBoxItems;
    
    public String getTreeName()
    {
        return treeName;
    }

    public void setTreeName(String treeName)
    {
        this.treeName = treeName;
    }

    public String getControlId()
    {
        return controlId;
    }

    public void setControlId(String controlId)
    {
        this.controlId = controlId;
    }

    public String getControlType()
    {
        return controlType;
    }

    public void setControlType(String controlType)
    {
        this.controlType = controlType;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Map<String, String> getCheckList()
    {
        return checkList;
    }

    public void setCheckList(Map<String, String> checkList)
    {
        this.checkList = checkList;
    }

    public List<FluidGridItem> getCheckBoxItems()
    {
        return checkBoxItems;
    }

    public void setCheckBoxItems(List<FluidGridItem> checkBoxItems)
    {
        this.checkBoxItems = checkBoxItems;
    }

    
}
