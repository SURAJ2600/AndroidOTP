package androidmasterminds.com.androidotp.SmsInterface;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;


public class SmsReceivers extends BroadcastReceiver {

    private static SmsListener mListener;
    Boolean b;
    String abcd, xyz;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle data = intent.getExtras();
      //  Log.e("mesage","ddd");
       // System.out.print("SDddddddddddddd");

        Object[] pdus = (Object[]) data.get("pdus");

       // Log.e("mesage","ddd"+pdus);
        for (int i = 0; i < pdus.length; i++) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
            String sender = smsMessage.getDisplayOriginatingAddress();
            b=sender.startsWith("VM");  //Just to fetch otp sent from WNRCRP
            String messageBody = smsMessage.getMessageBody();
            abcd = messageBody.replaceAll("[^0-9]", "");   // here abcd contains otp

            //Pass on the text to our listener.
        /*    if (b == true) {*/
                mListener.messageReceived(abcd);  // attach value to interface

           /* } else {*/
           // }
        }
    }

    public static void bindListener(SmsListener listener) {
        mListener = listener;
    }
}