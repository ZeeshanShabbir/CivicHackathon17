package io.markhorist.civichackathon.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import io.markhorist.civichackathon.R;
import io.markhorist.civichackathon.databinding.FragmentLocationBinding;
import io.markhorist.civichackathon.ui.activities.HomeActivity;

/**
 * Created by Zeeshan Shabbir on 8/19/2017.
 */

public class LocationFragment extends Fragment implements View.OnClickListener {
    FragmentLocationBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_location, container, false);
        binding.tvIslamabad.setOnClickListener(this);
        binding.tvRawalpindi.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.tv_islamabad:
                EventBus.getDefault().post(HomeActivity.STR_MAP);
                break;
            case R.id.tv_rawalpindi:
                EventBus.getDefault().post(HomeActivity.STR_MAP);
                break;
        }
    }
}
