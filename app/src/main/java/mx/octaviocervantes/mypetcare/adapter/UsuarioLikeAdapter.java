package mx.octaviocervantes.mypetcare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;

/**
 * Created by Tavo on 06/11/2016.
 */
public class UsuarioLikeAdapter extends RecyclerView.Adapter<UsuarioLikeAdapter.UsuarioLikeViewHolder> {


    ArrayList<MascotaIdInstagram> fotoUsuarioLike;
    Context context;

    public UsuarioLikeAdapter(ArrayList<MascotaIdInstagram> fotoUsuarioLike, Context context) {
        this.fotoUsuarioLike = fotoUsuarioLike;
        this.context = context;
    }

    @Override
    public UsuarioLikeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_usuario_like, parent, false);

        return new UsuarioLikeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UsuarioLikeViewHolder holder, int position) {
        final MascotaIdInstagram fotoMascota = fotoUsuarioLike.get(position);

        Picasso.with(context)
                .load(fotoMascota.getUrlFoto())
                .placeholder(R.drawable.golden)
                .into(holder.imgFotoUsuarioLike);

        holder.txtRatingFotoUsuarioLike.setText(String.valueOf(fotoMascota.getMeGusta()));
    }

    @Override
    public int getItemCount() {
        return fotoUsuarioLike.size();
    }

    public static class UsuarioLikeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoUsuarioLike;
        private TextView txtRatingFotoUsuarioLike;

        public UsuarioLikeViewHolder(View itemView) {
            super(itemView);
            imgFotoUsuarioLike = (ImageView) itemView.findViewById(R.id.imgFotoUsuarioLike);
            txtRatingFotoUsuarioLike = (TextView) itemView.findViewById(R.id.txtRatingFotoUsuarioLike);
        }
    }
}
