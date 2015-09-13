package ca.simba.resumeapp.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import ca.simba.resumeapp.R;
import ca.simba.resumeapp.mypojo.childclasses.WorkChild;

/**
 * Created by tmast_000 on 9/12/2015.
 */
public class WorkChildViewHolder extends ChildViewHolder {

    private final Context activityContext;
    @Bind(R.id.tvExperience) TextView tvExperience;
    @Bind(R.id.tvSkills) TextView tvSkills;

    public WorkChildViewHolder(Context c, View itemView) {
        super(itemView);
        activityContext = c;
        ButterKnife.bind(this,itemView);
    }


    public void bind(WorkChild workChild) {
        tvExperience.setText(workChild.getExperience());
        tvSkills.setText(workChild.getSkills());
    }
}
