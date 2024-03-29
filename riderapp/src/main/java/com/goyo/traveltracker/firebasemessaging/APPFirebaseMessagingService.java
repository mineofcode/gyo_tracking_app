package com.goyo.traveltracker.firebasemessaging;

/**
 * Created by mTech on 06-May-2017.
 */


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.goyo.traveltracker.R;
import com.goyo.traveltracker.initials.splash_screen;

public class APPFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
//    final Popup_Counter CountTimer = new Popup_Counter(180000, 1000);
    NotificationCompat.Builder mBuilder;
    NotificationManager notificationManager;
    private Button Btn_Accept, Btn_Reject;
    private TextView Deliver_at_Text;
    private TextView PopUp_CountText;
    private PopupWindow OrderPopup;
    String ordid,olnm,stops,amt;


    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
        // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages containing both notification
        // and data payloads are treated as notification messages. The Firebase console always sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                scheduleJob();
            } else {
                // Handle message within 10 seconds
                handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            sendNotification(remoteMessage);
            //Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
//            processData(remoteMessage);
            //sendNotification(remoteMessage.getNotification().getBody());
            //Toast.makeText(this, remoteMessage.getNotification().getBody(),Toast.LENGTH_SHORT).show();
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

//    public class Popup_Counter extends CountDownTimer {
//
//        public Popup_Counter(long millisInFuture, long countDownInterval) {
//            super(millisInFuture, countDownInterval);
//        }
//
//        @Override
//        public void onFinish() {
////            OrderPopup.dismiss();
//        }
//
//        @Override
//        public void onTick(long millisUntilFinished) {
//            mBuilder.setContentText(ordid+" "+olnm+" "+stops+" "+amt+" "+String.format("%02d:%02d",
//                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
//                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
//            notificationManager.notify(0, mBuilder.build());
//        }
//    }


//    public void initiatePopupWindow() {
//        try {
//            String role;
//            role = "db";
//            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View layout = inflater.inflate(R.layout.popup_orderummery,
//                    null);
//            OrderPopup = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
//            OrderPopup.showAtLocation(layout, Gravity.CENTER, 0, 0);
//            OrderPopup.setOutsideTouchable(false);
//
//            CountTimer.start();
//
//            Btn_Accept = (Button) layout.findViewById(R.id.Accept_order);
//            Btn_Reject = (Button) layout.findViewById(R.id.Reject_Order);
//            PopUp_CountText = (TextView) layout.findViewById(R.id.popup_counter);
//            Deliver_at_Text = (TextView) layout.findViewById(R.id.Deliver_at);
//
//            //If User role = "TL" or "Admin" Show address else don't show address
//            if (role.toLowerCase() == "db")
//                Deliver_at_Text.setText("xxx");
//            else
//                Deliver_at_Text.setText("Actual First Delivery Location");
//
//
//            Btn_Accept.setOnClickListener(accept_order_click);
//            Btn_Reject.setOnClickListener(reject_order_click);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    private View.OnClickListener accept_order_click = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
////            setStatus();
//            OrderPopup.dismiss();
//        }
//    };
//    private View.OnClickListener reject_order_click = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            OrderPopup.dismiss();
//        }
//    };
    // [END receive_message]

    /**
     * Schedule a job using FirebaseJobDispatcher.
     */
    private  void processData(RemoteMessage _msg){



//        Map<String,String> Data= (Map<String, String>) _msg.getData();
//        ordid = Data.get("ordid");
//        olnm = Data.get("olnm");
//        stops = Data.get("stops");
//        amt = Data.get("amt");

//        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.popup_orderummery);
//        contentView.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
//        contentView.setTextViewText(R.id.title, "Custom notification");
//        contentView.setTextViewText(R.id.text, "This is a custom layout");
//        contentView.setTextViewText(R.id.title, "Custom notification");
//
//        mBuilder = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.drawable.rider)
//                .setContent(contentView);
//
//        Notification notification = mBuilder.build();
//        notification.flags |= Notification.FLAG_AUTO_CANCEL;
//        notification.defaults |= Notification.DEFAULT_SOUND;
//        notification.defaults |= Notification.DEFAULT_VIBRATE;
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        notificationManager.notify(1, notification);


//        try {
//            boolean foregroud = new CheckAppForground().execute(this).get();
////            if(!foregroud)
//            {
//                Intent snoozeIntent = new Intent(this, MainActivity.class);
//                PendingIntent piSnooze = PendingIntent.getService(this, 0, snoozeIntent, 0);
//
//                Intent dismissIntent = new Intent(this, MainActivity.class);
//                PendingIntent piDismiss = PendingIntent.getService(this, 0, dismissIntent, 0);
//
////                Intent intent = new Intent(this, APPFirebaseMessagingService.class);
////                intent.putExtra("NotiClick",true);
////                Intent buttonsIntent = new Intent(this, NotifyActivityHandler.class);
////                buttonsIntent.putExtra("do_action", "Accept");
//
//                Intent switchIntent = new Intent(this, switchButtonListener.class);
//                PendingIntent pendingSwitchIntent = PendingIntent.getBroadcast(this, 0,
//                        switchIntent, 0);
//
//
//               mBuilder =
//                        new NotificationCompat.Builder(this)
//                                .setSmallIcon(R.drawable.rider)
//                                .setContentTitle("New Order")
//                                .setDefaults(Notification.DEFAULT_ALL) // must requires VIBRATE permission
//                                .setPriority(NotificationCompat.PRIORITY_HIGH) //must give priority to High, Max which will considered as heads-up notification
//                                .addAction(R.drawable.bluetick,
//                                        "Acce   pt",pendingSwitchIntent)
//                                .addAction(R.drawable.ic_action_cancel,
//                                        "Reject",piSnooze)
//                                .setVisibility(BIND_IMPORTANT)
//                                .setOngoing(true)
//                                .setAutoCancel(false);
//                  CountTimer.start();
////
//                notificationManager =
//                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
////to post your notification to the notification bar with a id. If a notification with same id already exists, it will get replaced with updated information.
//                notificationManager.notify(0, mBuilder.build());
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        Intent intent = new Intent("order-receive");
////        // You can also include some extra data.
//        intent.putExtra("message", "This is my message!");
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

//        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View dialogView = inflater.inflate(R.layout.popup_orderummery, null);
//        builder.setView(dialogView);
//        final AlertDialog alert = builder.create();
//        alert.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        alert.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//        alert.show();
//        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//        Window window = alert.getWindow();
//        lp.copyFrom(window.getAttributes());
//        //This makes the dialog take up the full width
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        window.setAttributes(lp);

    }

//    public class switchButtonListener extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Toast.makeText(APPFirebaseMessagingService.this, "Send Data", Toast.LENGTH_SHORT).show();
//
//            JsonObject json = new JsonObject();
//            json.addProperty("flag", "order");
//            json.addProperty("status", "2");
//            json.addProperty("ordid", "1");
//            json.addProperty("rdid", Global.loginusr.getDriverid() + "");
//
//            Ion.with(APPFirebaseMessagingService.this)
//                    .load(Global.urls.setStatus.value)
//                    .setJsonObjectBody(json)
//                    .asJsonObject()
//                    .setCallback(new FutureCallback<JsonObject>() {
//                        @Override
//                        public void onCompleted(Exception e, JsonObject result) {
//
//                            try {
//                                if (result != null) Log.v("result", result.toString());
//                            } catch (Exception ea) {
//                                ea.printStackTrace();
//                            }
//                        }
//                    });
//        }
//    }



    private void scheduleJob() {
        // [START dispatch_job]
//        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
//        Job myJob = dispatcher.newJobBuilder()
//                .setService(MyJobService.class)
//                .setTag("my-job-tag")
//                .build();
//        dispatcher.schedule(myJob);
        // [END dispatch_job]
    }

    /**
     * Handle time allotted to BroadcastReceivers.
     */
    private void handleNow() {
        Log.d(TAG, "Short lived task is done.");
    }

//    /**
//     * Create and show a simple notification containing the received FCM message.
//     *

    private void sendNotification(RemoteMessage _msg) {
        Intent intent = new Intent(this, splash_screen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.tracker_ic)
                .setAutoCancel(true)
                .setContentText(_msg.getNotification().getBody())
                .setContentTitle(_msg.getNotification().getTitle())
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(66 /* ID of notification */, notificationBuilder.build());
    }
}