package ge.aleksandre.tskhovrebovi.finalproject.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.activities.HomeActivity;

public class CardsFragment extends Fragment {


    public static CardsFragment getInstance() {
        CardsFragment fragment = new CardsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cards, container, false);
        HomeActivity.setCorrespondingBackground(view);
        return view;
    }


}
