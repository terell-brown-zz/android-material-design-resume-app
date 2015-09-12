package ca.simba.resumeapp.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.activities.Utils.DateTimeUtil;
import ca.simba.resumeapp.mypojo.Work;


public class WorkParentViewHolder extends ParentViewHolder {

    // Views
    @Bind(R.id.tvJobHeader)
    TextView tvJobHeader;
    @Bind(R.id.tvCompany) TextView tvCompany;
    @Bind(R.id.tvTimeSpan) TextView tvTimeSpan;
    private Context activityContext;


    public WorkParentViewHolder(Context c, View itemView) {
        super(itemView);
        activityContext = c;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Work Work) {

        tvJobHeader.setText(Work.getPosition());
        tvCompany.setText("@ " + Work.getOrganization());

        setJobTimeSpan(Work.getStartDate(), Work.getEndDate());
        //setupListView(itemView, Work.getExperiencePoints());
    }

    private void setJobTimeSpan(String startDate, String endDate) {
        tvTimeSpan.setText(DateTimeUtil.toMonthYearTextFormat(startDate) + " - " +
                DateTimeUtil.toMonthYearTextFormat(endDate));
    }
}
