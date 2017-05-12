package com.kc.butterknifedroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    private final static String TAG = ResultActivity.class.getSimpleName();

    @BindView(R.id.yourNameTextView)
    TextView mYourNameTextView;

    @BindView(R.id.yourEmailTextView)
    TextView mYourEmailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String firstName = getIntent().getStringExtra(MainActivity.FIRST_NAME);
        String lastName = getIntent().getStringExtra(MainActivity.LAST_NAME);
        String email = getIntent().getStringExtra(MainActivity.EMAIL);
        ButterKnife.bind(this);
        mYourNameTextView.setText("Your Name: " + firstName);
        mYourEmailTextView.setText("Your Email: " + email);
    }

}
