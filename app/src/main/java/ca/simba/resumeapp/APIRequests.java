package ca.simba.resumeapp;

import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by tmast_000 on 8/30/2015.
 */
public class APIRequests extends AsyncTask<Context, String,String> {

    final HttpClient httpClient = new DefaultHttpClient();
    String content;
    String error;
    //ProgressDialog progressDialog = new ProgressDialog();
    String data;

    protected Object doInBackground(String username, String password) {

        return null;
    }


    @Override
    protected String doInBackground(Context... params) {
        return null;
    }
}
