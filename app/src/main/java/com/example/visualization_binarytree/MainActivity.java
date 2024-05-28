package com.example.visualization_binarytree;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    public Node currentNode;

    public static BinaryTree appTree = new BinaryTree();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        //about fragment button
        Button btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //used to switch between fragments
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, AboutFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("about")
                        .commit();
            }
        });

        //data fragment button
        Button btnData = findViewById(R.id.btnData);
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //used to switch between fragments
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, DataFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("data")
                        .commit();
            }
        });

        //tree fragment button
        Button btnTree = findViewById(R.id.btnTree);
        btnTree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //used to switch between fragments
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, TreeFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("tree")
                        .commit();
            }
        });
        currentNode = appTree.getRoot();
    }
    public Node getCurrentNode(){
        return currentNode;
    }
}