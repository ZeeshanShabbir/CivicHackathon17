package io.markhorist.civichackathon.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import io.markhorist.civichackathon.R;
import io.markhorist.civichackathon.databinding.ActivityHomeBinding;
import io.markhorist.civichackathon.ui.fragments.MapFragment;
import io.markhorist.civichackathon.ui.fragments.SubjectsFragment;
import io.markhorist.civichackathon.ui.fragments.LocationFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    ActivityHomeBinding binding;

    public static final String STR_LOCATION = "locations";
    public static final String STR_SUBJECT = "subjects";
    public static final String STR_MAP = "map";
    private String lastSelectedFragment;

    private List<String> fragmentsTitle = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.idViewHeader.icHome.setOnClickListener(this);
        addContentToFrame("SUBJECTS", new SubjectsFragment());
        fragmentsTitle.add("SUBJECTS");
        lastSelectedFragment = STR_SUBJECT;

        View view = binding.navMenuView.getHeaderView(0);
        Button signinBtn = view.findViewById(R.id.btn_sign_in);
        Button signupBtn = view.findViewById(R.id.btn_sign_up);
        signinBtn.setOnClickListener(this);
        signupBtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void addContentToFrame(String title, Fragment fragment) {
        binding.idViewHeader.tvPageTitle.setText(title);
        if (fragment == null) return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.ic_home:
                hamBurgerMenuOpen();
                break;
            case R.id.btn_sign_in:
                startNewActivity(this,LoginActivity.class);
                break;
            case R.id.btn_sign_up:
                startNewActivity(this,SignUpActivity.class);
                break;
        }
    }

    public void hamBurgerMenuOpen() {
        if (binding.drawerLayout != null && binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String message) {
        switch (message) {
            case STR_LOCATION:
                binding.idViewHeader.tvPageTitle.setText("LOCATIONS");
                addFragment(STR_LOCATION, new LocationFragment());
                break;
            case STR_MAP:
                binding.idViewHeader.tvPageTitle.setText("MAP");
                addFragment(STR_LOCATION, new MapFragment());
                break;
        }
    }

    private void addFragment(String type, Fragment fragment) {
        if (fragment == null) return;
        lastSelectedFragment = type;
        fragmentsTitle.add(type.toUpperCase());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content_frame, fragment, type);
        transaction.addToBackStack(STR_LOCATION);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (fragmentsTitle.size() > 1) {
            fragmentsTitle.remove(fragmentsTitle.size() - 1);
            binding.idViewHeader.tvPageTitle.setText(fragmentsTitle.get(fragmentsTitle.size() - 1));
        }

        //String tag = getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size() - 1).getTag();
    }
}
