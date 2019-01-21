package numan.superboxdriver;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

import numan.superboxdriver.Maps.MapsActivity;

import static android.Manifest.permission.CALL_PHONE;

/**
 * Created by noman on 12/26/2016.
 */

public class DetailInfo extends AppCompatActivity {

    TextView title, minutes, messages, internet, rate, dial, desc;
    ImageView image;
    Cursor res;
    public final int RequestPermissionCode = 1000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_info);

        image = (ImageView)findViewById(R.id.image);
        title = (TextView)findViewById(R.id.title);
        minutes = (TextView)findViewById(R.id.minutes);
        messages = (TextView)findViewById(R.id.messages);
        internet = (TextView)findViewById(R.id.internet);
        rate = (TextView)findViewById(R.id.rate);
        dial = (TextView)findViewById(R.id.dial);
        desc = (TextView)findViewById(R.id.desc);

    }

    private void getIcon(String string) {
        String uri;
        int imageResource;
        Drawable res;
        switch(string)
        {

            case "Ufone":
                uri = "@drawable/ufone1";  // where myresource (without the extension) is the file
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                image.setImageDrawable(res);
                break;
            case "JAZZ":
                uri = "@drawable/mobilink";  // where myresource (without the extension) is the file
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                image.setImageDrawable(res);
                break;
            case "ZONG":
                uri = "@drawable/zong";  // where myresource (without the extension) is the file
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                image.setImageDrawable(res);
                break;
            case "Warid":
                uri = "@drawable/warid";  // where myresource (without the extension) is the file
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                image.setImageDrawable(res);
                break;
            case "Telenor":
                uri = "@drawable/telenor";  // where myresource (without the extension) is the file
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                image.setImageDrawable(res);
                break;
            default:
                uri = "@drawable/ufone1";  // where myresource (without the extension) is the file
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                image.setImageDrawable(res);
        }
    }

    public void makeCall(View v) {

        try {
            if (CheckingPermissionIsEnabledOrNot()) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
//        callIntent.setData(Uri.parse("tel:03461414728"));
                callIntent.setData(Uri.parse("tel:0527054445"));
//        callIntent.setData(Uri.parse("tel:" + res.getString(4) + Uri.encode("#")));
                if (ActivityCompat.checkSelfPermission(this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Call Not Allowed by OS", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(callIntent);
            } else
                RequestMultiplePermission();
        } catch (Exception ex) {
            Log.e("Call Exception" , ex + "");
        }


    }

    public void whatsApp(View v)
    {
        PackageManager packageManager = this.getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);
        try {
            String url = "https://api.whatsapp.com/send?phone=" + "+971527054445" + "&text=" + URLEncoder.encode("*SBox Contact*\nHello Sir/Madam\nI am coming to your Location, Now I'm on my way.", "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                this.startActivity(i);
            }
        } catch (Exception ex) {
            Log.e("whatsApp Exception" , ex + "");
        }
    }

    public void openMap(View v)
    {
        try {
            Intent intent = new Intent(this, MapsActivity.class);
            intent.putExtra("Lat", "25.142720");
            intent.putExtra("Long", "56.348339");
            intent.putExtra("Name", "Ahmed");
            startActivity(intent);
        } catch (Exception ex) {
            Log.e("Maps Exception" , ex + "");
        }
    }

    public void completeOrder(View v)
    {
        Toast.makeText(this, "Order Completed !", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Good Work, Go to Next Location Please !", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    public boolean CheckingPermissionIsEnabledOrNot() {

        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE);
        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED ;

    }

    private void RequestMultiplePermission() {

        // Creating String Array with Permissions.
        ActivityCompat.requestPermissions(DetailInfo.this, new String[]
                {
                        CALL_PHONE
                }, RequestPermissionCode);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case RequestPermissionCode:

                if (grantResults.length > 0) {

                    boolean PhoneCallPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    if (PhoneCallPermission) {
                        makeCall(null);
                        Toast.makeText(DetailInfo.this, "Permission Granted", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(DetailInfo.this,"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
}
