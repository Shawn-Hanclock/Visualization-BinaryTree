package com.example.visualization_binarytree;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TreeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // instance variables
    private static Button left;
    private static Button right;
    private static Button up;

    private final BinaryTree appTree = MainActivity.appTree;
    private  Node currNode = appTree.getRoot();

    public TreeFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment TreeFragment.
//     */
//    // TODO: Rename and change types and number of parameters
    public static TreeFragment newInstance(String param1, String param2) {
        TreeFragment fragment = new TreeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // context
        View rootView = inflater.inflate(R.layout.fragment_tree, container, false);
        // elements
        left = rootView.findViewById(R.id.leftBtn);
        right = rootView.findViewById(R.id.rightBtn);
        up  = rootView.findViewById(R.id.upBtn);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currNode = currNode.getLeft();
            }
        });
        right.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currNode = currNode.getRight();
            }
        });
        up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currNode = currNode.getParent();
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
        String data = node.getData().toString();
        currentNode.setText(label);
        nodeData.setText(data);
        if(node.getLeft() == null) left.setVisibility(View.INVISIBLE);
        if(node.getRight() == null) right.setVisibility(View.INVISIBLE);
        if(node.getParent() == null) up.setVisibility(View.INVISIBLE);
    }
}