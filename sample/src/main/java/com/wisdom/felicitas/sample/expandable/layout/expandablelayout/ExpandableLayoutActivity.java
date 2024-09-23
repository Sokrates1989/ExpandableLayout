package com.wisdom.felicitas.sample.expandable.layout.expandablelayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wisdom.felicitas.expandable.layout.ExpandableRelativeLayout;
import com.wisdom.felicitas.sample.expandable.layout.R;

public class ExpandableLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, ExpandableLayoutActivity.class));
    }

    private Button mExpandButton;
    private Button mMoveChildButton;
    private Button mMoveChildButton2;
    private Button mMoveTopButton;
    private Button mSetCloseHeightButton;
    private ExpandableRelativeLayout mExpandLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_layout);

        getSupportActionBar().setTitle(ExpandableLayoutActivity.class.getSimpleName());

        mExpandButton = (Button) findViewById(R.id.expandButton);
        mMoveChildButton = (Button) findViewById(R.id.moveChildButton);
        mMoveChildButton2 = (Button) findViewById(R.id.moveChildButton2);
        mMoveTopButton = (Button) findViewById(R.id.moveTopButton);
        mSetCloseHeightButton = (Button) findViewById(R.id.setCloseHeightButton);
        mExpandLayout = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout);
        mExpandButton.setOnClickListener(this);
        mMoveChildButton.setOnClickListener(this);
        mMoveChildButton2.setOnClickListener(this);
        mMoveTopButton.setOnClickListener(this);
        mSetCloseHeightButton.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        int id = v.getId();
        if (id == R.id.expandButton) {
            mExpandLayout.toggle();
        } else if (id == R.id.moveChildButton) {
            mExpandLayout.moveChild(0);
        } else if (id == R.id.moveChildButton2) {
            mExpandLayout.moveChild(1);
        } else if (id == R.id.moveTopButton) {
            mExpandLayout.move(0);
        } else if (id == R.id.setCloseHeightButton) {
            mExpandLayout.setClosePosition(mExpandLayout.getCurrentPosition());
        }
    }
}
