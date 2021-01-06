package com.logicbig.example;

import java.util.List;
import org.primefaces.extensions.model.fluidgrid.FluidGridItem;

public class ButtonSubmit
{
    private String treeName;

    private String controlId;
    
    private String controlType;
    
    private String label;
   
    private String name;
    
    private List<FluidGridItem> submitButtonItems;

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

	public List<FluidGridItem> getSubmitButtonItems() {
		return submitButtonItems;
	}

	public void setSubmitButtonItems(List<FluidGridItem> submitButtonItems) {
		this.submitButtonItems = submitButtonItems;
	}
    
    
}
