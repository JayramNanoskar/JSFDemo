package com.logicbig.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.extensions.model.fluidgrid.FluidGridItem;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name="treeBean")
@SessionScoped
public class TreeBean implements Serializable {
 
	private static final long serialVersionUID = 3350653785168926842L;
	private TreeNode root;
    private TreeNode[] selectedNodes2;
    private TreeNode singleSelectedTreeNode;
    
    
    private String name;
    
    private List<Field> fields;
    
    private PanelGrid panelgrid;
    
    Field f1=new Field();
    Field f2=new Field();
    Field f3=new Field();

    private List<FluidGridItem> items;
    
    private TextField textField;
    
    private Section section;

    private Tab tab;
    
	
	 private String selectedControl;
	    
	    public String getSelectedControl()
    {
        return selectedControl;
    }


    public void setSelectedControl(String selectedControl)
    {
        this.selectedControl = selectedControl;
    }


    public boolean isFlag_textField()
    {
        return flag_textField;
    }


    public void setFlag_textField(boolean flag_textField)
    {
        this.flag_textField = flag_textField;
    }


    public boolean isFlag_dropDown()
    {
        return flag_dropDown;
    }


    public void setFlag_dropDown(boolean flag_dropDown)
    {
        this.flag_dropDown = flag_dropDown;
    }


        private boolean flag_textField;
	    
