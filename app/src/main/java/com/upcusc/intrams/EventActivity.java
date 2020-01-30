package com.upcusc.intrams;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import javax.annotation.Nullable;

public class EventActivity extends AppCompatActivity {
    public static Resources res;
    /* access modifiers changed from: private */
    public ELVAEvents elaEvents;
    /* access modifiers changed from: private */
    public ExpandableListView elv;
    boolean init = true;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_events /*2131230849*/:
                    return true;
                case R.id.navigation_results /*2131230851*/:
                    EventActivity.this.home(null);
                    return true;
                case R.id.navigation_schedule /*2131230852*/:
                    EventActivity.this.schedule(null);
                    return true;
                case R.id.navigation_sponsors /*2131230853*/:
                    EventActivity.this.sponsors(null);
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

    public void schedule(View view) {
        startActivity(new Intent(this, ScheduleActivity.class));
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
        setContentView((int) R.layout.activity_games);
        this.elv = (ExpandableListView) findViewById(R.id.games);
        res = getResources();
        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
        this.elaEvents = new ELVAEvents(this);
        this.elv.setAdapter(this.elaEvents);
        setTitle("Activities Scoresheet");
        FirebaseFirestore.getInstance().collection("bad001").addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(@Nullable QuerySnapshot querySnapshot, @Nullable FirebaseFirestoreException firebaseFirestoreException) {
                if (firebaseFirestoreException != null) {
                    Log.w("", "Listen failed.", firebaseFirestoreException);
                    return;
                }
                EventActivity eventActivity = EventActivity.this;
                eventActivity.elaEvents = new ELVAEvents(eventActivity);
                EventActivity.this.elv.setAdapter(EventActivity.this.elaEvents);
                if (EventActivity.this.init) {
                    EventActivity eventActivity2 = EventActivity.this;
                    eventActivity2.init = false;
                    Toast.makeText(eventActivity2.getApplicationContext(), "Click on the game to view scores", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
