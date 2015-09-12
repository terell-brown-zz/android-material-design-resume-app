package ca.simba.resumeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ca.simba.resumeapp.Constants;
import ca.simba.resumeapp.Credentials;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.ResumeApp;
import ca.simba.resumeapp.adapters.ResumesListAdapter;
import ca.simba.resumeapp.mypojo.User;
import ca.simba.resumeapp.views.SimpleDividerItemDecoration;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MyResumesActivity extends BaseActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    private String username = "";
    //private RecyclerView mRecyclerView;
    private List<String> resumes;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_resumes);
        ButterKnife.bind(this);
        getResumeInfo();
        setToolbar();
        setUpRecyclerView();
        //ListView lv = (ListView) findViewById(R.id.lvResumes);
        //ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resumes);
        //lv.setAdapter(adapter);
    }

    private void getResumeInfo() {
        Intent intent = getIntent();
        username = intent.getStringExtra(Constants.USERNAME);
        ResumeApp.getAPI().getUser(Credentials.getHeader(activityContext), username, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                resumes = user.getResumes();
                ResumesListAdapter adapter = new ResumesListAdapter(resumes, activityContext);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(activityContext,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setUpRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rvResumes);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(activityContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setToolbar() {
        toolbar.setTitle(username + "'s Resumes");
    }

}
