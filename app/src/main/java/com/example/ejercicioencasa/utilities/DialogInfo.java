package com.example.ejercicioencasa.utilities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.ejercicioencasa.R;

import java.util.Objects;

public class DialogInfo extends AppCompatDialogFragment {

    String dialog;

    public DialogInfo(String dialog) {
        this.dialog = dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedIntanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(getResources().getString(R.string.info_label))
                .setMessage(dialog)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
