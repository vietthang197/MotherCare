package haui.lethanhha.com.mothercare.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.activity.MenuMainActivity;

public class AlarmNotify extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("THONGBAO")) {
            if (intent.getStringExtra("NOIDUNG") != null) {
                NotificationCompat .Builder nBuilder = new NotificationCompat
                        .Builder(context)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Thông báo")
                        .setContentText(intent.getStringExtra("NOIDUNG"));

                Intent resultIntent = new Intent(context, MenuMainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_CANCEL_CURRENT);
                nBuilder.setContentIntent(pendingIntent);
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                nBuilder.setSound(uri);
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(113, nBuilder.build());
            }

        }
    }
}
