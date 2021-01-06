package com.logicbig.example;

import java.io.Serializable;


public class SomeData implements Serializable
{
    private String someText1;
    private String someText2;

    public SomeData()
    {
        super();
    }

    public SomeData(String someText1, String someText2)
    {
        super();
        this.someText1 = someText1;
        this.someText2 = someText2;
    }

    public String getSomeText1()
    {
        return someText1;
    }

    public void setSomeText1(String someText1)
    {
        this.someText1 = someText1;
    }

    public String getSomeText2()
    {
        return someText2;
    }

    public void setSomeText2(String someText2)
    {
        this.someText2 = someText2;
    }
}
