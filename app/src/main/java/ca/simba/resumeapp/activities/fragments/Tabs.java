package ca.simba.resumeapp.activities.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.adapters.EducationListAdapter;
import ca.simba.resumeapp.adapters.SkillListAdapter;
import ca.simba.resumeapp.adapters.WorkExpandableAdapter;
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
        tab.setData(castToParentObject(jobs));
        return tab;
    }

    private static List<ParentObject> castToParentObject(List<Work> jobs) {
        // Work object must be of type ParentObject to be used in ExpandableRecyclerView Library

        List<ParentObject> list = new ArrayList<ParentObject>();

        for (Work work : jobs) {
            list.add((ParentObject) work);
        }
        return list;
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
        private RecyclerView rvWork;

        // Business Logic
        private List<ParentObject> jobs;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_work, container, false);
            activityContext = container.getContext();
            setupRecyclerView(view);
            return view;
        }

        private void setupRecyclerView(View v) {
            rvWork = (RecyclerView) v.findViewById(R.id.rvWork);
            rvWork.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvWork.addItemDecoration(new SimpleDividerItemDecoration(activityContext));
            rvWork.setItemAnimator(new DefaultItemAnimator());

            // Special RecyclerView Adapter
            WorkExpandableAdapter adapter = new WorkExpandableAdapter(activityContext, jobs);
            adapter.setParentClickableViewAnimationDefaultDuration();
            adapter.setParentAndIconExpandOnClick(true);
            rvWork.setAdapter(adapter);
        }

        public void setData(List<ParentObject> jobs) {
            this.jobs = jobs;
        }

        public void setContext(Context c) {
            this.activityContext = c;
        }
    }

    public static class SkillFragment extends Fragment {

        // Backend
        private Context activityContext;

        // UI
        RecyclerView rvSkills;

        // Business Logic
        private List<Skill> skills;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_skills, container, false);
            activityContext = container.getContext();
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

    public static class EducationFragment extends Fragment {

        // Backend
        private Context activityContext;

        // UI
        RecyclerView rvEducation;

        // Business Logic
        private List<Education> educationList;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_education, container, false);
            activityContext = container.getContext();
            setupRecyclerView(view);
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
