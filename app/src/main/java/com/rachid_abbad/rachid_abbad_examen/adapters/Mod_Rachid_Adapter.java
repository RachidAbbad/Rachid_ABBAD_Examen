package com.rachid_abbad.rachid_abbad_examen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rachid_abbad.rachid_abbad_examen.Dialog.Module_dialog;
import com.rachid_abbad.rachid_abbad_examen.R;
import com.rachid_abbad.rachid_abbad_examen.activities.Mod_Rachid_Activity;
import com.rachid_abbad.rachid_abbad_examen.classes.Mod_Rachid;

import java.util.List;

public class Mod_Rachid_Adapter extends RecyclerView.Adapter<Mod_Rachid_Adapter.ViewHolder> {

    List<Mod_Rachid> list;
    Context context;
    Mod_Rachid_Activity activity;
    int res;

    public Mod_Rachid_Adapter(Context context, int item_layout, List<Mod_Rachid> list,Mod_Rachid_Activity activity){
        this.list = list;
        this.res = item_layout;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Module_dialog(list.get(position)).show(activity.getSupportFragmentManager(),null);
            }
        });

        holder.initule.setText(list.get(position).getIntitule()+"");
        holder.horaire.setText(list.get(position).getEnv_h()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView initule,horaire;
        CardView container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initule = itemView.findViewById(R.id.intitule);
            horaire = itemView.findViewById(R.id.horaire);
            container = itemView.findViewById(R.id.container);
        }

    }
}
