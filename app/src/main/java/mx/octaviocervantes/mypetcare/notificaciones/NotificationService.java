package mx.octaviocervantes.mypetcare.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.util.Log;
import android.view.Gravity;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.datos.Metodos;

/**
 * Created by Tavo on 24/10/2016.
 */
public class NotificationService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    private static final int NOTIFY_ID = 001;
    private String idUser = "", sUser = "";
    Metodos metodos;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        idUser = remoteMessage.getData().get("iduser");
        sUser = remoteMessage.getData().get("suser");

        metodos = new Metodos(getBaseContext());
        metodos.guardarDatosUsuarioLike(idUser, sUser);

        Log.d("ID_USER_LIKE", idUser);
        Log.d("USER_LIKE", sUser);

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        lanzarNotificacion(remoteMessage);
    }

    private void lanzarNotificacion(RemoteMessage remoteMessage) {
        Intent intMyProfile = new Intent();
        intMyProfile.setAction("MY_PROFILE");

        Intent intFollows = new Intent();
        intFollows.setAction("FOLLOWS");

        Intent intProfile = new Intent();
        intProfile.setAction("USER_PROFILE");

        PendingIntent pendingIntentMyProfile = PendingIntent.getBroadcast(this, 0, intMyProfile, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pendingIntentFollows = PendingIntent.getBroadcast(this, 0, intFollows, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pendingIntentProfile = PendingIntent.getBroadcast(this, 0, intProfile, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Action actionMiPerfil =
                new NotificationCompat.Action.Builder(R.drawable.my_profile_wear, getString(R.string.my_profile_wear), pendingIntentMyProfile).build();

        NotificationCompat.Action actionFollow =
               new NotificationCompat.Action.Builder(R.drawable.follow_wear, getString(R.string.follow_wear), pendingIntentFollows).build();

        NotificationCompat.Action actionPerfil =
                new NotificationCompat.Action.Builder(R.drawable.profile_wear, getString(R.string.profile_wear), pendingIntentProfile).build();

        WearableExtender wearableExtender =
                new WearableExtender()
                .setHintHideIcon(true)
                .setBackground(BitmapFactory.decodeResource(getResources(), R.drawable.fondo))
                .setGravity(Gravity.TOP);

        android.support.v4.app.NotificationCompat.Builder notificacion = new android.support.v4.app.NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notificación recibida")
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setContentIntent(pendingIntentMyProfile)
                .setContentIntent(pendingIntentFollows)
                .extend(wearableExtender.addAction(actionMiPerfil))
                .extend(wearableExtender.addAction(actionFollow))
                .extend(wearableExtender.addAction(actionPerfil))
                .setAutoCancel(true)
                .setOngoing(false);

        //NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //notificationManager.notify(0, notificacion.build());

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFY_ID, notificacion.build());
    }
}
