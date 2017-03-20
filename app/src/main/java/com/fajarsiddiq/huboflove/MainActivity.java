package com.fajarsiddiq.huboflove;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends BaseActivity {

    private OnTabSelectListener mOnTabSelectListener
            = new OnTabSelectListener() {

        @Override
        public void onTabSelected(@IdRes int tabId) {
            selectTab(tabId);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar navigation = (BottomBar) findViewById(R.id.bottomBar);
        navigation.setOnTabSelectListener(mOnTabSelectListener);
        navigation.selectTabWithId(R.id.navigation_home);
    }

    private void selectTab(int tabId) {
        BaseFragment fragment;
        switch (tabId) {
            case R.id.navigation_home:
                fragment = HomeFragment.newInstance();
                break;
            case R.id.navigation_notes:
                fragment = NotesFragment.newInstance();
                break;
            case R.id.navigation_planner:
                fragment = PlannerFragment.newInstance();
                break;
            case R.id.navigation_timeline:
                fragment = TimelineFragment.newInstance();
                break;
            case R.id.navigation_wishlist:
                fragment = WishlistFragment.newInstance();
                break;
            default:
                fragment = null;
        }

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment, fragment.getFragmentTag());
            fragmentTransaction.commit();
        }
    }

}
