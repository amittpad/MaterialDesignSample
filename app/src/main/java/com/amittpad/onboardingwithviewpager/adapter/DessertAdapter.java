package com.amittpad.onboardingwithviewpager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.amittpad.onboardingwithviewpager.R;
import com.amittpad.onboardingwithviewpager.model.Dessert;

import java.util.ArrayList;
import java.util.List;



public class DessertAdapter extends RecyclerView.Adapter<DessertAdapter.DessertVh> {


    private List<Dessert> desserts = new ArrayList<>();

    private Context context;

    public DessertAdapter(Context context) {
        this.context = context;

        desserts = Dessert.prepareDesserts(
                context.getResources().getStringArray(R.array.dessert_names),
                context.getResources().getStringArray(R.array.dessert_descriptions));
    }

    @Override
    public DessertVh onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_dessert, parent, false);
        return new DessertVh(view);
    }

    @Override
    public void onBindViewHolder(DessertVh holder, int position) {
        Dessert dessert = desserts.get(position);

        holder.mName.setText(dessert.getName());
        holder.mDescription.setText(dessert.getDescription());
        holder.mFirstLetter.setText(String.valueOf(dessert.getFirstLetter()));

    }

    @Override
    public int getItemCount() {
        return desserts == null ? 0 : desserts.size();
    }

    public static class DessertVh extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mDescription;
        private TextView mFirstLetter;

        public DessertVh(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.txt_name);
            mDescription = (TextView) itemView.findViewById(R.id.txt_desc);
            mFirstLetter = (TextView) itemView.findViewById(R.id.txt_firstletter);
        }
    }
}
