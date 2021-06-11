package com.example.rootbeer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static TextView rootcheck;
    private String[] binaryPaths ={ "/data/local/",
            "/data/local/bin/",
            "/data/local/xbin/",
            "/sbin/",
            "/su/bin/",
            "/system/bin/",
            "/system/bin/.ext/",
            "/system/bin/failsafe/",
            "/system/sd/xbin/",
            "/system/usr/we-need-root/",
            "/system/xbin/",
            "/system/app/Superuser.apk",
            "/cache",
            "/data",
            "/dev"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootcheck = findViewById(R.id.rootcheck);
        checkForBinary("busybox");
        //String commandToExecute = "su";
        // executeShellCommand(commandToExecute);
    }

    // private void executeShellCommand(String commandToExecute) {
    //  Process process = null;
    //  try {
    //    process = Runtime.getRuntime().exec(commandToExecute);
    ///    rootcheck.setText("it is a rooted device");
    //} catch (Exception e) {
    //  rootcheck.setText("it is not rooted device");
    //  } finally {
    //  if (process != null) {
    //      try {
    //     process.destroy();
    //  } catch (Exception e) { }
    //  }
    //

   // private boolean checkForBusyBoxBinary() {
      //  return checkForBinary("busybox");//function is available below
    //}

    private void checkForBinary(String busybox) {
        for (String path : binaryPaths) {
            File f = new File(path, busybox);
            boolean fileExists = f.exists();
            if (fileExists) {
                rootcheck.setText("it is a rooted device");
            } else {
                rootcheck.setText("it is not a rooted device");
            }

        }
    }
}


   