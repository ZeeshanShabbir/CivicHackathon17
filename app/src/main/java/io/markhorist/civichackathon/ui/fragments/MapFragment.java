package io.markhorist.civichackathon.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.markhorist.civichackathon.R;
import io.markhorist.civichackathon.databinding.FragmentMapBinding;

/**
 * Created by Zeeshan Shabbir on 8/19/2017.
 */

public class MapFragment extends Fragment {
    FragmentMapBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false);
        return binding.getRoot();
    }
}
