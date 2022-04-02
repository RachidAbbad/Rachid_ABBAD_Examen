package com.rachid_abbad.rachid_abbad_examen.Dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.rachid_abbad.rachid_abbad_examen.R;
import com.rachid_abbad.rachid_abbad_examen.classes.Mod_Rachid;

public class Module_dialog  extends BottomSheetDialogFragment {
    TextView intitule, horaire,cin,id_mod;
    Mod_Rachid mod;

    public Module_dialog(Mod_Rachid mod){
        this.mod = mod;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getActivity(), R.layout.mod_dialog, null);
        dialog.setContentView(contentView);

        intitule = contentView.findViewById(R.id.intitule);
        horaire = contentView.findViewById(R.id.horaire);
        cin = contentView.findViewById(R.id.cin);
        id_mod = contentView.findViewById(R.id.id_mod);

        intitule.setText(mod.getIntitule());
        cin.setText(mod.getCin());
        id_mod.setText(mod.getIdModule()+"");
        horaire.setText(mod.getEnv_h()+"");

    }
}
