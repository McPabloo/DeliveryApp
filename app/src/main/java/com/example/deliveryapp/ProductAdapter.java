package com.example.deliveryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Producto> productosList;
    private Map<String, Producto> productosMap;

    public ProductAdapter(List<Producto> productosList) {
        this.productosList = productosList;
        this.productosMap = new HashMap<>();

        // Asociar cada producto con su ID en el mapa
        for (Producto producto : productosList) {
            productosMap.put(producto.getId(), producto);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto producto = productosList.get(position);

        holder.textViewNombre.setText(producto.getNombre());
        holder.textViewPrecio.setText("$ " + producto.getPrecio());



        if (producto.getNombre().equals("Corona")) {
            holder.productImageView.setImageResource(R.drawable.corona);
        } else if (producto.getNombre().equals("Victoria")) {
            holder.productImageView.setImageResource(R.drawable.victoria);
        } else if (producto.getNombre().equals("Modelo Especial")) {
            holder.productImageView.setImageResource(R.drawable.modelo);
        } else if (producto.getNombre().equals("Negra Modelo")) {
            holder.productImageView.setImageResource(R.drawable.modeloosc);
        } else if (producto.getNombre().equals("Centenario Plata")) {
            holder.productImageView.setImageResource(R.drawable.centenario);
        } else if (producto.getNombre().equals("1800 Añejo")) {
            holder.productImageView.setImageResource(R.drawable.mil);
        } else if (producto.getNombre().equals("Herradura Ultra")) {
            holder.productImageView.setImageResource(R.drawable.herradura);
        } else if (producto.getNombre().equals("Herradura Antiguo")) {
            holder.productImageView.setImageResource(R.drawable.antiguo);
        } else if (producto.getNombre().equals("Cacahuates")) {
            holder.productImageView.setImageResource(R.drawable.cacahuate);
        } else if (producto.getNombre().equals("Doritos")) {
            holder.productImageView.setImageResource(R.drawable.doritos);
        } else if (producto.getNombre().equals("Salsa Botanera")) {
            holder.productImageView.setImageResource(R.drawable.salsa);
        } else if (producto.getNombre().equals("Papas")) {
            holder.productImageView.setImageResource(R.drawable.papas);
        }
        else {
            // Si no coincide con ningún producto específico, establecer una imagen predeterminada
            holder.productImageView.setImageResource(R.drawable.corona);
        }




    }

    @Override
    public int getItemCount() {
        return productosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        TextView textViewPrecio;
        ImageView productImageView;
        Button deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewPrecio = itemView.findViewById(R.id.textViewPrecio);
            productImageView = itemView.findViewById(R.id.productImage);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Producto producto = productosList.get(position);
                        // Llama a la función para eliminar el producto de Firebase
                        eliminarProductoFirebase(position);
                    }
                }
            });
        }

        public void eliminarProductoFirebase(int position) {
            DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
            String usuarioActual = FirebaseAuth.getInstance().getCurrentUser().getUid();

            // Eliminar el producto de Firebase utilizando la posición
            databaseRef.child(usuarioActual).child("productos").child(String.valueOf(position)).removeValue();

            // Remover el producto de la lista y actualizar la vista
            productosList.remove(position);
            notifyItemRemoved(position);
        }





    }
}
