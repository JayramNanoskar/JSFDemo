package com.logicbig.example;

import java.util.List;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;



public class Label
{
    public String label;

    public String controlId;
    
    public String controlType;
    
    private List<FluidGridItem> labelItems;
    
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

    public List<FluidGridItem> getLabelItems()
    {
        return labelItems;
    }

    public void setLabelItems(List<FluidGridItem> labelItems)
    {
        this.labelItems = labelItems;
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
