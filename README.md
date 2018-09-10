# AndroidOTP

A clean, easy-to-use otp view for Android.

This library allows you to implement a otp view mechanism in your app easily and quickly.With automatic message sms otp reading facility.

The AndroidOTP Verification  makes verifying phone numbers easy.This library supports the verification of phone numbers via SMS very easily.

# Getting started

# Maven

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
 # Gradle
  
  dependencies {
	        implementation 'com.github.SURAJ2600:AndroidOTP:v1.01'
	}
	
# Usage

Add this to your layout file.

        <androidmasterminds.com.androidotp.PINVIEW
            android:id="@+id/pinviews"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"></androidmasterminds.com.androidotp.PINVIEW>
	 
	 
Add this in your activity.



 @BindView(R.id.pinviews)
    PINVIEW pinviews;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        ButterKnife.bind(this);

        pinviews.SetPinType(2);
       String pin= pinviews.GetPinNumber();
       
       
 You can also set the pin view type using pinviews.SetPinType();
 
 1 --->  text,
 2 ---> password,
 3----> number
 
 
 ![alt text](https://lh3.googleusercontent.com/-dfeyVnJO1d4/W5ZB3ku6DBI/AAAAAAAABNM/-l-Pak2oIokMaKIi_dp3_-tKsIuguQOVwCL0BGAYYCw/h1920/2018-09-10.png)
 
 
 ![alt text](https://lh3.googleusercontent.com/-zuA75sTbn30/W5ZB1joXnjI/AAAAAAAABNI/7K373UxmHfkEG029r_krQOZdXHTeqnbzQCL0BGAYYCw/h1920/2018-09-10.png)
 
 
 
 
 
        
        

