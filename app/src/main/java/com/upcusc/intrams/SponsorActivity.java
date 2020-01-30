package com.upcusc.intrams;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SponsorActivity extends AppCompatActivity {
    public static Resources res;
    private ELVASchedule elaSched;
    private ExpandableListView elv;
    boolean init = true;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_events /*2131230849*/:
                    SponsorActivity.this.events(null);
                    return true;
                case R.id.navigation_results /*2131230851*/:
                    SponsorActivity.this.home(null);
                    return true;
                case R.id.navigation_schedule /*2131230852*/:
                    SponsorActivity.this.dashboard(null);
                    return true;
                case R.id.navigation_sponsors /*2131230853*/:
                    return true;
                default:
                    return false;
            }
        }
    };

    public void home(View view) {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(0, 0);
        finish();
    }

    public void dashboard(View view) {
        startActivity(new Intent(this, ScheduleActivity.class));
        overridePendingTransition(0, 0);
        finish();
    }

    public void events(View view) {
        startActivity(new Intent(this, EventActivity.class));
        overridePendingTransition(0, 0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sponsors);
        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
        setTitle("Sponsors");
        setScaledImage((ImageView) findViewById(R.id.ivUpcusc), R.drawable.upsusc);
        setScaledImage((ImageView) findViewById(R.id.ivUP), R.drawable.up);
        setScaledImage((ImageView) findViewById(R.id.ivFoodpanda), R.drawable.foodpanda);
        setScaledImage((ImageView) findViewById(R.id.ivSelecta), R.drawable.selecta);
        setScaledImage((ImageView) findViewById(R.id.ivVirginia), R.drawable.virginia);
        setScaledImage((ImageView) findViewById(R.id.ivSenoritas), R.drawable.senorita);
        setScaledImage((ImageView) findViewById(R.id.ivBodysole), R.drawable.bodyandsole);
    }

    private void setScaledImage(final ImageView imageView, final int i) {
        imageView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = imageView.getMeasuredHeight();
                imageView.setImageBitmap(SponsorActivity.decodeSampledBitmapFromResource(SponsorActivity.this.getResources(), i, imageView.getMeasuredWidth(), measuredHeight));
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i, int i2, int i3) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    private static int calculateInSampleSize(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
