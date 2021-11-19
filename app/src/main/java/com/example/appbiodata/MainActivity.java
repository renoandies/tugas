package com.example.appbiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button phone, alamat, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ---------[ NO ACTION BAR ]-------------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        alamat      = findViewById(R.id.btn_alamat);
        phone       = findViewById(R.id.btn_noTelp);
        email       = findViewById(R.id.btn_email);
    }

    // ----------[ INTENT TO ADDRESS ]------------
    public void alamat(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:-7.729943, 110.004248"));
        Intent chooser = Intent.createChooser(intent, "Launch maps");
        startActivity(chooser);
    }
    public void telepon(View view) {
        String phoneNumber  = "082234675500";
        Intent phoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        startActivity(phoneIntent);
    }
    public void email(View view) {
        Uri emailUri        = Uri.parse("reno.andies.p07@gmail.com");
        Intent emailIntent  = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + emailUri));
        startActivity(emailIntent);
    }
}