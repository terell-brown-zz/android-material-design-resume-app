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

/**
 * Created by tmast_000 on 9/11/2015.
 */
public class SkillListAdapter extends RecyclerView.Adapter<SkillListAdapter.SkillViewHolder> {

    private List<Skill> skills;
    private Context activityContext;

    public SkillListAdapter(List<Skill> skills, Context activityContext) {
        this.skills = skills;
        this.activityContext = activityContext;
    }


    @Override
    public SkillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_skills, parent, false);
        return new SkillViewHolder(activityContext, v);
    }

    @Override
    public void onBindViewHolder(SkillViewHolder holder, int position) {
        holder.bind(skills.get(position));
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }

    public class SkillViewHolder extends RecyclerView.ViewHolder {

        // Views
        @Bind(R.id.tvSkillName)
        TextView tvSkillName;

        private final Context activityContext;


        public SkillViewHolder(Context c, View itemView) {
            super(itemView);
            activityContext = c;
            ButterKnife.bind(this,itemView);
        }


        public void bind(Skill skill) {
            tvSkillName.setText(skill.getName());
        }
    }
}
