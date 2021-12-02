package com.example.traveldemo.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.traveldemo.R;
import com.example.traveldemo.databinding.FragmentGalleryBinding;
import com.example.traveldemo.databinding.FragmentSlideshowBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public static GalleryFragment newInstance() {
        
        Bundle args = new Bundle();
        
        GalleryFragment fragment = new GalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater,container,false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.getMenu().clear();
        return binding.getRoot();
    }


}