package ca.simba.resumeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import ca.simba.resumeapp.R;
import ca.simba.resumeapp.mypojo.Work;
import ca.simba.resumeapp.mypojo.childclasses.WorkChild;
import ca.simba.resumeapp.viewholders.WorkChildViewHolder;
import ca.simba.resumeapp.viewholders.WorkParentViewHolder;


public class WorkExpandableAdapter extends ExpandableRecyclerAdapter<WorkParentViewHolder, WorkChildViewHolder> {

    private final LayoutInflater mInflater;

    public WorkExpandableAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public WorkParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.viewholder_work_parent, viewGroup, false);
        return new WorkParentViewHolder(mContext,view);
    }

    @Override
    public WorkChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.viewholder_work_child, viewGroup, false);
        return new WorkChildViewHolder(mContext,view);
    }

    @Override
    public void onBindParentViewHolder(WorkParentViewHolder workParentViewHolder, int i, Object o) {
        Work work = (Work) o;
        workParentViewHolder.bind(work);
    }

    @Override
    public void onBindChildViewHolder(WorkChildViewHolder workChildViewHolder, int i, Object o) {
        WorkChild workChild = (WorkChild) o;
        workChildViewHolder.bind(workChild);
    }
}
