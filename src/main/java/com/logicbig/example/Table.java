package com.logicbig.example;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;
import org.springframework.stereotype.Component;


@ManagedBean(name = "Table")
@ViewScoped
public class Table
{

    private String treeName;

    private String controlId;
    
    private String controlType;
    
    private String label;
   
    private String name;
    
    private List<Field> fields;
    
    private List<FluidGridItem> tableItems;

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

    public List<Field> getFields()
    {
        return fields;
    }

    public void setFields(List<Field> fields)
    {
        this.fields = fields;
    }

	public List<FluidGridItem> getTableItems() {
		return tableItems;
	}

	public void setTableItems(List<FluidGridItem> tableItems) {
		this.tableItems = tableItems;
	}
    

}
