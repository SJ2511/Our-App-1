package com.example.dell.intents;


        import android.app.FragmentTransaction;
        import android.content.Context;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by monikagarg on 6/24/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    CharSequence[] mTitles;

    public PagerAdapter(Context context, FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        mTitles = context.getResources().getStringArray(R.array.tabs_title);
    }


    @Override
    public Fragment getItem(int position) {
        /*android.app.FragmentManager fm= getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();*/

        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
            case 3:
                fragment = new Fragment4();
                break;
            default:
                fragment = new Fragment1();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}