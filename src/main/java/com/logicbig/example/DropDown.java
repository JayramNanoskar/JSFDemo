package com.logicbig.example;

import java.util.List;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;


public class DropDown
{
    public String label;

    public String controlId;
    
    public String controlType;
    
    private List<FluidGridItem> dropDownItems;
    
    private String name;
    
    private String treeName;

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
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

    public List<FluidGridItem> getDropDownItems()
    {
        return dropDownItems;
    }

    public void setDropDownItems(List<FluidGridItem> dropDownItems)
    {
        this.dropDownItems = dropDownItems;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTreeName()
    {
        return treeName;
    }

    public void setTreeName(String treeName)
    {
        this.treeName = treeName;
    }
    
    
    
    
}
