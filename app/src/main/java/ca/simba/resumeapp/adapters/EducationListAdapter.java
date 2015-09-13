package ca.simba.resumeapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.util.DateTimeUtil;
import ca.simba.resumeapp.mypojo.Education;

/**
 * Created by tmast_000 on 9/11/2015.
 */
public class EducationListAdapter extends RecyclerView.Adapter<EducationListAdapter.EducationViewHolder> {

    private List<Education> educationList;
    private Context activityContext;

    public EducationListAdapter(List<Education> educationList, Context activityContext) {
        this.educationList = educationList;
        this.activityContext = activityContext;
    }


    @Override
    public EducationListAdapter.EducationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_education, parent, false);
        return new EducationViewHolder(activityContext, v);
    }

    @Override
    public void onBindViewHolder(EducationViewHolder holder, int position) {
        holder.bind(educationList.get(position));
    }

    @Override
    public int getItemCount() {
        return educationList.size();
    }

    public class EducationViewHolder extends RecyclerView.ViewHolder {

        // Views
        @Bind(R.id.tvProgram) TextView tvProgram;
        @Bind(R.id.tvSchool) TextView tvSchool;
        @Bind(R.id.tvTimeSpan) TextView tvTimeSpan;
        private final Context activityContext;


        public EducationViewHolder(Context c, View itemView) {
            super(itemView);
            activityContext = c;
            ButterKnife.bind(this, itemView);
        }


        public void bind(Education education) {
            tvProgram.setText(education.getDegreeType() + ", " + education.getProgram());
            tvSchool.setText(education.getSchool());
            setJobTimeSpan(education.getStartDate(),education.getEndDate());
        }

        private void setJobTimeSpan(String startDate, String endDate) {
            tvTimeSpan.setText(DateTimeUtil.toMonthYearTextFormat(startDate) + " - " +
                    DateTimeUtil.toMonthYearTextFormat(endDate));
        }
    }
}
