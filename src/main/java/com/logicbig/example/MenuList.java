package com.logicbig.example;

import java.util.List;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;


public class MenuList
{
    private List<FluidGridItem> menuListItems;
    private String treeName;
    private String name;
    private String controlId;
    private String controlType;
    private String serviceCall;
    

    public List<FluidGridItem> getMenuListItems()
    {
        return menuListItems;
    }

    public void setMenuListItems(List<FluidGridItem> menuListItems)
    {
        this.menuListItems = menuListItems;
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

	public String getServiceCall() {
		return serviceCall;
	}

	public void setServiceCall(String serviceCall) {
		this.serviceCall = serviceCall;
	}
    
    
}
