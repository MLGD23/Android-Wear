package mx.octaviocervantes.mypetcare.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.datos.FotosDatosMascota;

/**
 * Created by Tavo on 24/09/2016.
 */
public class FotoMascotaAdaptador extends RecyclerView.Adapter<FotoMascotaAdaptador.FotoMascotaViewHolder>{

    ArrayList<FotosDatosMascota> fotoMascotas;

    public FotoMascotaAdaptador(ArrayList<FotosDatosMascota> fotoMascotas) {
        this.fotoMascotas = fotoMascotas;
    }

    @Override
    public FotoMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos_mascota, parent, false);

        return new FotoMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotoMascotaViewHolder holder, int position) {
        final FotosDatosMascota fotoMascota = fotoMascotas.get(position);

        holder.imgFotoMascota.setImageResource(fotoMascota.getFotoMascota());
        holder.txtRatingFoto.setText(fotoMascota.getRatingFotoMascota());
    }

    @Override
    public int getItemCount() {
        return fotoMascotas.size();
    }

    public static class FotoMascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoMascota;
        private TextView txtRatingFoto;

        public FotoMascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            txtRatingFoto = (TextView) itemView.findViewById(R.id.txtRatingFoto);
        }
    }
}
