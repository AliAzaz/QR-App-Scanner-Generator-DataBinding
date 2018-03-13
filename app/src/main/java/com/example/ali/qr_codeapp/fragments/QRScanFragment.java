package com.example.ali.qr_codeapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ali.qr_codeapp.databinding.FragmentQrScanBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class QRScanFragment extends Fragment {

    FragmentQrScanBinding binding;

    public QRScanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQrScanBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.txtScanResult.setText(getArguments().getString("data"));

    }
}
