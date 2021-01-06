package com.logicbig.example;

import java.util.List;

import org.primefaces.extensions.model.fluidgrid.FluidGridItem;


public class Tab
{
    private List<FluidGridItem> tabItems;
    private String treeName;
    public String moduleName;
    public String componentName;
    public String gridColumn;
    public String pageHeading;
    public String getModuleName()
    {
        return moduleName;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public String getComponentName()
    {
        return componentName;
    }

    public void setComponentName(String componentName)
    {
        this.componentName = componentName;
    }

    public String getGridColumn()
    {
        return gridColumn;
    }

    public void setGridColumn(String gridColumn)
    {
        this.gridColumn = gridColumn;
    }

    public String getPageHeading()
    {
        return pageHeading;
    }

    public void setPageHeading(String pageHeading)
    {
        this.pageHeading = pageHeading;
    }

    public String getTabData()
    {
        return tabData;
    }

    public void setTabData(String tabData)
    {
        this.tabData = tabData;
    }

    public String tabData;
    
    public List<FluidGridItem> getTabItems()
    {
        return tabItems;
    }

    public void setTabItems(List<FluidGridItem> tabItems)
    {
        this.tabItems = tabItems;
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
