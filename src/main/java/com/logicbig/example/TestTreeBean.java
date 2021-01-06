package com.logicbig.example;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;


@javax.faces.bean.ManagedBean
@javax.faces.bean.ViewScoped
public class TestTreeBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    private TreeNode root;
    private TreeNode selected;
    SomeData data;

    // build a dummy tree...    
    @PostConstruct
    public void init()
    {
        root = new DefaultTreeNode();
        for(int i = 0; i < 5; i++)
        {
            data = new SomeData("node " + i, String.valueOf(System.currentTimeMillis()));
            TreeNode node = new DefaultTreeNode(data, root);
            for(int j = 0; j < 5; j++)
            {
                SomeData subData = new SomeData("subNode " + i + "." + j, String.valueOf(System.currentTimeMillis()));
                @SuppressWarnings("unused")
                TreeNode subNode = new DefaultTreeNode(subData, node);
            }
        }
    }

    // handle selection swap manually
    public void onSelect(NodeSelectEvent event)
    {
        if(selected != null)
        {
            selected.setSelected(false);
        }

        selected = event.getTreeNode();

        if(selected != null)
        {
            selected.setSelected(true);
        }
    }

    // shortcut for getting the selected node data
    public Object getData()
    {
        return selected == null ? null : selected.getData();
    }

    public TreeNode getSelected()
    {
        return selected;
    }

    public TreeNode getRoot()
    {
        return root;
    }
}
