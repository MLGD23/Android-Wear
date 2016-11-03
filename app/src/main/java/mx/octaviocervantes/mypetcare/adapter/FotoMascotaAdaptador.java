package mx.octaviocervantes.mypetcare.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;
import mx.octaviocervantes.mypetcare.datos.MascotaInstagram;
import mx.octaviocervantes.mypetcare.datos.Metodos;
import mx.octaviocervantes.mypetcare.datos.MetodosRestAPI;
import mx.octaviocervantes.mypetcare.db.ConstructorMascotas;
import mx.octaviocervantes.mypetcare.fragments.PerfilFragment;

/**
 * Created by Tavo on 24/09/2016.
 */
public class FotoMascotaAdaptador extends RecyclerView.Adapter<FotoMascotaAdaptador.FotoMascotaViewHolder>{


    ArrayList<MascotaIdInstagram> fotoMascotas;
    Context context;

    public FotoMascotaAdaptador(ArrayList<MascotaIdInstagram> fotoMascotas, Context context) {
        this.fotoMascotas = fotoMascotas;
        this.context = context;
    }

    @Override
    public FotoMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos_mascota, parent, false);

        return new FotoMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotoMascotaViewHolder holder, int position) {
        final MascotaIdInstagram fotoMascota = fotoMascotas.get(position);
        final String idFoto = fotoMascota.getIdFoto();

        Picasso.with(context)
                .load(fotoMascota.getUrlFoto())
                .placeholder(R.drawable.golden)
                .into(holder.imgFotoMascota);

        holder.txtRatingFoto.setText(String.valueOf(fotoMascota.getMeGusta()));
        holder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MetodosRestAPI metodos = new MetodosRestAPI(context);
                metodos.darLikeFoto(idFoto);
                metodos.registroLike(idFoto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fotoMascotas.size();
    }

    public static class FotoMascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoMascota;
        private TextView txtRatingFoto;
        private ImageButton imgHuesoBlanco;

        public FotoMascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            txtRatingFoto = (TextView) itemView.findViewById(R.id.txtRatingFoto);
            imgHuesoBlanco = (ImageButton) itemView.findViewById(R.id.imgHuesoBlanco);
        }
    }
}
