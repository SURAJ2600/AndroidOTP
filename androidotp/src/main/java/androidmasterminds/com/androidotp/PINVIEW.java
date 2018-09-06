package androidmasterminds.com.androidotp;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidmasterminds.com.androidotp.SmsInterface.SmsListener;
import androidmasterminds.com.androidotp.SmsInterface.SmsReceivers;

/**
 * Created by vadivel on 6/9/18.
 */

public class PINVIEW extends LinearLayout {



    static EditText otp1_txt;
    static EditText otp2_txt;
    static EditText otp3_txt;
    static EditText otp4_txt;
    public PINVIEW(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        LayoutInflater.from(context).inflate(R.layout.customview, this, true);

        Integer title;
        String subtitle;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0);

        try {
            title = a.getInteger(R.styleable.CustomView_InputType, 0);

        } finally {
            a.recycle();
        }

        // Throw an exception if required attributes are not set
        if (title == null) {
            throw new RuntimeException("No title provided");
        }


        init(title);


        SmsReceivers.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String messageText) {

                Log.e("sadasd",""+messageText);
                try {


                    otp1_txt.setText("" + messageText.charAt(0));
                    otp2_txt.setText("" + messageText.charAt(1));
                    otp3_txt.setText("" + messageText.charAt(2));
                    otp4_txt.setText("" + messageText.charAt(3));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


            }
        });
    }

    public static void SetPinType(Integer type)
    {
        switch (type) {
            case 1:

                otp1_txt.setInputType(InputType.TYPE_CLASS_TEXT);

                otp2_txt.setInputType(InputType.TYPE_CLASS_TEXT);
                otp3_txt.setInputType(InputType.TYPE_CLASS_TEXT);

                otp4_txt.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case 2:
                otp1_txt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

                otp2_txt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                otp3_txt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                otp4_txt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

                break;

            case 3:
                otp1_txt.setInputType(InputType.TYPE_CLASS_NUMBER);

                otp2_txt.setInputType(InputType.TYPE_CLASS_NUMBER);
                otp3_txt.setInputType(InputType.TYPE_CLASS_NUMBER);
                otp4_txt.setInputType(InputType.TYPE_CLASS_NUMBER);


                break;


        }

    }

    public static String GetPinNumber(){

        return otp1_txt.getText().toString().trim()+""+otp2_txt
                .getText().toString().trim()+""+otp3_txt.getText().toString().trim()+""
                +otp4_txt.getText().toString().trim();
    }


    // Setup views
    private void init(Integer title) {
        otp1_txt = (EditText) findViewById(R.id.otp1_txt);

        otp2_txt = (EditText) findViewById(R.id.otp2_txt);


        otp3_txt = (EditText) findViewById(R.id.otp3_txt);

        otp4_txt = (EditText) findViewById(R.id.otp4_txt);




        otp1_txt.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(count>=1)
                {
                    otp2_txt.requestFocus();
                }
            }
        });
        otp2_txt.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(count>=1)
                {
                    otp3_txt.requestFocus();
                }
            }
        });
        otp3_txt.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(count>=1)
                {
                    otp4_txt.requestFocus();
                }
            }
        });





        otp1_txt.setOnKeyListener(new View.OnKeyListener() {


            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    if (otp1_txt.getText().length() >=1) {
                        otp2_txt.requestFocus();
                    }
                    if (i == KeyEvent.KEYCODE_DEL && i == KeyEvent.ACTION_DOWN) {
                        //this is for backspace
                        otp1_txt.requestFocus();
                    }

                }
                return false;
            }
        });
        otp2_txt.setOnKeyListener(new View.OnKeyListener() {


            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    if (otp2_txt.getText().length() >= 1) {
                        otp3_txt.requestFocus();
                    }
                    if (i == KeyEvent.KEYCODE_DEL || i == KeyEvent.ACTION_DOWN) {
                        //this is for backspace
                        otp1_txt.requestFocus();
                    } else {

                    }
                }
                return false;
            }
        });
        otp3_txt.setOnKeyListener(new View.OnKeyListener() {


            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    if (otp3_txt.getText().length() >=1) {
                        otp4_txt.requestFocus();
                    }
                    if (i == KeyEvent.KEYCODE_DEL || i == KeyEvent.ACTION_DOWN) {
                        //this is for backspace
                        otp2_txt.requestFocus();
                    } else {

                    }
                }
                return false;
            }
        });

        otp4_txt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if (keyCode == KeyEvent.KEYCODE_DEL || keyCode == KeyEvent.ACTION_DOWN) {
                    otp3_txt.requestFocus();
                }
                return false;
            }
        });



    }

}
