package com.example.furlenco;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class DetailsIntentService extends IntentService {
    String input_data;

    public DetailsIntentService() {
        super("DetailsIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            input_data = intent.getStringExtra("data");
            if (input_data != null) {
                saveDetailsToFile();
            }
        }
    }

    private void saveDetailsToFile() {
        try {
            File directory = new File(getFilesDir() + File.separator + "Cart File");
            if (!directory.exists()) {
                directory.mkdir();
            }
            File newFile = new File(directory, "cart.txt");
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            //WriteDataToFile
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, false);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(input_data);
            outputStreamWriter.close();


            //ReadDataFromFile
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            int data = inputStreamReader.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (data != -1) {
                char ch = (char) data;
                stringBuffer.append(ch);
                data = inputStreamReader.read();
            }
            //UpdateUI
            Intent intent = new Intent("com.data");
            intent.putExtra("data", stringBuffer.toString());
            sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* @RequiresApi(api = Build.VERSION_CODES.O)
    public void showForegroundNotification() {
        String Channel_ID = "Data";
        String ChannelName = "Background Service";
        NotificationChannel notificationChannel = new NotificationChannel(Channel_ID, ChannelName,
                NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        assert notificationManager != null;
        notificationManager.createNotificationChannel(notificationChannel);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Channel_ID);
        Notification notification =
                builder.setOngoing(true)
                        .setContentTitle("App is running in the background")
                        .setContentText("Displaying Data on the UI")
                        .setPriority(NotificationManager.IMPORTANCE_MIN)
                        .setCategory(Notification.CATEGORY_SERVICE)
                        .build();
        startForeground(2, notification);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            showForegroundNotification();
        } else {
            startForeground(1, new Notification());
        }
    }*/
}

