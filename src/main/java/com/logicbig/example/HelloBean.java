package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import java.time.LocalDateTime;


@Component
@ViewScoped
public class HelloBean {

    @Autowired
    private MsgService msgService;
   
    private boolean flag;
    
    private String selectedControl;
    
    private boolean flag_textField;
    
    private boolean flag_dropDown;
    

    public String getMsg() {
        return msgService.getMsg();
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    
    public void localeChanged(ValueChangeEvent e) {
       
        System.out.println("new Value:"+e.getNewValue());
        if(e.getNewValue()=="TextField")
        {
            setFlag_textField(true);
        }
        else if(e.getNewValue()=="DropDown")
        {
            setFlag_dropDown(true);
        }
        else {
            setFlag_dropDown(false);
            setFlag_textField(false);
        };
     }

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
}