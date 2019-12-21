package com.zgluis.ricknmorty.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.zgluis.ricknmorty.R;
import com.zgluis.ricknmorty.model.Character;

import java.util.List;

public class CharacterRowAdapter extends RecyclerView.Adapter<CharacterRowAdapter.ViewHolder> {

    List<Character> dataSet;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textvName;
        TextView textvStatus;
        ImageView imagevCharacter;
        TextView textvSpecies;
        TextView textvGender;

        public ViewHolder(View itemView) {
            super(itemView);
            textvName = itemView.findViewById(R.id.textv_name);
            textvStatus = itemView.findViewById(R.id.textv_status);
            imagevCharacter = itemView.findViewById(R.id.imagev_character);
            textvSpecies = itemView.findViewById(R.id.textv_species);
            textvGender = itemView.findViewById(R.id.textv_gender);
        }
    }

    public CharacterRowAdapter(List<Character> characters) {
        dataSet = characters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_row, parent, false);
        return new CharacterRowAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Character character = dataSet.get(position);
        holder.textvName.setText(character.getName());
        holder.textvGender.setText(character.getGender());
        holder.textvSpecies.setText(character.getSpecies());
        holder.textvStatus.setText(character.getStatus());
        Picasso.get().load(character.getImage()).into(holder.imagevCharacter);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
