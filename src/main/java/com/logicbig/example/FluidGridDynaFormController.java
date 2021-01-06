package com.logicbig.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.extensions.model.fluidgrid.FluidGridItem;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@ManagedBean(name = "fluidGridDynaFormController")
@SessionScoped
public class FluidGridDynaFormController implements Serializable
{

    private static final long serialVersionUID = 1L;

    private List<FluidGridItem> items;

    private String selectItem;

    private List<String> sectionListItem;

    private boolean sectionListItemFlag = false;

    private TreeNode singleSelectedTreeNode;

    private TreeNode root;

    private TextField textField;
    
    private Label label;

    private Section section;

    private String selectItemSection;
    
    private Tab tab;
    
    private Form form;
    
    private CheckBox checkBox;
    
    private DropDown dropDown;
    
    private RadioButton radioButton;
    
    private ButtonSubmit buttonSubmit;
    
    private ButtonInput buttonInput;
    
    private Table table;
    
    private MenuList menuList;

    public void localeChanged(ValueChangeEvent e)
    {

        selectItem = e.getNewValue().toString();
        System.out.println("Select Item : " + selectItem);

        if (selectItem.equals("Form"))
        {
            items = new ArrayList<FluidGridItem>();
            items.add(new FluidGridItem(new DynamicField("Module Name", null, true, null), "input"));
            items.add(new FluidGridItem(new DynamicField("Component Name", null, true, null), "input"));
            items.add(new FluidGridItem(new DynamicField("Grid Column", null, true, null), "input"));
            items.add(new FluidGridItem(new DynamicField("Page Heading", null, true, null), "input"));
            items.add(new FluidGridItem(new DynamicField("Form Data", null, true, null), "input"));
            items.add(new FluidGridItem(new DynamicField("Parent Container", null, false, null), "input"));
            form = new Form();
            form.setFormItems(items);
            
        }
        else
        if (selectItem.equals("Tab"))
        {
            items = new ArrayList<FluidGridItem>();
            items.add(new FluidGridItem(new DynamicField("Module Name", null, true, null), "input"));
            items.add(new FluidGridItem(new DynamicField("Component Name", null, true, null), "input"));
            items.add(new FluidGridItem(new DynamicField("Grid Column", null, true, null), "input"));
            items.add(new FluidGridItem(new DynamicField("Page Heading", null, true, null), "input"));
            items.add(new FluidGridItem(new DynamicField("Tab Data", null, true, null), "input"));
            tab = new Tab();
            tab.setTabItems(items);
        }
        else
            if (selectItem.equals("Section"))
            {
                items = new ArrayList<FluidGridItem>();
                items.add(new FluidGridItem(new DynamicField("Section Label", null, true, null),
                    "input"));
                items.add(new FluidGridItem(new DynamicField("Section ID", null, true, null),
                                "input"));
                items.add(new FluidGridItem(new DynamicField("Section Name", null, true, null),
                                "input"));
                items.add(new FluidGridItem(new DynamicField("Initial State", null, false, null),
                        "input"));
                section = new Section();
                section.setSectionItems(items);
                
            }
            else
                if (selectItem.equals("TextField"))
                {
                    items = new ArrayList<FluidGridItem>();
                    textField = new TextField();
                    items.add(new FluidGridItem(
                        new DynamicField("Label", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control ID", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control Name", null, true, null), "input"));
                    textField.setTextFieldItems(items);
                    //TreeNode child = new DefaultTreeNode(getTextField());

                    //getRoot().getChildren().get(0).getChildren().get(0).getChildren().add(child);

                }
                else if(selectItem.equals("Label"))
                {
                    items = new ArrayList<FluidGridItem>();
                    label = new Label();
                    items.add(new FluidGridItem(
                        new DynamicField("Label", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control ID", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control Name", null, true, null), "input"));
                    label.setLabelItems(items);
                }
                else if(selectItem.equals("Button (Submit)"))
                {
                    items = new ArrayList<FluidGridItem>();
                    buttonSubmit = new ButtonSubmit();
                    items.add(new FluidGridItem(
                        new DynamicField("Label", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control ID", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control Name", null, true, null), "input"));
                    items.add(new FluidGridItem(
                            new DynamicField("Service Call", null, true, null), "input"));
                    buttonSubmit.setSubmitButtonItems(items);
                }
                else if(selectItem.equals("CheckBox"))
                {
                    items = new ArrayList<FluidGridItem>();
                    checkBox = new CheckBox();
                    items.add(new FluidGridItem(
                        new DynamicField("Label", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control ID", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control Name", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("CheckBox List", null, true, null), "input"));
                }
                else if(selectItem.equals("DropDown"))
                {
                    items = new ArrayList<FluidGridItem>();
                    checkBox = new CheckBox();
                    items.add(new FluidGridItem(
                        new DynamicField("Label", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control ID", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control Name", null, true, null), "input"));
                    items.add(new FluidGridItem(
                            new DynamicField("Service Call", null, true, null), "input"));
                    
                }
                else if(selectItem.equals("RadioButton"))
                {
                    items = new ArrayList<FluidGridItem>();
                    checkBox = new CheckBox();
                    items.add(new FluidGridItem(
                        new DynamicField("Label", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control ID", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control Name", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Radio Button List", null, true, null), "input"));
                }
                else if(selectItem.equals("Button (Input)"))
                {
                    items = new ArrayList<>();
                    buttonInput = new ButtonInput();
                    items.add(new FluidGridItem(
                        new DynamicField("Label", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control ID", null, true, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Control Name", null, true, null), "input"));
                    items.add(new FluidGridItem(
                            new DynamicField("Service Call", null, true, null), "input"));
                    buttonInput.setInputButtonItems(items);
                }
                else if (selectItem.equals("Table"))
                {
                    items = new ArrayList<FluidGridItem>();
                    items.add(new FluidGridItem(new DynamicField("Label", null, true, null), "input"));
                    items.add(new FluidGridItem(new DynamicField("Control ID", null, true, null), "input"));
//                    items.add(new FluidGridItem(new DynamicField("Control Type", null, true, null), "input"));
                    items.add(new FluidGridItem(new DynamicField("Control Name", null, true, null), "input"));
                    items.add(new FluidGridItem(new DynamicField("Service Call", null, true, null), "input"));
                    table = new Table();
                    table.setTableItems(items);
                    
                }
                else
                    if (selectItem.equals("Menu List"))
                    {
                        items = new ArrayList<FluidGridItem>();
                        items.add(new FluidGridItem(new DynamicField("Menu List Label", null, true, null), "input"));
                        items.add(new FluidGridItem(new DynamicField("Menu List ID", null, true, null), "input"));
                        items.add(new FluidGridItem(new DynamicField("Menu List Name", null, true, null), "input"));
                        items.add(new FluidGridItem(new DynamicField("Service Call", null, true, null), "input"));
                        menuList = new MenuList();
                        menuList.setMenuListItems(items);
                        
                    }
                else
                {

                    final List<SelectItem> selectItems = new ArrayList<SelectItem>();
                    selectItems.add(new SelectItem("1", "Label 1"));
                    selectItems.add(new SelectItem("2", "Label 2"));
                    selectItems.add(new SelectItem("3", "Label 3"));

                    items.add(new FluidGridItem(new DynamicField("First Label", null, true, null),
                        "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Second Label", "Some default value", false, null),
                        "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Third Label", null, false, selectItems), "select"));
                    items.add(new FluidGridItem(
                        new DynamicField("Fourth Label", "2", false, selectItems), "select"));
                    // items.add(new FluidGridItem(new DynamicField("Fifth Label", null, true,
                    // null), "calendar"));
                    // items.add(new FluidGridItem(new DynamicField("Sixth Label", new Date(),
                    // false, null), "calendar"));
                    items.add(new FluidGridItem(
                        new DynamicField("Seventh Label", null, false, null), "input"));
                    items.add(new FluidGridItem(
                        new DynamicField("Eighth Label", null, false, selectItems), "select"));
                    // items.add(new FluidGridItem(new DynamicField("Ninth Label", null, false,
                    // null), "calendar"));
                }
    }

    @PostConstruct
    protected void initialize()
    {
       
        
        //root = new DefaultTreeNode("TAB", null);
        //TreeNode tab = new DefaultTreeNode("TAB", root);
        //TreeNode section = new DefaultTreeNode("Section", tab);
         

    }

    public List<FluidGridItem> getItems()
    {
        return items;
    }

    public String getSelectItem()
    {
        return selectItem;
    }

    public void setSelectItem(String selectItem)
    {
        this.selectItem = selectItem;
    }

    public void createTree()
    {
        System.out.println("Inside create Tree ");
        System.out.println("Inside command Button :" + this.selectItem);
        if (this.selectItem != null)
        {

            if (this.selectItem.equals("Form"))
            {
                form = new Form();
                form.setFormItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());

                form.setTreeName(data.getValue().toString());
                root = new DefaultTreeNode("Form", null);
                TreeNode form = new DefaultTreeNode(this.form, root);

            }
            if (this.selectItem.equals("Tab"))
            {
                tab = new Tab();
                tab.setTabItems(items);
//                DynamicField data = (DynamicField) items.get(0).getData();
                DynamicField data = (DynamicField) items.get(1).getData();
                System.out.println(data.getValue());

                tab.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.tab, null);
                List<TreeNode> children = getRoot().getChildren().get(0).getChildren();
                if (root != null && children != null)
                {
                    getRoot().getChildren().get(0).getChildren().add(child);
                }

            }

            if (this.selectItem.equals("Section"))
            {
                section = new Section();
                section.setSectionItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());
                section.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.section, null);
                System.out
                    .println("default section:" + getRoot().getChildren().get(0).getChildren());
                
                   
                if (root != null && singleSelectedTreeNode == null)
                {
                    getRoot().getChildren().get(0).getChildren().get(0).getChildren().add(child);
                }
                else
                    if (singleSelectedTreeNode != null)
                    {
                        singleSelectedTreeNode.getChildren().add(child);
                    }

            }

