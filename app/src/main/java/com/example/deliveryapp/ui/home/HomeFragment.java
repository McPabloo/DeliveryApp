package com.example.deliveryapp.ui.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.deliveryapp.R;
import com.example.deliveryapp.databinding.FragmentHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userRef = database.getReference("users");
    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView textViewEmail = root.findViewById(R.id.favsi);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        String email = firebaseUser.getEmail();

        textViewEmail.setText(email);



        Button guardarButton = root.findViewById(R.id.corona);
        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Corona";
                String precioProducto = "18";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton1 = root.findViewById(R.id.victoria);
        guardarButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Victoria";
                String precioProducto = "18";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton2 = root.findViewById(R.id.modeloe);
        guardarButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Modelo Especial";
                String precioProducto = "18";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton4 = root.findViewById(R.id.modelon);
        guardarButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Negra Modelo";
                String precioProducto = "18";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton5 = root.findViewById(R.id.cent);
        guardarButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Centenario Plata";
                String precioProducto = "350";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton6 = root.findViewById(R.id.mil);
        guardarButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "1800 Añejo";
                String precioProducto = "940";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton7 = root.findViewById(R.id.herradura);
        guardarButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Herradura Ultra";
                String precioProducto = "1200";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton8 = root.findViewById(R.id.ant);
        guardarButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Herradura Antiguo";
                String precioProducto = "600";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton9 = root.findViewById(R.id.caca);
        guardarButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Cacahuates";
                String precioProducto = "18";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton10 = root.findViewById(R.id.dori);
        guardarButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Doritos";
                String precioProducto = "18";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton11 = root.findViewById(R.id.salsa);
        guardarButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Salsa Botanera";
                String precioProducto = "25";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button guardarButton12 = root.findViewById(R.id.papa);
        guardarButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = "Papas";
                String precioProducto = "24";

                if (!TextUtils.isEmpty(nombreProducto) && !TextUtils.isEmpty(precioProducto)) {
                    // Generar un nuevo identificador único para el producto
                    String productoId = userRef.child(uid).child("productos").push().getKey();

                    // Crear un objeto HashMap para guardar los datos del producto
                    HashMap<String, Object> productoMap = new HashMap<>();
                    productoMap.put("nombre", nombreProducto);
                    productoMap.put("precio", precioProducto);

                    // Guardar los datos del producto en la base de datos
                    userRef.child(uid).child("productos").child(productoId).setValue(productoMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Producto guardado", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(getActivity(), "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Ingresa un nombre y un precio de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}