package com.upcusc.intrams;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.Date;
import javax.annotation.Nullable;

public class ScheduleActivity extends AppCompatActivity {
    public static Resources res;
    /* access modifiers changed from: private */
    public ELVASchedule elaSched;
    /* access modifiers changed from: private */
    public ExpandableListView elv;
    boolean init = true;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_events /*2131230849*/:
                    ScheduleActivity.this.events(null);
                    return true;
                case R.id.navigation_results /*2131230851*/:
                    ScheduleActivity.this.home(null);
                    return true;
                case R.id.navigation_schedule /*2131230852*/:
                    return true;
                case R.id.navigation_sponsors /*2131230853*/:
                    ScheduleActivity.this.sponsors(null);
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

    public void events(View view) {
        startActivity(new Intent(this, EventActivity.class));
        overridePendingTransition(0, 0);
        finish();
    }

    public void sponsors(View view) {
        startActivity(new Intent(this, SponsorActivity.class));
        overridePendingTransition(0, 0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_schedule);
        this.elv = (ExpandableListView) findViewById(R.id.sched);
        res = getResources();
        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
        this.elaSched = new ELVASchedule(this);
        this.elv.setAdapter(this.elaSched);
        setTitle("Schedule of Games");
        FirebaseFirestore.getInstance().collection("bad001").addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(@Nullable QuerySnapshot querySnapshot, @Nullable FirebaseFirestoreException firebaseFirestoreException) {
                if (firebaseFirestoreException != null) {
                    Log.w("", "Listen failed.", firebaseFirestoreException);
                    return;
                }
                ScheduleActivity scheduleActivity = ScheduleActivity.this;
                scheduleActivity.elaSched = new ELVASchedule(scheduleActivity);
                ScheduleActivity.this.elv.setAdapter(ScheduleActivity.this.elaSched);
                Date date = new Date();
                if (date.getDay() == 3) {
                    ScheduleActivity.this.elv.expandGroup(0, false);
                } else if (date.getDay() == 4) {
                    ScheduleActivity.this.elv.expandGroup(1, false);
                } else if (date.getDay() == 5) {
                    ScheduleActivity.this.elv.expandGroup(2, false);
                } else if (date.getDay() == 6) {
                    ScheduleActivity.this.elv.expandGroup(3, false);
                } else {
                    for (int i = 0; i < 4; i++) {
                        ScheduleActivity.this.elv.expandGroup(i, true);
                    }
                }
                if (ScheduleActivity.this.init) {
                    ScheduleActivity scheduleActivity2 = ScheduleActivity.this;
                    scheduleActivity2.init = false;
                    Toast.makeText(scheduleActivity2.getApplicationContext(), "Click on the date to hide schedule", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
