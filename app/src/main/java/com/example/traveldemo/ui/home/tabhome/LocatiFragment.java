package com.example.traveldemo.ui.home.tabhome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.traveldemo.R;
import com.example.traveldemo.databinding.FragmentGalleryBinding;

public class LocatiFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public static LocatiFragment newInstance() {
        
        Bundle args = new Bundle();
        
        LocatiFragment fragment = new LocatiFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_locati,container,false);
    }

}