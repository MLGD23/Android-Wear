package mx.octaviocervantes.mypetcare.adapter;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;

/**
 * Created by Tavo on 11/09/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<DatosMascota> mascotas;

    public MascotaAdaptador(ArrayList<DatosMascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final DatosMascota mascota = mascotas.get(position);

        holder.imgMascota.setImageResource(mascota.getFotoMascota());
        holder.txtMascota.setText(mascota.getNombreMascota());
        holder.txtRating.setText(mascota.getRatingMascota());

        holder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Te ha gustado " + mascota.getNombreMascota(), Snackbar.LENGTH_SHORT).show();
                mascota.setRatingMascota(String.valueOf(Integer.parseInt(mascota.getRatingMascota()) + 1));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
        private ImageButton imgHuesoBlanco;
        private TextView txtMascota;
        private TextView txtRating;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            imgHuesoBlanco = (ImageButton) itemView.findViewById(R.id.imgHuesoBlanco);
            txtMascota = (TextView) itemView.findViewById(R.id.txtMascota);
            txtRating = (TextView) itemView.findViewById(R.id.txtRating);
        }
    }
}