	    private boolean flag_dropDown;
    
    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("TAB", null);
        TreeNode tab = new DefaultTreeNode("TAB", root);
        TreeNode section = new DefaultTreeNode("Section", tab);
        
       
    }
    
    
    public void localeChanged(ValueChangeEvent e) {
        TreeBean treeBean = (TreeBean) FacesContext.getCurrentInstance().
                        getExternalContext().getSessionMap().get("treeBean"); 
        System.out.println("Root Node:"+treeBean.getRoot());
        System.out.println("Select Control:"+treeBean.getSelectedControl());
        String root=treeBean.getRoot().getChildren().get(0).getChildren().get(0).toString();
        String selectMenu= e.getNewValue().toString();;
       
        
        
        if(root.contains("Section") && selectMenu.equals("Section"))
        {
            treeBean.getRoot().getChildren().get(0).getChildren().add(new DefaultTreeNode("Section 1"));  
        }
        
        if(root.contains("Section") && (selectMenu.equals("TextField") || selectMenu.equals("CheckBox") || selectMenu.equals("Radio Button")))
        {
            textField=new TextField();
            
            f1.setType("InputText");
            f1.setLabel("email");
            f1.setValue("");
            
            List<Field> fields = new ArrayList<Field>();
            fields.add(f1);
            fields.add(f2);
            fields.add(f3);
            
            textField.setFields(fields);
            
            System.out.println(panelgrid.getId());
            if(this.textField!= null && this.textField.getFields()!=null) {
                for (Field field : this.textField.getFields()) {
                     switch (field.getType())
                   {
                       case "InputText":
                           UIColumn col = new UIColumn();
                           HtmlOutputText ot = new HtmlOutputText();
                           ot.setValue(field.getLabel());
                           col.getChildren().add(ot);
                           HtmlInputText it = new HtmlInputText();
                           it.setValueExpression("value", createValueExpression("#{treeBean.name}", String.class));
                           
                           col.getChildren().add(it);

                           if (panelgrid == null) {
                               panelgrid = new PanelGrid();
                           }
                           panelgrid.getChildren().add(col);
                           break;
                      
                       default:
                           break;
                   }
                            
                            break;
                      
                }
            }
            System.out.println(textField.getFields().get(0).getValue());
          
            
            
        }
        
        
    }
    
 
    public TreeNode getRoot() {
        return root;
    }


    public TreeNode[] getSelectedNodes2()
    {
        return selectedNodes2;
    }


    public void setSelectedNodes2(TreeNode[] selectedNodes2)
    {
        this.selectedNodes2 = selectedNodes2;
    }


    public TreeNode getSingleSelectedTreeNode()
    {
        return singleSelectedTreeNode;
    }


    public void setSingleSelectedTreeNode(TreeNode singleSelectedTreeNode)
    {
        this.singleSelectedTreeNode = singleSelectedTreeNode;
    }
    
   
    
    public void onNodeSelect(NodeSelectEvent event){
        System.out.println("Node Data ::"+event.getTreeNode().getData()+" :: Selected");
        System.out.println("Dropdown selected:"+this.getSelectedControl());
        event.getTreeNode().getChildren().add(new DefaultTreeNode("Child"));
    }
    
    public void onNodeDocumentSelect(NodeSelectEvent nodeSelected) {
         System.out.println("Tree Node ajax call:"+nodeSelected.getTreeNode().getData());
         //items=((TextField)singleSelectedTreeNode.getData()).getItems();
         UIComponent component = nodeSelected.getComponent();
         System.out.println(panelgrid.getId());
         if(this.textField!= null && this.textField.getFields()!=null) {
             for (Field field : this.textField.getFields()) {
                  switch (field.getType())
                {
                    case "InputText":
                        UIColumn col = new UIColumn();
                        HtmlOutputText ot = new HtmlOutputText();
                        ot.setValue(field.getLabel());
                        col.getChildren().add(ot);
                        HtmlInputText it = new HtmlInputText();
                        it.setId("Jayram");
                        it.setValueExpression("value", createValueExpression("#{field.value}", String.class));
                       
                        col.getChildren().add(it);

                        if (panelgrid == null) {
                            panelgrid = new PanelGrid();
                        }
                        panelgrid.getChildren().add(col);
                        break;
                   
                    default:
                        break;
                }
                         
                         break;
                   
             }
         }
         System.out.println(textField.getFields().get(0).getValue());
         
           
           
       
    }
    
    public void populateForm(ComponentSystemEvent event) 
    {
        HtmlForm form = (HtmlForm) event.getComponent();
        System.out.println(this.textField.getFields());
       
       
    }
    
    public static ValueExpression createValueExpression(String valueExpression,
                                                        Class<?> valueType) {
                                                    FacesContext context = FacesContext.getCurrentInstance();
                                                    return context
                                                            .getApplication()
                                                            .getExpressionFactory()
                                                            .createValueExpression(context.getELContext(), valueExpression,
                                                                    valueType);
                                                }


    public List<Field> getFields()
    {
        return fields;
    }


    public void setFields(List<Field> fields)
    {
        this.fields = fields;
    }
    
    public Object getData()
    {
        return singleSelectedTreeNode == null ? null : singleSelectedTreeNode.getData();
    }


    public List<FluidGridItem> getItems()
    {
        return items;
    }


    public void setItems(List<FluidGridItem> items)
    {
        this.items = items;
    }


    public TextField getTextField()
    {
        return textField;
    }


    public void setTextField(TextField textField)
    {
        this.textField = textField;
    }


    public PanelGrid getPanelgrid()
    {
        return panelgrid;
    }


    public void setPanelgrid(PanelGrid panelgrid)
    {
        this.panelgrid = panelgrid;
    }
    
    public void createTree()
    {
        System.out.println("Inside create Tree ");
        System.out.println("Inside command Button :" + this.selectedControl);
       
        if (this.selectedControl != null)
        {
            if (this.selectedControl.equals("TAB"))
            {
                tab= new Tab();
                tab.setTabItems(items);
                items.get(0).getData().getClass().getFields();
               
               // tab.setName("sfsdfsd");
                root = new DefaultTreeNode("TAB", null);
                TreeNode tab = new DefaultTreeNode(this.tab, root);
                
            }
            
            if (this.selectedControl.equals("Section"))
            {
                section = new Section();
                section.setSectionItems(items);
                section.setName("Section");
                TreeNode child = new DefaultTreeNode(this.section, null);
                System.out
                    .println("default section:" + getRoot().getChildren().get(0).getChildren());
                List<TreeNode> children = getRoot().getChildren().get(0).getChildren();
                if(root != null && children!=null) {
                getRoot().getChildren().get(0).getChildren().add(child);
                }
               
            }
            
            if (this.selectedControl.equals("TextField"))
            {
                textField = new TextField();
                textField.setName(this.name);
                TreeNode child = new DefaultTreeNode(this.textField, null);
                //child.setType("TextField");
                getRoot().getChildren().get(0).getChildren().get(0).getChildren().add(child);
                
                }
               
            }

        

    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }
}