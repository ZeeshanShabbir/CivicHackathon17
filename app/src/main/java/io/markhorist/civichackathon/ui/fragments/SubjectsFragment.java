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
import io.markhorist.civichackathon.databinding.FragmentHomeBinding;
import io.markhorist.civichackathon.ui.activities.HomeActivity;

/**
 * Created by Zeeshan Shabbir on 8/19/2017.
 */

public class SubjectsFragment extends Fragment implements View.OnClickListener {
    FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.btnEnglish.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        binding.btn4.setOnClickListener(this);
        binding.btn5.setOnClickListener(this);
        binding.btn6.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_english:
                EventBus.getDefault().post(HomeActivity.STR_LOCATION);
                break;
            default:
                EventBus.getDefault().post(HomeActivity.STR_LOCATION);
                break;
        }
    }
}
