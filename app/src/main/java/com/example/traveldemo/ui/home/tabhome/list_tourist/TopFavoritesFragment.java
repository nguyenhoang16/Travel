package com.example.traveldemo.ui.home.tabhome.list_tourist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveldemo.MainActivity;
import com.example.traveldemo.R;
import com.example.traveldemo.databinding.FragmentTopFavoritesBinding;
import com.example.traveldemo.details.DetailsActivity;
import com.example.traveldemo.firebaseverify.VerifyPhoneNumberActivity;
import com.example.traveldemo.ui.home.tabhome.list_tourist.adapter.AdapterContactTopFavorites;
import com.example.traveldemo.ui.home.tabhome.list_tourist.adapter.ContactTopFavorites;
import com.example.traveldemo.ui.home.tabhome.list_tourist.adapter.IOnClick;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import www.sanju.zoomrecyclerlayout.ZoomRecyclerLayout;


public class TopFavoritesFragment extends Fragment implements IProductOfTouristList {
    FragmentTopFavoritesBinding binding;
    TouristListPresenter presenter;
    AdapterContactTopFavorites adapterContactTopFavorites;
    public static TopFavoritesFragment newInstance() {

        Bundle args = new Bundle();

        TopFavoritesFragment fragment = new TopFavoritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_favorites, container, false);
        binding.btnContinents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(), v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_continents, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getContext(),"No",Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        presenter = new TouristListPresenter(this);
        presenter.onShowListTourist();
        return binding.getRoot();
    }

    @Override
    public void onShowList(List<ContactTopFavorites> contactList) {
        adapterContactTopFavorites = new AdapterContactTopFavorites(contactList, getContext());

        ZoomRecyclerLayout zoomRecyclerLayout = new ZoomRecyclerLayout(getContext(), RecyclerView.HORIZONTAL, false);
        zoomRecyclerLayout.getOrientation();

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(binding.rcTourist);

        binding.rcTourist.setAdapter(adapterContactTopFavorites);
        binding.rcTourist.setLayoutManager(zoomRecyclerLayout);
        adapterContactTopFavorites.setIOnClick(new IOnClick() {
            @Override
            public void onBtnExplore(ContactTopFavorites contactTopFavorites) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("IdContact",contactTopFavorites.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        
    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_searchview, menu);
    }


}