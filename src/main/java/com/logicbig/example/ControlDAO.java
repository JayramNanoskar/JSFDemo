package com.logicbig.example;

import java.util.Iterator;
import java.util.List;

import org.primefaces.model.TreeNode;


public class ControlDAO
{
    
    int sequence=0;
    
    public List<Control> setControlValues(TreeNode node, List<Control> controls)
    {
        Control control = null;
        Object data = node.getData();
        if(data instanceof Tab)
        {
          setTabValues(data,controls,node, null);
           
        }
        if(data instanceof Section)
        {
          setSectionValues(data,controls,node,null);
           
        }
        if(data instanceof TextField)
        {
          setTextFieldValues(data,controls,node,null);
           
        }
        if(data instanceof Label)
        {
          setLabelValues(data,controls,node,null);
           
        }
        
        if(data instanceof CheckBox)
        {
          setCheckBoxValues(data,controls,node,null);
           
        }
        
        if(data instanceof DropDown)
        {
          setDropDownValues(data,controls,node,null);
           
        }
        
        if(data instanceof RadioButton)
        {
            setRadioButtonValues(data,controls,node,null);
           
        }
        
        if(data instanceof ButtonSubmit)
        {
            setButtonSubmitValues(data,controls,node,null);
        }
        if(data instanceof ButtonInput)
        {
            setButtonInputValues(data,controls,node,null);
        }
        
        if(data instanceof Table)
        {
            setTableValues(data,controls,node,null);
           
        }
        
        if(data instanceof MenuList)
        {
        	setMenuListValues(data,controls,node,null);
           
        }
       
        return controls;
    }
    
    
    /*
     * public Control setControlValues(TreeNode node, List<Control> controls, Control parenControl)
     * { Control control = new Control(); Object data = node.getData(); if (data instanceof Tab) {
     * setTabValues(data, controls, node,parenControl); } if (data instanceof Section) {
     * setSectionValues(data, controls, node,parenControl); } if (data instanceof TextField) {
     * setTextFieldValues(data, controls, node,parenControl); } if (data instanceof Label) {
     * setLabelValues(data, controls, node,parenControl); } if (data instanceof CheckBox) {
     * setCheckBoxValues(data, controls, node,parenControl); } if (data instanceof DropDown) {
     * setDropDownValues(data, controls, node,parenControl); } if (data instanceof RadioButton) {
     * setRadioButtonValues(data, controls, node,parenControl); } return parenControl; }
     */
    
    public Control setChildValues(TreeNode node, List<Control> controls, Control parenControl)
    {
        Control control = new Control();
        Object data = node.getData();
        if (data instanceof Tab)
        {
            setTabValues(data, controls, node,parenControl);
           

        }
        if (data instanceof Section)
        {
            setSectionValues(data, controls, node, parenControl);
           
        }
        if (data instanceof TextField)
        {
            setTextFieldValues(data, controls, node, parenControl);
            
        }
        if (data instanceof Label)
        {
            setLabelValues(data, controls, node, parenControl);
            
        }
        if (data instanceof CheckBox)
        {
            setCheckBoxValues(data, controls, node, parenControl);
            
        }
        
        if (data instanceof DropDown)
        {
            setDropDownValues(data, controls, node, parenControl);
            
        }
        if (data instanceof RadioButton)
        {
            setRadioButtonValues(data, controls, node, parenControl);
            
        }
        
        if(data instanceof ButtonSubmit)
        {
            setButtonSubmitValues(data, controls, node, parenControl);
        }
        
        if(data instanceof ButtonInput)
        {
            setButtonInputValues(data, controls, node, parenControl);
        }
        
        if(data instanceof Table)
        {
            setTableValues(data,controls,node, parenControl);
           
        }
        
        if(data instanceof MenuList)
        {
        	setMenuListValues(data,controls,node, parenControl);
           
        }
        return parenControl;
    }
    

