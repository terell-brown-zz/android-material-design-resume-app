package ca.simba.resumeapp.activities.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.adapters.EducationListAdapter;
import ca.simba.resumeapp.adapters.SkillListAdapter;
import ca.simba.resumeapp.adapters.WorkListAdapter;
import ca.simba.resumeapp.mypojo.Education;
import ca.simba.resumeapp.mypojo.Skill;
import ca.simba.resumeapp.mypojo.Work;
import ca.simba.resumeapp.views.SimpleDividerItemDecoration;


public class Tabs {
    public static SkillFragment getSkillsTab(Context c, List<Skill> skills) {
        SkillFragment tab = new SkillFragment();
        tab.setContext(c);
        tab.setData(skills);
        return tab;
    }

    public static WorkFragment getWorkTab(Context c, List<Work> jobs) {
        WorkFragment tab = new WorkFragment();
        tab.setContext(c);
        tab.setData(jobs);
        return tab;
    }

    public static EducationFragment getEducationTab(Context c, List<Education> educationList) {
        EducationFragment tab = new EducationFragment();
        tab.setContext(c);
        tab.setData(educationList);
        return tab;
    }

public static class WorkFragment extends Fragment {

        // Backend
        private Context activityContext;

        RecyclerView rvWork;

        // Business Logic
        private List<Work> jobs;
        private View fragment;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_work, container, false);
            activityContext = container.getContext();
            fragment = view;
            setupRecyclerView(view);
            return view;
        }

        private void setupRecyclerView(View v) {
            rvWork = (RecyclerView) v.findViewById(R.id.rvWork);
            rvWork.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvWork.addItemDecoration(new SimpleDividerItemDecoration(activityContext));
            rvWork.setItemAnimator(new DefaultItemAnimator());
            WorkListAdapter adapter = new WorkListAdapter(jobs, activityContext);
            rvWork.setAdapter(adapter);
        }

        public void setData(List<Work> jobs) {
            this.jobs = jobs;
        }

        public void setContext(Context c) {
            this.activityContext = c;
        }
    }

    /**
    * Created by tmast_000 on 9/11/2015.
    */
    public static class SkillFragment extends Fragment {

        // Backend
        private Context activityContext;
        //@Bind(R.id.tvSkillName) Text tvSkillName;
        //@Bind(R.id.rvSkills)
        RecyclerView rvSkills;

        // Business Logic
        private List<Skill> skills;
        private View fragment;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_skills, container, false);
            activityContext = container.getContext();
            fragment = view;
            setupRecyclerView(view);
            return view;
        }

        private void setupRecyclerView(View v) {
            rvSkills = (RecyclerView) v.findViewById(R.id.rvSkills);
            rvSkills.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvSkills.addItemDecoration(new SimpleDividerItemDecoration(activityContext));
            rvSkills.setItemAnimator(new DefaultItemAnimator());
            SkillListAdapter adapter = new SkillListAdapter(skills, activityContext);
            rvSkills.setAdapter(adapter);
        }

        public void setData(List<Skill> skills) {
            this.skills = skills;
        }

        public void setContext(Context c) {
            activityContext = c;
        }
    }

    /**
    * Created by tmast_000 on 9/11/2015.
    */
    public static class EducationFragment extends Fragment {

        // Backend
        private Context activityContext;

        RecyclerView rvEducation;

        // Business Logic
        private List<Education> educationList;
        private View fragment;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_education, container, false);
            activityContext = container.getContext();
            fragment = view;
            setupRecyclerView(fragment);
            return view;
        }

        private void setupRecyclerView(View v) {
            rvEducation = (RecyclerView) v.findViewById(R.id.rvEducation);
            rvEducation.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvEducation.addItemDecoration(new SimpleDividerItemDecoration(activityContext));
            rvEducation.setItemAnimator(new DefaultItemAnimator());
            EducationListAdapter adapter = new EducationListAdapter(educationList, activityContext);
            rvEducation.setAdapter(adapter);
        }

        public void setData(List<Education> educationList) {
            this.educationList = educationList;
        }

        public void setContext(Context c) {
            this.activityContext = c;
        }
    }
}
