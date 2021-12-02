package com.example.traveldemo.ui.home.tabhome.list_tourist;

import android.content.Context;
import android.widget.Toast;

import com.example.traveldemo.api.ApiService;
import com.example.traveldemo.ui.home.tabhome.list_tourist.adapter.ContactTopFavorites;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TouristListPresenter {
    IProductOfTouristList iProductOfTouristList;
    Context context;
    List<ContactTopFavorites> contacts = new ArrayList<>();
    public TouristListPresenter(IProductOfTouristList iProductOfTouristList) {
        this.iProductOfTouristList = iProductOfTouristList;
    }

    public void onShowListTourist() {
        ApiService.apiService.getList().enqueue(new Callback<List<ContactTopFavorites>>() {
            @Override
            public void onResponse(Call<List<ContactTopFavorites>> call, Response<List<ContactTopFavorites>> response) {
                insertContact(response.body());
                iProductOfTouristList.onShowList(contacts);

            }

            @Override
            public void onFailure(Call<List<ContactTopFavorites>> call, Throwable t) {
                Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void insertContact(List<ContactTopFavorites> listAPI){
        for(ContactTopFavorites contact : listAPI){
            contacts.add(contact);
        }
    }
}
