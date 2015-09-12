package ca.simba.resumeapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


import ca.simba.resumeapp.Constants;
import ca.simba.resumeapp.Credentials;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.api.Endpoints;
import ca.simba.resumeapp.api.ResumeAPI;
import ca.simba.resumeapp.mypojo.CSRF;
import ca.simba.resumeapp.mypojo.User;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    // UI
    public EditText etUsername, etPassword;
    private Button bLogin, bSignUp;

    // Business Logic
    private String username;
    String[] resumes;
    boolean loggedIn;
    boolean isLoggedIn;

    public static final String ENDPOINT = "http://services.hanselandpetal.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupWidgets();
        isLoggedIn = false;
    }

    private void setupWidgets() {
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogin:
                username = etUsername.getText().toString();
                try {
                    Credentials.save(activityContext, username, etPassword.getText().toString());
                    login();
                } catch (Exception e) {
                    Toast.makeText(activityContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                if (isLoggedIn) {
                    goToResumeListActivity();
                }

        }
    }

    private void goToResumeListActivity() {
        Intent intent = new Intent(this, MyResumesActivity.class);
        intent.putExtra(Constants.USERNAME, username);
        intent.putExtra(Constants.RESUMES, resumes);
        startActivity(intent);
    }


    private void login() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Endpoints.HOST)
                .build();

        // create an instance of the interface
        ResumeAPI api = adapter.create(ResumeAPI.class); //This is the class that defines my rest service
        String authHeader = Credentials.getHeader(activityContext);
        Log.e("check", "" + Credentials.getHeader(activityContext).equals(authHeader));

        Log.e("Auth", authHeader);
        try {
            Credentials.save(activityContext, username, etPassword.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        api.login(username, etPassword.getText().toString(), new CSRFCallback(activityContext));
    }


    public class CSRFCallback implements Callback<CSRF> {

        private Context context;

        public CSRFCallback(Context context) {
            this.context = context;
        }

        @Override
        public void success(CSRF csrf, Response response) {
            Credentials.get(context).key().put(csrf.getKey());
            goToResumeListActivity();
        }

        @Override
        public void failure(RetrofitError error) {
            Toast.makeText(context, "Login failed. Please check your username and password.", Toast.LENGTH_LONG).show();
            Log.e("APICall", error.getMessage());
            etPassword.setText("");
        }
    }

}
