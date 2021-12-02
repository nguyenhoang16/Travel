package com.example.traveldemo.ui.home.tabhome.list_tourist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.traveldemo.R;
import com.example.traveldemo.databinding.ItemTopFavoritesBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterContactTopFavorites extends RecyclerView.Adapter<AdapterContactTopFavorites.ViewHoder> {
    List<ContactTopFavorites> contacts;
    Context context;
    IOnClick iOnClick;

    public void setIOnClick(IOnClick iOnClick) {
        this.iOnClick = iOnClick;
    }

    public AdapterContactTopFavorites() {
    }

    public AdapterContactTopFavorites(List<ContactTopFavorites> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public AdapterContactTopFavorites.ViewHoder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        ItemTopFavoritesBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_top_favorites,parent,false);
        ViewHoder viewHoder = new ViewHoder(binding);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterContactTopFavorites.ViewHoder holder, int position) {
        ContactTopFavorites contact = contacts.get(position);
        holder.binding.nationality.setText(contact.getName());
        holder.binding.map.setImageResource(R.drawable.ic_launcher_background);
        Glide.with(context).load(contact.getMap()).into(holder.binding.map);
        holder.binding.famousPlace.setImageResource(R.drawable.ic_launcher_background);
        Glide.with(context).load(contact.getFamousPlace()).into(holder.binding.famousPlace);
        holder.binding.placeName.setText(contact.getPlaceName());
        holder.binding.btnExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClick.onBtnExplore(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        ItemTopFavoritesBinding binding;
        public ViewHoder(@NonNull @NotNull ItemTopFavoritesBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
