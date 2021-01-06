package com.logicbig.example;

import java.util.List;


public class GridObject
{

    private String grid_Name;

    private List<TextField> m_textFields;

    public String getGrid_Name()
    {
        return grid_Name;
    }

    public void setGrid_Name(String grid_Name)
    {
        this.grid_Name = grid_Name;
    }

    public List<TextField> getM_textFields()
    {
        return m_textFields;
    }

    public void setM_textFields(List<TextField> m_textFields)
    {
        this.m_textFields = m_textFields;
    }

}
