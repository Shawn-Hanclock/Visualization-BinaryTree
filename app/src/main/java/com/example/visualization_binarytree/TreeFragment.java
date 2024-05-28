package com.example.visualization_binarytree;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TreeFragment extends Fragment {
    // instance variables
    private static Button left;
    private static Button right;
    private static Button up;

    private final BinaryTree appTree = MainActivity.appTree;
    private Node currNode = appTree.getRoot();

    public TreeFragment() {
        // Required empty public constructor
    }

    public static TreeFragment newInstance() {
        return new TreeFragment();
    } //optional method
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // context
        View rootView = inflater.inflate(R.layout.fragment_tree, container, false);
        // elements
        currNode = appTree.getRoot();
        left = rootView.findViewById(R.id.leftBtn);
        right = rootView.findViewById(R.id.rightBtn);
        up  = rootView.findViewById(R.id.upBtn);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currNode = currNode.getLeft();
                hideShowReset(currNode, rootView);
            }
        });
        right.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currNode = currNode.getRight();
                hideShowReset(currNode, rootView);
            }
        });
        up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currNode = currNode.getParent();
                hideShowReset(currNode, rootView);
            }
        });
        hideShowReset(currNode, rootView);
        return rootView;
    }
    public static void hideShowReset(Node node, View v)
    {
        TextView currentNode = v.findViewById(R.id.nodeViewTv);
        TextView nodeData = v.findViewById(R.id.nodeDataTv);
        String label = node.getParent() == null ? "Root": node.isLeaf() ? "Leaf": "Branch";
        String data = node.getData() != null ? node.getData().toString(): "null";
        currentNode.setText(label);
        nodeData.setText(data);
        if(node.getLeft() == null) left.setVisibility(View.INVISIBLE);
        else left.setVisibility(View.VISIBLE);
        if(node.getRight() == null) right.setVisibility(View.INVISIBLE);
        else right.setVisibility(View.VISIBLE);
        if(node.getParent() == null) up.setVisibility(View.INVISIBLE);
        else up.setVisibility(View.VISIBLE);
    }
}