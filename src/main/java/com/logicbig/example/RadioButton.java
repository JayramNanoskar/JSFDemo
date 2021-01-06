package com.logicbig.example;

import java.util.List;
import java.util.Map;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;



public class RadioButton
{
    private String treeName;

    private String controlId;
    
    private String controlType;
    
    private String label;
   
    private String name;
    
    private List<FluidGridItem> radioBtnItems;

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

    public List<FluidGridItem> getRadioBtnItems()
    {
        return radioBtnItems;
    }

    public void setRadioBtnItems(List<FluidGridItem> radioBtnItems)
    {
        this.radioBtnItems = radioBtnItems;
    }
    
    
}
