package com.kc.butterknifedroid;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    public final static String FIRST_NAME = "FIRST_NAME";
    public final static String LAST_NAME = "LAST_NAME";
    public final static String EMAIL = "EMAIL";

    Unbinder mUnbinder;

    @BindView(R.id.firstNameTextInputLayout)
    TextInputLayout mFirstNameTextInputLayout;

    @BindView(R.id.lastNameTextInputLayout)
    TextInputLayout mLastNameTextInputLayout;

    @BindView(R.id.emailTextInputLayout)
    TextInputLayout mEmailTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @OnClick(R.id.signupButton)
    protected void register() {
        extractDataAndSendToResultActivity();
    }

    private void extractDataAndSendToResultActivity() {
        String firstName = mFirstNameTextInputLayout.getEditText().getText().toString();
        String lastName = mLastNameTextInputLayout.getEditText().getText().toString();
        String email = mEmailTextInputLayout.getEditText().getText().toString();
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra(FIRST_NAME, firstName);
        intent.putExtra(LAST_NAME, lastName);
        intent.putExtra(EMAIL, email);
        startActivity(intent);
        finish();

    }
}
