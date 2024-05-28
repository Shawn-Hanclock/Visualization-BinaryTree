package com.example.visualization_binarytree;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class DataFragment extends Fragment {
    // instance variables
    private final BinaryTree appTree = MainActivity.appTree;
    private Button add, remove;
    private TextInputEditText editText;

    public DataFragment() {
        // Required empty public constructor
    }

    public static DataFragment newInstance() {
        return new DataFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // context
        View rootView = inflater.inflate(R.layout.fragment_data, container, false);

        // elements
        add = rootView.findViewById(R.id.addBtn);
        remove = rootView.findViewById(R.id.rmBtn);
        editText = rootView.findViewById(R.id.dataInputTxt);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                try {
                    int data = Integer.parseInt(str);
                    appTree.addData(data);
                }
                catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Tree only accepts integers.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        remove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    Node last = appTree.getRoot().findNext();
                    if(last.getParent() == null) {
                        appTree.setRoot(null);
                    }
                    else {
                        if (last.getRight() == null) {
                            last.setLeft(null);
                        }
                        else {
                            last.setRight(null);
                            // this does not always remove a node
                        }
                    }
                }
                catch (NullPointerException e) {
                    Toast.makeText(getActivity(), "Nothing to remove.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }
}