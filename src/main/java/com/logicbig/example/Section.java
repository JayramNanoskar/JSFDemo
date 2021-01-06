package com.logicbig.example;

import java.util.List;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;


public class Section
{
    private List<FluidGridItem> sectionItems;
    private String treeName;
    private String name;
    private String controlId;
    private String controlType;
    

    public List<FluidGridItem> getSectionItems()
    {
        return sectionItems;
    }

    public void setSectionItems(List<FluidGridItem> sectionItems)
    {
        this.sectionItems = sectionItems;
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
}