            if (this.selectItem.equals("TextField"))
            {
                textField = new TextField();
                textField.setTextFieldItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());
                textField.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.textField, null);
                // child.setType("TextField");

                if (singleSelectedTreeNode == null)
                {
                    getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0)
                        .getChildren().add(child);
                }
                else
                    if (singleSelectedTreeNode != null)
                    {
                        singleSelectedTreeNode.getChildren().add(child);
                    }
                    else
                    {

                    }
            }

            if (this.selectItem.equals("Label"))
            {
                label = new Label();
                label.setLabelItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());
                label.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.label, null);
                // child.setType("TextField");

                if (singleSelectedTreeNode == null)
                {
                    getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0)
                        .getChildren().add(child);
                }
                else
                    if (singleSelectedTreeNode != null)
                    {
                        singleSelectedTreeNode.getChildren().add(child);
                    }
                    else
                    {

                    }
            }
            if ("Button (Submit)".equals(this.selectItem))
            {
                buttonSubmit = new ButtonSubmit();
                buttonSubmit.setSubmitButtonItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());
                buttonSubmit.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.buttonSubmit, null);

				if (singleSelectedTreeNode == null) {
					getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().add(child);
				} else {
					singleSelectedTreeNode.getChildren().add(child);
				}
            }
            if (this.selectItem.equals("CheckBox"))
            {
                checkBox = new CheckBox();
                checkBox.setCheckBoxItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());
                checkBox.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.checkBox, null);
                // child.setType("TextField");

                if (singleSelectedTreeNode == null)
                {
                    getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0)
                        .getChildren().add(child);
                }
                else
                    if (singleSelectedTreeNode != null)
                    {
                        singleSelectedTreeNode.getChildren().add(child);
                    }
                    else
                    {

                    }
            }
            if (this.selectItem.equals("RadioButton"))
            {
                radioButton = new RadioButton();
                radioButton.setRadioBtnItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());
                radioButton.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.radioButton, null);
                // child.setType("TextField");

                if (singleSelectedTreeNode == null)
                {
                    getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0)
                        .getChildren().add(child);
                }
                else
                    if (singleSelectedTreeNode != null)
                    {
                        singleSelectedTreeNode.getChildren().add(child);
                    }
                    else
                    {

                    }
            }
            if (this.selectItem.equals("DropDown"))
            {
                dropDown = new DropDown();
                dropDown.setDropDownItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());
                dropDown.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.dropDown, null);
                // child.setType("TextField");

                if (singleSelectedTreeNode == null)
                {
                    getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0)
                        .getChildren().add(child);
                }
                else
                    if (singleSelectedTreeNode != null)
                    {
                        singleSelectedTreeNode.getChildren().add(child);
                    }
                    else
                    {

                    }
            }
            if ("Button (Input)".equals(this.selectItem))
            {
                buttonInput = new ButtonInput();
                buttonInput.setInputButtonItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());
                buttonInput.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.buttonInput, null);

				if (singleSelectedTreeNode == null) {
					getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().add(child);
				} else {
					singleSelectedTreeNode.getChildren().add(child);
				}
            }
            
            if (this.selectItem.equals("Table"))
            {
                table = new Table();
                table.setTableItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println("Table : " + data.getValue());
                table.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.table, null);
                // child.setType("TextField");

                if (singleSelectedTreeNode == null)
                {
                    getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0)
                        .getChildren().add(child);
                }
                else
                    if (singleSelectedTreeNode != null)
                    {
                        singleSelectedTreeNode.getChildren().add(child);
                    }
                    else
                    {

                    }
            }
            
            if (this.selectItem.equals("Menu List"))
            {
                menuList = new MenuList();
                menuList.setMenuListItems(items);
                DynamicField data = (DynamicField) items.get(0).getData();
                System.out.println(data.getValue());
                menuList.setTreeName(data.getValue().toString());
                TreeNode child = new DefaultTreeNode(this.menuList, null);                
                   
                if (root != null && singleSelectedTreeNode == null)
                {
                    getRoot().getChildren().get(0).getChildren().get(0).getChildren().add(child);
                }
                else
                    if (singleSelectedTreeNode != null)
                    {
                        singleSelectedTreeNode.getChildren().add(child);
                    }

            }

        }
        
        
        this.selectItem=null;
        this.items=null;

        

    }
    
    public void createTreeToJson()
    {
        System.out.println("Inside create Json ");
        System.out.println("Inside GetJson command Button :" + this.getRoot().getChildren().get(0).getChildren().get(0));
        List<Control> controls = new ArrayList<Control>();
        ControlDAO controlDAO=new ControlDAO();
        
        
        if(this.getRoot() != null)
        {
            Form frm= (Form) this.getRoot().getChildren().get(0).getData();
            Form form = setFrom(frm);
            List<Form> formList= new ArrayList<>();
            
            List<TreeNode> children = this.getRoot().getChildren().get(0).getChildren();
            Iterator<TreeNode> iterator = children.iterator();
            boolean tabHeader = true;
            while (iterator.hasNext())
            {
                TreeNode node=iterator.next();
                
                if(node.getData() instanceof Tab && tabHeader) {
                	tabHeader = controlDAO.createControlTabHeader(controls, form);
                }
                controlDAO.setControlValues(node, controls);
            }
            
            form.setControls(controls);
            formList.add(form);
            Map<String, List<Form>> map = new HashMap<>();
            map.put("Form", formList);
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            String json = gson.toJson(map);
            try (Writer writer = new FileWriter("E:/JSON_SAMPLE/"+System.currentTimeMillis()+".json")) {
                gson.toJson(map, writer);
            } catch (IOException e) {
            	System.out.println("error occurred while generating json file : "+e.getMessage());
			}
            System.out.println("JSON:"+json);
        }
    }

    private static Form setFrom(Form f)
    {
        Form form = new Form();
        int size = f.getFormItems().size();
        f.getFormItems().get(0).getData();
        for (int i = 0; i < size; i++)
        {
            DynamicField field = (DynamicField) f.getFormItems().get(i).getData();
            if (field.getLabel().equals("Module Name"))
            {
                form.setModuleName(field.getValue().toString());
            }
            if (field.getLabel().equals("Component Name"))
            {
                form.setComponentName(field.getValue().toString());
            }
            if (field.getLabel().equals("Grid Column"))
            {
                form.setGridColumn(field.getValue().toString());
            }
            if (field.getLabel().equals("Page Heading"))
            {
                form.setPageHeading(field.getValue().toString());
            }
            if (field.getLabel().equals("Form Data"))
            {
                form.setFormData(field.getValue().toString());
            }
            if("Parent Container".equals(field.getLabel()))
            {
            	form.setParentContainer(field.getValue().toString());
            }
        }
        return form;
    }

    private List<DynamicField> getchildren(TreeNode treeNode)
    {
        Object object = this.getRoot().getChildren().get(0).getData();
        List<DynamicField> dynamicField = new ArrayList<DynamicField>();
        if(object instanceof Tab)
        {
            Tab t= (Tab) this.getRoot().getChildren().get(0).getData();
            List<FluidGridItem> tabItems = t.getTabItems();
            if(tabItems!=null)
            {
                for (FluidGridItem fluidGridItem : tabItems)
                {
                    DynamicField data = (DynamicField) fluidGridItem.getData();
                    dynamicField.add(data);
                }
            }
             
        }
        return dynamicField;
    }

    public TreeNode getRoot()
    {
        return root;
    }

    public void setRoot(TreeNode root)
    {
        this.root = root;
    }

    public List<String> getSectionListItem()
    {
        return sectionListItem;
    }

    public void setSectionListItem(List<String> sectionListItem)
    {
        this.sectionListItem = sectionListItem;
    }

    public boolean isSectionListItemFlag()
    {
        return sectionListItemFlag;
    }

    public void setSectionListItemFlag(boolean sectionListItemFlag)
    {
        this.sectionListItemFlag = sectionListItemFlag;
    }

    public String getSelectItemSection()
    {
        return selectItemSection;
    }

    public void setSelectItemSection(String selectItemSection)
    {
        this.selectItemSection = selectItemSection;
    }

    public void selectControl()
    {
        System.out.println("new Value:" + this.selectItemSection);
    }

    public void onNodeSelect(NodeSelectEvent event)
    {
        System.out.println("Node Data ::" + event.getTreeNode().getData() + " :: Selected");
        System.out.println("Dropdown selected:" + this.singleSelectedTreeNode);

    }

    public void onNodeDocumentSelect(NodeSelectEvent nodeSelected)
    {
        System.out.println("Tree Node ajax call:" + nodeSelected.getTreeNode().getData());
        //System.out.println(nodeSelected.getTreeNode().getChildren().get(0).getData());
        //System.out.println(
            //getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0).getData());
        

    }

    public TreeNode getSingleSelectedTreeNode()
    {
        return singleSelectedTreeNode;
    }

    public void setSingleSelectedTreeNode(TreeNode singleSelectedTreeNode)
    {
        this.singleSelectedTreeNode = singleSelectedTreeNode;
    }

    public void createTree1()
    {

        System.out.println("Inside create Tree 1 ");
        System.out.println("Inside command Button :" + this.selectItem);
        if (this.selectItem != null)
        {
            if (this.selectItem.equals("TextField"))
            {
                setTextField(new TextField());
                getTextField().setTextFieldItems(items);
                TreeNode child = new DefaultTreeNode(getTextField());

                getRoot().getChildren().get(0).getChildren().get(0).getChildren().add(child);
            }
            if (this.selectItem.equals("Section"))
            {
                section = new Section();
                section.setSectionItems(items);
                TreeNode child = new DefaultTreeNode(section);
                getRoot().getChildren().get(0).getChildren().add(child);
                System.out
                    .println("default section:" + getRoot().getChildren().get(0).getChildren());
                List<TreeNode> children = getRoot().getChildren().get(0).getChildren();
                if (children.size() > 1)
                {
                    sectionListItem = new ArrayList<String>();
                    this.setSectionListItemFlag(true);
                    System.out.println(children.toString());
                    for (TreeNode treeNode : children)
                    {
                        sectionListItem.add(treeNode.toString());
                    }

                }
            }

        }

    }

    public TextField getTextField()
    {
        return textField;
    }

    public void setTextField(TextField textField)
    {
        this.textField = textField;
    }

}
