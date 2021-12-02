package com.example.traveldemo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.traveldemo.R;
import com.example.traveldemo.databinding.FragmentHomeBinding;
import com.example.traveldemo.ui.home.tabhome.LocatiFragment;
import com.example.traveldemo.ui.home.tabhome.MapsFragment;
import com.example.traveldemo.ui.home.tabhome.list_tourist.TopFavoritesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;
    private FragmentHomeBinding binding;

    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        initUi();
        getFragment(TopFavoritesFragment.newInstance());
        return binding.getRoot();
    }

    private void getFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.containerHome, fragment).commit();
    }

    private void initUi() {
        bottomNavigationView = binding.bottomNavigation;
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab_topFavorites:
                        getFragment(TopFavoritesFragment.newInstance());
                        break;
                    case R.id.tab_map:
                        getFragment(MapsFragment.newInstance());
                        break;
                    case R.id.tab_locati:
                        getFragment(LocatiFragment.newInstance());
                        break;
                }
                return true;
            }
        });
    }

}
