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

    public static final String ENDPOINT="http://services.hanselandpetal.com";


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
                    LoginTask loginTask = new LoginTask();

                    //loginTask.execute(etPassword.getText().toString()); // sets isLogged = True if login is sucessful
                    //loginTask.get(10, TimeUnit.SECONDS);
                    login();
                } catch (Exception e) {
                    Toast.makeText(activityContext,e.getMessage(),Toast.LENGTH_SHORT).show();
                }

                if (isLoggedIn) {
                    goToResumeListActivity();
                }

        }
    }

    private void goToResumeListActivity() {
        Intent intent = new Intent(this, MyResumesActivity.class);
        intent.putExtra(Constants.USERNAME,username);
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
            Credentials.save(activityContext,username,etPassword.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        api.loginA(username, etPassword.getText().toString(), new CSRFCallback(activityContext));
        //Toast.makeText(activityContext, csrf.getKey(), Toast.LENGTH_LONG).show();
        //api.getResumes(authHeader, username.toString(), new UserCallback());

//        Toast.makeText(activityContext,"The username or password is incorrect. Please login again.",Toast.LENGTH_LONG).show();
//        etPassword.setText("");
        }



    public class CSRFCallback implements Callback<CSRF> {

        private Context context;

        public CSRFCallback(Context context) {
            this.context = context;
        }

        @Override
        public void success(CSRF csrf, Response response) {
            Credentials.get(context).key().put(csrf.getKey());
            Toast.makeText(activityContext, csrf.getKey(), Toast.LENGTH_SHORT).show();
            goToResumeListActivity();
        }

        @Override
        public void failure(RetrofitError error) {
            Toast.makeText(context, "Login failed. Please check your username and password." , Toast.LENGTH_LONG).show();
            Log.e("APICall", error.getMessage());
            etPassword.setText("");
        }
    }

    private class UserCallback implements Callback<User> {
        @Override
        public void success(User user, retrofit.client.Response response) {
            Toast.makeText(activityContext, "Welcome " + user.getUsername() + "!", Toast.LENGTH_LONG).show();
            List<String> resumeList = user.getResumes();
            resumes = resumeList.toArray(new String[resumeList.size()]);
        }

        @Override
        public void failure(RetrofitError error) {

        }
    }

    private class LoginTask extends AsyncTask<String, Void, String> {
        //ProgressDialog progressDialog = new ProgressDialog(activityContext);
        RestAdapter restAdapter;

        @Override
        protected void onPreExecute() {
            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Endpoints.HOST)
                    .build();

//            progressDialog.setMessage("Logging In");
//            progressDialog.setIndeterminate(true);
//            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String key;
            ResumeAPI methods = restAdapter.create(ResumeAPI.class);

            try {
                Log.e("API Check",params[0]);
                key = methods.login(username, "c4l1l1v1n").getKey();
                //Toast.makeText(activityContext, key, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                //Toast.makeText(activityContext,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
//            if (key != null) {
//                String authHeader = Credentials.getHeader(activityContext);
//                User user = methods.getUser(authHeader,username);
//                return user;
//            }

            return null;
        }

        @Override
        protected void onPostExecute(String key) {
            if (!(key == null)) {
                isLoggedIn = true;
                goToResumeListActivity();
            }
           //progressDialog.hide();
        }
    }
}
