package ca.simba.resumeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ca.simba.resumeapp.Constants;
import ca.simba.resumeapp.Credentials;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.ResumeApp;
import ca.simba.resumeapp.activities.fragments.Tabs;
import ca.simba.resumeapp.activities.fragments.Tabs.SkillFragment;
import ca.simba.resumeapp.activities.fragments.Tabs.WorkFragment;
import ca.simba.resumeapp.activities.fragments.Tabs.EducationFragment;
import ca.simba.resumeapp.adapters.ViewPagerAdapter;
import ca.simba.resumeapp.mypojo.Education;
import ca.simba.resumeapp.mypojo.Resume;
import ca.simba.resumeapp.mypojo.Skill;
import ca.simba.resumeapp.mypojo.Work;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by tmast_000 on 9/11/2015.
 */
public class ResumeDetailsActivity extends BaseActivity implements TabLayout.OnTabSelectedListener{

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tab_bar)
    TabLayout tabBar;
    private String resumeName;
    private SkillFragment skillTab;
    private List<Skill> skills;
    public List<Work> jobs;
    private WorkFragment workTab;
    public List<Education> educationList;
    private EducationFragment educationTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_details);
        ButterKnife.bind(this);

        handleIntent(getIntent());
        setupToolbar(resumeName);
        getResumeDetails();

    }


    public void setupToolbar(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(resumeName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resume_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void handleIntent(Intent intent) {
        resumeName = intent.getStringExtra(Constants.RESUMES);
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        createTabFragments();
        adapter.addFrag(workTab, Constants.TITLE_WORK);
        adapter.addFrag(skillTab, Constants.TITLE_SKILLS);
        adapter.addFrag(educationTab, Constants.TITLE_EDUCATION);
        viewPager.setAdapter(adapter);
    }

    private void createTabFragments() {
        skillTab = Tabs.getSkillsTab(activityContext, skills);
        workTab = Tabs.getWorkTab(activityContext, jobs);
        educationTab = Tabs.getEducationTab(activityContext, educationList);
    }

    public void getResumeDetails() {
        ResumeApp.getAPI().getResume(Credentials.getHeader(activityContext),
                resumeName,
                new Callback<List<Resume>>() {


                    @Override
                    public void success(List<Resume> resumes, Response response) {
                        Resume resume = resumes.get(0);
                        skills = resume.getSkill();
                        jobs = resume.getWork();
                        educationList = resume.getEducation();
                        setupViewPager();
                        tabBar.setupWithViewPager(viewPager);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(activityContext,error.getMessage(),Toast.LENGTH_SHORT).show();
                        Log.e("Auth", error.getMessage());
                    }
                });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        switch (tab.getPosition()) {
            case 0:

                break;
            case 1:

                break;
            case 2:
                educationTab.setData(educationList);
                break;

        }
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
