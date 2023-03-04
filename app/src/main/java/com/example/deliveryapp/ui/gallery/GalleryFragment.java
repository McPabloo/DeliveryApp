package com.example.deliveryapp.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.deliveryapp.R;
import com.example.deliveryapp.contactoActivity;
import com.example.deliveryapp.databinding.FragmentGalleryBinding;
import com.example.deliveryapp.ui.slideshow.UserCreditAct;
import com.example.deliveryapp.ui.slideshow.acercadenosotrosActivity;
import com.example.deliveryapp.ui.slideshow.ajustesActivity;
import com.example.deliveryapp.ui.slideshow.userProfileAct;


public class GalleryFragment extends Fragment implements View.OnClickListener {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageButton BOTON1 = (ImageButton) root.findViewById(R.id.favsi);
        BOTON1.setOnClickListener(this);

        ImageButton BOTON2 = (ImageButton) root.findViewById(R.id.btntarjeta);
        BOTON2.setOnClickListener(this);

        Button BOTON3 = (Button) root.findViewById(R.id.btncontacto);
        BOTON3.setOnClickListener(this);

        Button BOTON4 = (Button) root.findViewById(R.id.btnacercade);
        BOTON4.setOnClickListener(this);

        ImageButton BOTON5 = (ImageButton) root.findViewById(R.id.favsa);
        BOTON5.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.favsi:
                Intent intent = new Intent(getActivity(), userProfileAct.class);
                startActivity(intent);
                break;
            case R.id.btntarjeta:
                Intent intent1 = new Intent(getActivity(), UserCreditAct.class);
                startActivity(intent1);
                break;
            case R.id.btncontacto:
                Intent intent2 = new Intent(getActivity(), contactoActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnacercade:
                Intent intent3 = new Intent(getActivity(), acercadenosotrosActivity.class);
                startActivity(intent3);
                break;
            case R.id.favsa:
                Intent intent4 = new Intent(getActivity(), ajustesActivity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}