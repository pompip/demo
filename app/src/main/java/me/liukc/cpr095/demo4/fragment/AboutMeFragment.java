package me.liukc.cpr095.demo4.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import me.liukc.cpr095.demo4.R;

/**
 * Author:刘科冲
 * Date:2015-07-23
 * FIXME
 * Todo
 */
public class AboutMeFragment extends Fragment {

        RatingBar ratingBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_aboutme,container,false);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        ratingBar.setClickable(false);
        ratingBar.clearFocus();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ratingBar.setIsIndicator(true);
    }
}
