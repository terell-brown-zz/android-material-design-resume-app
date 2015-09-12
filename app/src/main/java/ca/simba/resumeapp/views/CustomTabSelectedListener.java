package ca.simba.resumeapp.views;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

/**
 * Created by tmast_000 on 9/11/2015.
 */
public class CustomTabSelectedListener implements TabLayout.OnTabSelectedListener {

    private ViewPager viewPager;

    public CustomTabSelectedListener(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        switch (tab.getPosition()) {
            case 0:

                break;
            case 1:

                break;
            case 2:
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
