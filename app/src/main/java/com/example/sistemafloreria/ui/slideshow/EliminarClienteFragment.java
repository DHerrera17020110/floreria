package com.example.sistemafloreria.ui.slideshow;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sistemafloreria.R;
import com.example.sistemafloreria.adminDB;
//import com.example.sistemafloreria.databinding.FragmentSlideshowBinding;


public class EliminarClienteFragment extends Fragment implements View.OnClickListener {
    EditText id, nombre, edad, telefono, sexo;
    Button Buscar, Limpiar;

    public EliminarClienteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //inflater es el MENU DESPLEGABLE
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_consultaindividual, container, false);
        id = root.findViewById(R.id.id_cli_E);
        nombre = root.findViewById(R.id.id_nombreE);
        telefono = root.findViewById(R.id.telefonoE);
        edad = root.findViewById(R.id.edadE);
        sexo = root.findViewById(R.id.sexo_clienteE);
        Buscar = root.findViewById(R.id.botonbuscarE);
        Buscar.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botonbuscar_b:
                String clave = id.getText().toString();
                try {
                    adminDB bd = new adminDB(getContext(), "ejercicio", null, 1);
                    SQLiteDatabase con = bd.getReadableDatabase();
                    Cursor c = con.rawQuery("SELECT * FROM clientes where id_cli='" + clave + "';", null);
                    String aux1, aux2, aux3, aux4;
                    if ((c.moveToFirst()) && (!id.equals(""))) {
                        do {
                            aux1 = c.getString(1);
                            telefono.setText(c.getString(2));
                            aux3 = c.getString(3);
                            sexo.setText(c.getString(4));
                        } while (c.moveToNext());
                        nombre.setText(aux1);
                        edad.setText(aux3);
                    }
                    else {
                        Toast t = Toast.makeText(getContext(), "NO EXISTE", Toast.LENGTH_LONG);
                        t.show();
                        id.setText("");
                        c.close();
                        bd.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

    }


}