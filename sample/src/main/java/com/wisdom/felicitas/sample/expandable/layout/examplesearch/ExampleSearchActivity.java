package com.wisdom.felicitas.sample.expandable.layout.examplesearch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.wisdom.felicitas.expandable.layout.ExpandableRelativeLayout;
import com.wisdom.felicitas.sample.expandable.layout.R;
import com.wisdom.felicitas.sample.expandable.layout.util.DividerItemDecoration;

import java.util.ArrayList;


public class ExampleSearchActivity extends AppCompatActivity implements View.OnClickListener {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, ExampleSearchActivity.class));
    }

    private Button mExpandButton;
    private ExpandableRelativeLayout mExpandLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_search);

        getSupportActionBar().setTitle(ExampleSearchActivity.class.getSimpleName());

        mExpandButton = (Button) findViewById(R.id.expandButton);
        mExpandLayout = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout);
        mExpandButton.setOnClickListener(this);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList data = new ArrayList();
        for(int i = 0; i < 15; i++) {
            data.add("Result");
        }
        recyclerView.setAdapter(new ExampleSearchRecyclerAdapter(data));
    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.expandButton) {
            mExpandLayout.expand();
        }
    }
}
