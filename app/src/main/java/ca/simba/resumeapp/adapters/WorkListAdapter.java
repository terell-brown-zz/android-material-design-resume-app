package ca.simba.resumeapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ca.simba.resumeapp.Constants;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.activities.ResumeDetailsActivity;
import ca.simba.resumeapp.mypojo.Skill;
import ca.simba.resumeapp.mypojo.Work;

/**
 * Created by tmast_000 on 9/11/2015.
 */
public class WorkListAdapter extends RecyclerView.Adapter<WorkListAdapter.WorkViewHolder> {

    private List<Work> jobs;
    private Context activityContext;

    public WorkListAdapter(List<Work> jobs, Context activityContext) {
        this.jobs = jobs;
        this.activityContext = activityContext;
    }


    @Override
    public WorkListAdapter.WorkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_work, parent, false);
        return new WorkViewHolder(activityContext, v);
    }

    @Override
    public void onBindViewHolder(WorkViewHolder holder, int position) {
        holder.bind(jobs.get(position));
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class WorkViewHolder extends RecyclerView.ViewHolder {

        // Views
        @Bind(R.id.tvJobHeader) TextView tvJobHeader;

        private final Context activityContext;


        public WorkViewHolder(Context c, View itemView) {
            super(itemView);
            activityContext = c;
            ButterKnife.bind(this,itemView);
        }


        public void bind(Work Work) {
            tvJobHeader.setText(Work.getPosition() + " @ " + Work.getOrganization());
        }
    }
}
