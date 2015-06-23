package de.blinkt.fixwearscreenshot;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.io.FileNotFoundException;

/**
 * Created by arne on 23.06.15.
 */
public class FixScreenShotActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent !=null) {
            Toast.makeText(this, R.string.fix_toast, Toast.LENGTH_LONG).show();
            Bundle extras = intent.getExtras();



            // Try something very fishy, just change mime type and rethrow!
            Intent sendPng = new Intent(Intent.ACTION_SEND);
            sendPng.setType("image/png");

            sendPng.putExtras(extras);

            startActivityForResult(sendPng, 777);
        } else {
            Toast.makeText(this, "Screenshotfixer: NO DATA! :(", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
    }
}
