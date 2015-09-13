package ca.simba.resumeapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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

/**
 * Created by tmast_000 on 9/11/2015.
 */
public class ResumesListAdapter extends RecyclerView.Adapter<ResumesListAdapter.ResumeViewHolder> {

    private List<String> resumes;
    private Context activityContext;

    public ResumesListAdapter(List<String> resumes, Context activityContext) {
        this.resumes = resumes;
        this.activityContext = activityContext;
    }


    @Override
    public ResumeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_resume, parent, false);
        return new ResumeViewHolder(activityContext,v);
    }

    @Override
    public void onBindViewHolder(ResumeViewHolder holder, int position) {
        holder.bind(resumes.get(position));
    }

    @Override
    public int getItemCount() {
        return resumes.size();
    }

    public class ResumeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.viewHolder) LinearLayout viewHolder;
        @Bind(R.id.tvResumeName) TextView tvResumeName;

        private final Context activityContext;
        private String resumeName;

        public ResumeViewHolder(Context c, View itemView) {
            super(itemView);
            activityContext = c;
            ButterKnife.bind(itemView);
            itemView.setOnClickListener(this);

            tvResumeName = (TextView) itemView.findViewById(R.id.tvResumeName);
        }


        public void bind(String resumeName) {
            this.resumeName = resumeName;
            tvResumeName.setText(resumeName);
        }


        public void showResume() {
            Intent intent = new Intent(activityContext, ResumeDetailsActivity.class);
            intent.putExtra(Constants.RESUMES, resumeName);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activityContext.startActivity(intent);

        }

        @Override
        public void onClick(View v) {
            showResume();
        }
    }

}
