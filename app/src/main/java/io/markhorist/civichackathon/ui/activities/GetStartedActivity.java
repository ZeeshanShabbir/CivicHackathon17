package io.markhorist.civichackathon.ui.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;

import io.markhorist.civichackathon.R;
import io.markhorist.civichackathon.databinding.ActivityGetStartedBinding;

public class GetStartedActivity extends BaseActivity {

    ActivityGetStartedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_get_started);
        binding.btnStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivityAndClear(GetStartedActivity.this, HomeActivity.class);
            }
        });
    }
}
