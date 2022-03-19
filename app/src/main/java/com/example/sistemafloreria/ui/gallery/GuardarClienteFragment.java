package com.example.sistemafloreria.ui.gallery;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sistemafloreria.R;
import com.example.sistemafloreria.adminDB;
import com.example.sistemafloreria.databinding.FragmentGuardarclienteBinding;
import com.example.sistemafloreria.databinding.FragmentHomeBinding;
import com.example.sistemafloreria.ui.home.HomeViewModel;

//import com.example.sistemafloreria.databinding.FragmentGallery;

public class GuardarClienteFragment extends Fragment implements View.OnClickListener {
    //declaracion de los elementos de iteraccion
EditText id,nombre,telefono,edade;
RadioButton m=null,f=null, selected=null;

Button guardar,limpiar;
    private GalleryViewModel galleryViewModel;
    private FragmentGuardarclienteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        binding = FragmentGuardarclienteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        id=(EditText)root.findViewById(R.id.id_cli);
       nombre=(EditText)root.findViewById(R.id.id_nombre);
       telefono=(EditText)root.findViewById(R.id.id_telefono);
        edade=(EditText)root.findViewById(R.id.edad);
        f=(RadioButton)root.findViewById(R.id.radio_femenino);
        m=(RadioButton)root.findViewById(R.id.radio_masculino);
        RadioGroup radioSexos = (RadioGroup)root.findViewById(R.id.id_radioGenero);
        radioSexos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selected=(RadioButton)root.findViewById(i);
                Log.i("floreria","Tu seleccionaste "+ selected.getText());
            }
        });
       guardar=(Button)root.findViewById(R.id.botonguardar);
       limpiar=(Button)root.findViewById(R.id.button_limpiar);
               //generando los click globales

               guardar.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String i,n,t,e,s="";
                       i=id.getText().toString();
                       n=nombre.getText().toString();
                       t=telefono.getText().toString();
                       e=edade.getText().toString();
                       s=selected.getText().toString();
                       Log.i("datos","id:"+i+"nombre"+n+"telefono"+t+"edad"+e+"sexo"+s);
                       if (i.length()>0 && n.length()>1 && t.length()>9 && e.length()>0 && s.length()>0) {
                           Log.i("registered","Si esta para registrarse");
                           adminDB bd=new adminDB(getContext(),"ejercicio", null,1);
                           SQLiteDatabase con= bd.getWritableDatabase();
                           con.execSQL("insert into clientes values('"+i+"','"+n+"','"+t+"','"+e+"','"+s+"');");
                           Toast.makeText(getContext(),"se ha insertado el cliente", Toast.LENGTH_LONG).show();
                           bd.close();
                       }else{
                           Log.i("notRegister","No se cuplieron los requisitos");
                       }
                   }
               });

               //GLOBALES
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //final TextView textView = binding.textHome;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
              //  textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {

    }
}