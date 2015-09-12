package ca.simba.resumeapp;


import ca.simba.resumeapp.api.Endpoints;
import ca.simba.resumeapp.api.ResumeAPI;
import ca.simba.resumeapp.mypojo.Resume;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ResumeApp {

    private static ResumeAPI api;

    public static  ResumeAPI getAPI() {
        if (api == null) {
            RestAdapter retrofit = new RestAdapter.Builder()
                    .setEndpoint(Endpoints.HOST)
                    .build();
            api = retrofit.create(ResumeAPI.class);
        }

        return api;
    }
}
