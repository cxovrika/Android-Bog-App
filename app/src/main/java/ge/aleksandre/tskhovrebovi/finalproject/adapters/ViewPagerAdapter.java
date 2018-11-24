package ge.aleksandre.tskhovrebovi.finalproject.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ge.aleksandre.tskhovrebovi.finalproject.fragments.ActivesFragment;
import ge.aleksandre.tskhovrebovi.finalproject.fragments.CardsFragment;
import ge.aleksandre.tskhovrebovi.finalproject.fragments.ProfileFragment;
import ge.aleksandre.tskhovrebovi.finalproject.fragments.TransactionsFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = new String[]{"პროფილი", "აქტივები", "გადახდების ისტორია", "ბარათები"};

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return ProfileFragment.getInstance();
        } else if (i == 1){
            return ActivesFragment.getInstance();
        } else if (i == 2) {
            return TransactionsFragment.getInstance();
        } else if (i == 3) {
            return CardsFragment.getInstance();
        } else {
            return CardsFragment.getInstance();
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
}
