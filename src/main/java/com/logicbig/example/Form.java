package com.logicbig.example;

import java.util.List;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;

public class Form
{
    public String moduleName;

    public String componentName;

    public String gridColumn;

    public String pageHeading;

    public String formData;
    
    public String parentContainer;
    
    private List<FluidGridItem> formItems;
    
    private List<Control> controls;
    
    private String treeName;
    /**
     * @return the moduleName
     */
    public String getModuleName()
    {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    /**
     * @return the componentName
     */
    public String getComponentName()
    {
        return componentName;
    }

    /**
     * @param componentName the componentName to set
     */
    public void setComponentName(String componentName)
    {
        this.componentName = componentName;
    }

    /**
     * @return the gridColumn
     */
    public String getGridColumn()
    {
        return gridColumn;
    }

    /**
     * @param gridColumn the gridColumn to set
     */
    public void setGridColumn(String gridColumn)
    {
        this.gridColumn = gridColumn;
    }

    /**
     * @return the pageHeading
     */
    public String getPageHeading()
    {
        return pageHeading;
    }

    /**
     * @param pageHeading the pageHeading to set
     */
    public void setPageHeading(String pageHeading)
    {
        this.pageHeading = pageHeading;
    }

    /**
     * @return the formData
     */
    public String getFormData()
    {
        return formData;
    }

    /**
     * @param formData the formData to set
     */
    public void setFormData(String formData)
    {
        this.formData = formData;
    }

    @Override
    public String toString()
    {
        return "Form [moduleName=" + moduleName + ", componentName=" + componentName
            + ", gridColumn=" + gridColumn + ", pageHeading=" + pageHeading + ", formData="
            + formData + "]";
    }

    public List<FluidGridItem> getFormItems()
    {
        return formItems;
    }

    public void setFormItems(List<FluidGridItem> formItems)
    {
        this.formItems = formItems;
    }

    public List<Control> getControls()
    {
        return controls;
    }

    public void setControls(List<Control> controls)
    {
        this.controls = controls;
    }

    public String getTreeName()
    {
        return treeName;
    }

    public void setTreeName(String treeName)
    {
        this.treeName = treeName;
    }

	public String getParentContainer() {
		return parentContainer;
	}

	public void setParentContainer(String parentContainer) {
		this.parentContainer = parentContainer;
	}

}
