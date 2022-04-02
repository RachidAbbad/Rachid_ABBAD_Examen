package com.rachid_abbad.rachid_abbad_examen.Dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.rachid_abbad.rachid_abbad_examen.R;
import com.rachid_abbad.rachid_abbad_examen.classes.Prof_Rachid;

import org.w3c.dom.Text;

public class Prof_dialog  extends BottomSheetDialogFragment implements Parcelable {
    Prof_Rachid prof;
    TextView cin, nom, specialite;

    public Prof_dialog(Prof_Rachid prof) {
        this.prof = prof;
    }

    protected Prof_dialog(Parcel in) {
    }

    public static final Creator<Prof_dialog> CREATOR = new Creator<Prof_dialog>() {
        @Override
        public Prof_dialog createFromParcel(Parcel in) {
            return new Prof_dialog(in);
        }

        @Override
        public Prof_dialog[] newArray(int size) {
            return new Prof_dialog[size];
        }
    };

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getActivity(), R.layout.prof_dialog, null);
        dialog.setContentView(contentView);

        cin = contentView.findViewById(R.id.cin);
        nom = contentView.findViewById(R.id.nom);
        specialite = contentView.findViewById(R.id.specialite);

        cin.setText(prof.getCin());
        nom.setText(prof.getNom());
        specialite.setText(prof.getSpecialite());

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