    public List<Control> setTextFieldValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        TextField text = (TextField) node.getData();
        int size = text.getTextFieldItems().size();
        Control control=new Control();
        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) text.getTextFieldItems().get(i).getData();
            if (field.getLabel().equals("Label"))
            {
                control.setLabel(field.getValue().toString());
            }
            if (field.getLabel().equals("Control ID"))
            {
                control.setControlId(field.getValue().toString());
            }
            if (field.getLabel().equals("Control Name"))
            {
                control.setName(field.getValue().toString());
            }
            
            
            
        }
        control.setControlType("Input Box");
        control.setSequence(sequence);
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control,parentControl.getControlType());
           // controls.add(parentControl);
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(0);
               // setControlValues(treeNode, controls,control);
                setChildValues(treeNode, controls,control);
               // sequence++;
            }
        }
        
        return controls;
        
    }

    public List<Control> setSectionValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        Section section = (Section) node.getData();
        int size = section.getSectionItems().size();
        section.getSectionItems().get(0).getData();
        Control control=new Control();
//        sequence++;
        sequence = 0;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField)  section.getSectionItems().get(i).getData();
            if (field.getLabel().equals("Section Label"))
            {
                control.setLabel(field.getValue().toString());
            }
            if (field.getLabel().equals("Section ID"))
            {
                control.setControlId(field.getValue().toString());
            }
            if (field.getLabel().equals("Section Name"))
            {
                control.setName(field.getValue().toString());
            }
            String style = ""; 
            if (field.getLabel().equals("Initial State"))
            {
            	style = field.getValue().toString();
                control.setStyle(style);
            }
        }
        control.setControlType("panel");
        control.setDataType("Custom");
        /*
        if(node.isExpanded()) {
        	control.setStyle("expanded");
        }
        else {
        	control.setStyle("collapsed");
        }
        */
        control.setSequence(sequence);
        
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control,parentControl.getControlType());
            //controls.add(parentControl);
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(j);
                //setControlValues(treeNode, controls,control);
                setChildValues(treeNode, controls,control);
                //sequence++;
            }
        }
        return controls;
        
    }

    public List<Control> setTabValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        
        Tab tab = (Tab) node.getData();
        int size = tab.getTabItems().size();
        tab.getTabItems().get(0).getData();
        Control control=new Control();
//        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) tab.getTabItems().get(i).getData();
            if (field.getLabel().equals("Module Name"))
            {
                control.setModuleName(field.getValue().toString());
            }
            if (field.getLabel().equals("Component Name"))
            {
                control.setComponentName(field.getValue().toString());
            }
            if (field.getLabel().equals("Grid Column"))
            {
                control.setGridColumn(field.getValue().toString());
            }
            if (field.getLabel().equals("Page Heading"))
            {
                control.setPageHeading(field.getValue().toString());
            }
            if (field.getLabel().equals("Tab Data"))
            {
                control.setFormData(field.getValue().toString());
            }
           
        }
        
        control.setControlType("Tab");
