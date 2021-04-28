package com.example.onlinevotingsystem.firebase;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SendOtpToMobile {

    public interface SendOtpInterface{
        void onOtpSent(boolean result, boolean otpAutoVerified, boolean autoVerifiedResult);
    }

    public SendOtpToMobile(String mobileNumber, Activity activity, SendOtpInterface otpInterface){
        PhoneAuthProvider.OnVerificationStateChangedCallbacks callback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                otpInterface.onOtpSent(true,true,true);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                otpInterface.onOtpSent(true,true,false);
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                otpInterface.onOtpSent(true,false,false);
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
            }
        };

        PhoneAuthOptions options=PhoneAuthOptions.newBuilder()
                .setPhoneNumber(mobileNumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(activity)
                .setCallbacks(callback)
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

}
