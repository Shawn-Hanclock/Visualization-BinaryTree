package com.example.visualization_binarytree;

public class Node
{
    // instance variables
    private Integer data;
    private Node left;
    private Node right;
    private Node parent;

    // constructors
    public Node(int data) //used to create root
    {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }
    public Node(int data, Node parent) //used to create new nodes
    {
        this.data = data;
        left = null;
        right = null;
        this.parent = parent;
    }
    public Node() //used to create empty root
    {
        data = null;
        left = null;
        right = null;
        parent = null;
    }

    // getters and setters
    public void setData(int data)
    {
        this.data = data;
    }
    public Integer getData() //try catch to avoid NullPointerException
    {
        try {
            return data;
        }
        catch(NullPointerException e) {
            return null;
        }
    }
    public Node getRight() {
        return right;
    }
    public Node getLeft() {
        return left;
    }
    public Node getParent()
    {
        return parent;
    }
    public void setLeft(Node left)
    {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }

// [LEFT UNREMOVED JUST IN CASE]
//    public void setParent(int data)
//    {
//        parent.setData(data);
//    }

    // brain methods
    public int findHeight() //finds the distance to root node
    {
        int count = 0;
        Node check = this;
        while(check.getParent() != null)
        {
            count++;
            check = check.getParent();
        }
        return count;
    }
    //    [RECURSIVE VERSION of findHeight()]
//    public int findHeight() //finds the distance to root node, recursively
//    {
//        if(parent == null) return 0;
//        return 1 + parent.findHeight();
//    }
    public Node findNext() //finds the left most node, will keep it as a complete binary tree
    {
        if(right != null && left != null)
        {
            Node sub1 = left.findNext();
            Node sub2 = right.findNext();
            if(sub1.findHeight() > sub2.findHeight())
            {
                if(sub1.parent.right == null) return sub1;
                return sub2;
            }
            else if(sub1.findHeight() < sub2.findHeight())
            {
                if(sub2.parent.right == null) return sub2;
                return sub1;
            }
            else return sub1;
        }
        else return this;
    }
    public void addNew(int addData)
    {
        Node addLeaf = this.findNext();
        if(addLeaf.left != null) addLeaf.right = new Node(addData, addLeaf);
        else addLeaf.left = new Node(addData, addLeaf);
    }
    public boolean isLeaf() //leafs will have two empty child references
    {
        return left == null && right == null;
    }
    public int leafCount() //1 leaf or 2 leaf or 0 leaf
    {
        int count = 0;
        if(this.isLeaf()) return 1;
        if(left != null) count += left.leafCount();
        if(right != null) count += right.leafCount();
        return count;
    }
    public String printBranches() //print the branches with inorder traversal
    {
        if(data == null) return "";
        String output = data + " ";
        if(left != null) output = left.printBranches() + output;
        if(right != null) output = output + right.printBranches();
        return output;
    }
}
