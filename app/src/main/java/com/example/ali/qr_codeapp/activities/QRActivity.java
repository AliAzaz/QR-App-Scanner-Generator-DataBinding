package com.example.ali.qr_codeapp.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ali.qr_codeapp.R;
import com.example.ali.qr_codeapp.databinding.ActivityQrBinding;
import com.example.ali.qr_codeapp.fragments.QRGeneratorFragment;
import com.example.ali.qr_codeapp.fragments.QRScanFragment;

public class QRActivity extends AppCompatActivity {

    ActivityQrBinding binding;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_qr);
        binding.setCallback(this);

        String type = getIntent().getStringExtra("type");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (type.equals("scan")) {
            Bundle bundle = new Bundle();
            bundle.putString("data", getIntent().getStringExtra("scanData"));
            fragment = new QRScanFragment();
            fragment.setArguments(bundle);

        } else {
            fragment = new QRGeneratorFragment();
        }

        transaction.replace(R.id.fragmentLayout, fragment);
        transaction.commit();

    }
}
