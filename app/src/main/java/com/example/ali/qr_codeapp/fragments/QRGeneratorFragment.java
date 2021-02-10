package com.example.ali.qr_codeapp.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ali.qr_codeapp.databinding.FragmentQrGeneratorBinding;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.image.ImageType;

/**
 * A simple {@link Fragment} subclass.
 */
public class QRGeneratorFragment extends Fragment {


    FragmentQrGeneratorBinding binding;

    public QRGeneratorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQrGeneratorBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setCallback(this);
    }

    public void BtnGenerate() {

        if (!binding.txtData.getText().toString().isEmpty()){
            new CopyTask(getContext()).execute();
        }

    }


    public class CopyTask extends AsyncTask<Void, Void, String> {

        ProgressDialog Asycdialog;
        Context mContext;
        Bitmap bitmap;

        public CopyTask(Context mContext) {
            this.mContext = mContext;
            Asycdialog = new ProgressDialog(mContext);
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            Asycdialog.setTitle("GENRATING QR");
            Asycdialog.setMessage("Loading...");
            Asycdialog.setCancelable(false);
            Asycdialog.show();
        }

        @Override
        protected String doInBackground(Void... arg0) {

            // do the task you want to do. This will be executed in background.
            try {

                bitmap = QRCode.from(String.valueOf(binding.txtData.getText().toString())).withCharset("UTF-8").to(ImageType.PNG).withSize(500, 500).bitmap();

                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "";
        }

        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result);
            binding.imgQRcode.setImageBitmap(bitmap);
            Asycdialog.dismiss();
            Toast.makeText(mContext, "Copying done!!", Toast.LENGTH_SHORT).show();
        }
    }
}