//        control.setSequence(sequence);
        
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control,parentControl.getControlType());
           // controls.add(parentControl);
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(j);
                setChildValues(treeNode, controls,control);
                //sequence++;
            }
        }
        
        return controls;
        
        
    }
    
    public List<Control> setLabelValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        Label label = (Label) node.getData();
        int size = label.getLabelItems().size();
        Control control=new Control();
        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) label.getLabelItems().get(i).getData();
            if (field.getLabel().equals("Label"))
            {
                control.setName(field.getValue().toString());
            }
            if (field.getLabel().equals("Control ID"))
            {
                control.setControlId(field.getValue().toString());
            }
            if (field.getLabel().equals("Control Name"))
            {
                control.setControlType(field.getValue().toString());
            }
           
            
            
        }
        control.setControlType("Label");
        control.setSequence(sequence);
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control,parentControl.getControlType());
           // controls.add(parentControl);
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(0);
                //setControlValues(treeNode, controls,control);
                setChildValues(treeNode, controls,control);
               // sequence++;
            }
        }
        
        return controls;
        
    }
    
    public List<Control> setCheckBoxValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        CheckBox checkBox = (CheckBox) node.getData();
        int size = checkBox.getCheckBoxItems().size();
        Control control=new Control();
        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) checkBox.getCheckBoxItems().get(i).getData();
            if (field.getLabel().equals("Label"))
            {
                control.setLabel(field.getValue().toString());
            }
            if (field.getLabel().equals("Control ID"))
            {
                control.setControlId(field.getValue().toString());
            }
            if (field.getLabel().equals("Control Name"))
            {
                control.setName(field.getValue().toString());
            }
            if (field.getLabel().equals("CheckBox List"))
            {
                String checkList = field.getValue().toString();
                if (checkList.contains("|"))
                {
                    String[] checkListArray = checkList.split("\\|");
                    for (String string : checkListArray)
                    {
                        Control ctrl = new Control();
                        String[] split2 = string.split(",");
                        ctrl.setControlId(split2[0].substring(1));
                        ctrl.setControlType("checkbox");
                        ctrl.setName(control.getName());
                        ctrl.setLabel(split2[1].substring(0, split2[1].length() - 1));
                        control.addChild(ctrl,ctrl.getControlType());

                    }
                }

            }
           
            
            
        }
        control.setControlType("checkbox");
        control.setSequence(sequence);
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control,parentControl.getControlType());
           // controls.add(parentControl);
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(0);
                //setControlValues(treeNode, controls,control);
                setChildValues(treeNode, controls,control);
                //sequence++;
            }
        }
        
        return controls;
        
    }
    
    public List<Control> setDropDownValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        DropDown dropDown = (DropDown) node.getData();
        int size = dropDown.getDropDownItems().size();
        Control control=new Control();
        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) dropDown.getDropDownItems().get(i).getData();
            if (field.getLabel().equals("Label"))
            {
                control.setLabel(field.getValue().toString());
            }
            if (field.getLabel().equals("Control ID"))
            {
                control.setControlId(field.getValue().toString());
            }
            if (field.getLabel().equals("Control Name"))
            {
                control.setName(field.getValue().toString());
            }
            if ("Service Call".equals(field.getLabel()))
            {
                control.setServiceCall(field.getValue().toString());
            }
        }
        control.setControlType("Dropdown");
        control.setSequence(sequence);
        control.setDataType("string");
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control,parentControl.getControlType());
           // controls.add(parentControl);
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(0);
                //setControlValues(treeNode, controls,control);
                setChildValues(treeNode, controls,control);
                //sequence++;
            }
        }
        
        return controls;
        
    }
    
    public List<Control> setRadioButtonValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        RadioButton radioButton = (RadioButton) node.getData();
        int size = radioButton.getRadioBtnItems().size();
        Control control=new Control();
        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) radioButton.getRadioBtnItems().get(i).getData();
            if (field.getLabel().equals("Label"))
            {
                control.setLabel(field.getValue().toString());
            }
            if (field.getLabel().equals("Control ID"))
            {
                control.setControlId(field.getValue().toString());
            }
            if (field.getLabel().equals("Control Name"))
            {
                control.setName(field.getValue().toString());
            }
            if (field.getLabel().equals("Radio Button List"))
            {
                String checkList = field.getValue().toString();
                if (checkList.contains("|"))
                {
                    String[] checkListArray = checkList.split("\\|");
                    for (String string : checkListArray)
                    {
                        Control ctrl = new Control();
                        String[] split2 = string.split(",");
                        ctrl.setControlId(split2[0].substring(1));
                        ctrl.setControlType("radio");
                        ctrl.setName(control.getName());
                        ctrl.setParentId(String.valueOf(sequence));
                        ctrl.setLabel(split2[1].substring(0, split2[1].length() - 1));
                        control.addChild(ctrl,ctrl.getControlType());

                    }
                }

            }
           
            
            
        }
        control.setControlType("radio");
        control.setSequence(sequence);
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control,parentControl.getControlType());
           // controls.add(parentControl);
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(0);
                //setControlValues(treeNode, controls,control);
                setChildValues(treeNode, controls,control);
               // sequence++;
            }
        }
        
        return controls;
        
    }
    
    public boolean createControlTabHeader(List<Control> controls, Form form) {
		boolean tabHeader;
		Control control = new Control();
		control.setLabel("tabs");
		control.setControlType("tabs");
		control.setControlId("tabs"+String.valueOf(System.currentTimeMillis()));
		control.setDataType("Custom");
		control.setName("tabsName");
		control.setServiceCall(form.getFormData());
		controls.add(0, control);
		tabHeader = false;
		return tabHeader;
	}
    
    public List<Control> setButtonSubmitValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        ButtonSubmit buttonSubmit = (ButtonSubmit) node.getData();
        int size = buttonSubmit.getSubmitButtonItems().size();
        Control control=new Control();
        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) buttonSubmit.getSubmitButtonItems().get(i).getData();
            if ("Label".equals(field.getLabel()))
            {
                control.setLabel(field.getValue().toString());
            }
            if ("Control ID".equals(field.getLabel()))
            {
                control.setControlId(field.getValue().toString());
            }
            if ("Control Name".equals(field.getLabel()))
            {
                control.setName(field.getValue().toString());
            }
            if ("Service Call".equals(field.getLabel()))
            {
                control.setServiceCall(field.getValue().toString());
            }
        }
        control.setControlType("submit");
        control.setSequence(sequence);
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control,parentControl.getControlType());
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(0);
                setChildValues(treeNode, controls,control);
            }
        }
        return controls;
    }
    
    public List<Control> setButtonInputValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        ButtonInput buttonInput = (ButtonInput) node.getData();
        int size = buttonInput.getInputButtonItems().size();
        Control control=new Control();
        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) buttonInput.getInputButtonItems().get(i).getData();
            if ("Label".equals(field.getLabel()))
            {
                control.setLabel(field.getValue().toString());
            }
            if ("Control ID".equals(field.getLabel()))
            {
                control.setControlId(field.getValue().toString());
            }
            if ("Control Name".equals(field.getLabel()))
            {
                control.setName(field.getValue().toString());
            }
            if ("Service Call".equals(field.getLabel()))
            {
                control.setServiceCall(field.getValue().toString());
            }
        }
        control.setControlType("input");
        control.setSequence(sequence);
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control,parentControl.getControlType());
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(0);
                setChildValues(treeNode, controls,control);
            }
        }
        return controls;
    }
    
    public List<Control> setTableValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        Table table = (Table) node.getData();
        int size = table.getTableItems().size();
        Control control=new Control();
        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) table.getTableItems().get(i).getData();
            if (field.getLabel().equals("Label"))
            {
                control.setLabel(field.getValue().toString());
            }
            if (field.getLabel().equals("Control ID"))
            {
                control.setControlId(field.getValue().toString());
            }
            if (field.getLabel().equals("Control Name"))
            {
                control.setName(field.getValue().toString());
            }
            if (field.getLabel().equals("Service Call"))
            {
                control.setServiceCall(field.getValue().toString());
            }
            
        }

        control.setDataType("Custom");
        control.setControlType("Table");
        control.setSequence(sequence);
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control, parentControl.getControlType());
           // controls.add(parentControl);
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(0);
               // setControlValues(treeNode, controls,control);
                setChildValues(treeNode, controls,control);
               // sequence++;
            }
        }
        
        return controls;
        
    }
    
    public List<Control> setMenuListValues(Object data, List<Control> controls, TreeNode node, Control parentControl)
    {
        MenuList menuList = (MenuList) node.getData();
        int size = menuList.getMenuListItems().size();
        menuList.getMenuListItems().get(0).getData();
        Control control=new Control();
        sequence++;
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField)  menuList.getMenuListItems().get(i).getData();
            if (field.getLabel().equals("Menu List Label"))
            {
                control.setLabel(field.getValue().toString());
            }
            if (field.getLabel().equals("Menu List ID"))
            {
                control.setControlId(field.getValue().toString());
            }
            if (field.getLabel().equals("Menu List Name"))
            {
                control.setName(field.getValue().toString());
            }
            if (field.getLabel().equals("Service Call"))
            {
                control.setServiceCall(field.getValue().toString());
            }
        }
        
        control.setDataType("Custom");
        control.setControlType("menuList");
        control.setSequence(sequence);
        
        if(parentControl==null)
        {
            controls.add(control);
        }
        else
        {
            parentControl.addChild(control, parentControl.getControlType());
        }
        if(node.getChildCount()!=0)
        {
            int size2 = node.getChildren().size();
            for (int j = 0; j < size2; j++)
            {
                TreeNode treeNode = node.getChildren().get(j);
                setChildValues(treeNode, controls,control);
            }
        }
        return controls;
        
    }

    

    
}
