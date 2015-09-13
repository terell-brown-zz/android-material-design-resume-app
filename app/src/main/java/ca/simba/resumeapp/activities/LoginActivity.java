package ca.simba.resumeapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ca.simba.resumeapp.Constants;
import ca.simba.resumeapp.util.Credentials;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.api.ResumeApp;
import ca.simba.resumeapp.mypojo.CSRF;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends BaseActivity {

    // UI
    @Bind(R.id.etUsername)
    EditText etUsername;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.bLogin)
    Button bLogin;

    // Business Logic
    private String username;
    private String[] resumes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bLogin)
    public void tryLogin(View v) {
        username = etUsername.getText().toString();
        Credentials.save(activityContext, username, etPassword.getText().toString());
        ResumeApp.getAPI().login(username, etPassword.getText().toString(), new CSRFCallback(activityContext));
    }

    private void goToResumeListActivity() {
        Intent intent = new Intent(this, MyResumesActivity.class);
        intent.putExtra(Constants.USERNAME, username);
        intent.putExtra(Constants.RESUMES, resumes);
        startActivity(intent);
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
