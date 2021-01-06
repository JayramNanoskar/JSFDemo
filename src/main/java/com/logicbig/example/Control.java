package com.logicbig.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Control
{
    private int sequence;

    private String label;

    private String controlType;

    private String controlId;

    private String parentId;

    private String dataType;

    private String name;

    private String defaultValue;

    private String eventHandler;

    private String validator;

    private String placeHolder;

    private String serviceCall;
    
    private String controlLength;

    private List<Control> children;
    
    public String moduleName;

    public String componentName;

    public String gridColumn;

    public String pageHeading;

    public String tabData;
    
    private Map<String,String> checkBoxList;
    
    private String style;
    
    private String formData;
    
    private List<Control> controls;

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

    public Control()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<Control> getChildren()
    {
        return children;
    }

    public void addChild(Control child, String controlType)
    {
    	if("Tab".equalsIgnoreCase(controlType)) {
    		if(this.controls != null) {
    			this.controls.add(child);
    		}
    		else {
    			this.controls = new ArrayList<>();
    			this.controls.add(child);
    		}
    	}
    	else {
    		if (this.children != null)
            {
                this.children.add(child);
            }
            else
            {
                this.children = new ArrayList<Control>();
                this.children.add(child);
            }
    	}
    }

    public int getSequence()
    {
        return sequence;
    }

    public void setSequence(int sequence)
    {
        this.sequence = sequence;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getControlType()
    {
        return controlType;
    }

    public void setControlType(String controlType)
    {
        this.controlType = controlType;
    }

    public String getControlId()
    {
        return controlId;
    }

    public void setControlId(String controlId)
    {
        this.controlId = controlId;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public String getDataType()
    {
        return dataType;
    }

    public void setDataType(String dataType)
    {
        this.dataType = dataType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }

    public String getEventHandler()
    {
        return eventHandler;
    }

    public void setEventHandler(String eventHandler)
    {
        this.eventHandler = eventHandler;
    }

    public String getValidator()
    {
        return validator;
    }

    public void setValidator(String validator)
    {
        this.validator = validator;
    }

    public String getPlaceHolder()
    {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    public String getServiceCall()
    {
        return serviceCall;
    }

    public void setServiceCall(String serviceCall)
    {
        this.serviceCall = serviceCall;
    }

    public String getControlLength()
    {
        return controlLength;
    }

    public void setControlLength(String controlLength)
    {
        this.controlLength = controlLength;
    }

    public Map<String,String> getCheckBoxList()
    {
        return checkBoxList;
    }

    public void setCheckBoxList(Map<String,String> checkBoxList)
    {
        this.checkBoxList = checkBoxList;
    }

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFormData() {
		return formData;
	}

	public void setFormData(String formData) {
		this.formData = formData;
	}

	public List<Control> getControls() {
		return controls;
	}
    

}
