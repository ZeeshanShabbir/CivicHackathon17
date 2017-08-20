package io.markhorist.civichackathon.ui.activities;

import android.os.Bundle;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startNewActivityAndClear(this, GetStartedActivity.class);
    }
}
