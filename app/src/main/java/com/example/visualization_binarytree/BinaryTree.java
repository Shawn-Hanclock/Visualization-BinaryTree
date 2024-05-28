package com.example.visualization_binarytree;//import java.util.ArrayList;

public class BinaryTree
{
    // variables
    private Node root;

    // constructor
    public BinaryTree(int data)
    {
        root = new Node(data);
    }
    public BinaryTree(int[] data)
    {
        root = new Node();
        for(int n: data) {
            this.addData(n);
        }
    }
    public BinaryTree()
    {
        root = new Node();
    }
    // getter and setter
    public Node getRoot()
    {
        return root;
    }
    public void setRoot(Node data)
    {
        root = data;
    }

    // brain methods
    public int treeLeaf() {
        return root.leafCount();
    }
    public void addData(int data)
    {
        if(root.getData() != null) root.addNew(data);
        else root.setData(data);
    }
    public void addData(int[] data)
    {
        for(int n: data) {
            if(root.getData() != null) root.addNew(n);
            else root.setData(n);
        }
    }

    // output formatted data
    public String toString()
    {
        String out = root.printBranches();
        if(out.equals(""))
            return "Tree yet to be filled.";
        else {
            out = out.substring(0,out.length()-1);
            return "[" + out.replaceAll(" ", ", ") + "]";
        }
    }
    public int[] toArray()
    {
        String out = root.printBranches();
        if(out == "")
            return null;
        String[] outArr = out.split(" ");
        int nodes = outArr.length;
        int[] array = new int[nodes];
        for(int i = 0; i < nodes; i++)
        {
            array[i] = Integer.parseInt(outArr[i]);
        }
        return array;
    }
}
