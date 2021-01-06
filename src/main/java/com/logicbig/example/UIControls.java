package com.logicbig.example;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@SessionScoped
public class UIControls
{

    private String section_Name;

   
    private List<GridObject> grid_Name;
    
    private String selectedControl;
    
    private boolean flag_textField;
    
    private boolean flag_dropDown;

    public String getSection_Name()
    {
        return section_Name;
    }

    public void setSection_Name(String section_Name)
    {
        this.section_Name = section_Name;
    }

    public List<GridObject> getGrid_Name()
    {
        return grid_Name;
    }

    public void setGrid_Name(List<GridObject> grid_Name)
    {
        this.grid_Name = grid_Name;
    }

    public String getSelectedControl()
    {
        return selectedControl;
    }

    public void setSelectedControl(String selectedControl)
    {
        this.selectedControl = selectedControl;
    }
    
    public void localeChanged(ValueChangeEvent e) {
        //assign new value to country
        
        
        
  
        System.out.println("new Value:"+e.getNewValue());
        
       // setFlag_textField(true);
        String newValue = e.getNewValue().toString();
        
        if (newValue.equals("TextField"))
        {
            setFlag_textField(true);
            setFlag_dropDown(false);
        }
        else
            if (newValue.equals("DropDown"))
            {
                setFlag_dropDown(true);
                setFlag_textField(false);
            }
            else
            {
                setFlag_dropDown(false);
                setFlag_textField(false);
            }
          
         
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

}
