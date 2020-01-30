package com.upcusc.intrams;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.upcusc.intrams.Games.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<College> colleges;
    public static List<Game> games;
    public static int height;
    /* access modifiers changed from: private */
    public static List<College> pseudoCollege;
    public static Resources res;
    public static int width;
    public ELVAResults adapter;
    /* access modifiers changed from: private */
    public ExpandableListView elv;
    boolean init = false;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            Log.i("", "Ive been here");
            switch (menuItem.getItemId()) {
                case R.id.navigation_events /*2131230849*/:
                    MainActivity.this.events(null);
                    return true;
                case R.id.navigation_results /*2131230851*/:
                    return true;
                case R.id.navigation_schedule /*2131230852*/:
                    MainActivity.this.dashboard(null);
                    return true;
                case R.id.navigation_sponsors /*2131230853*/:
                    MainActivity.this.sponsors(null);
                    return true;
                default:
                    return false;
            }
        }
    };
    private TextView mTextMessage;

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

    public void sponsors(View view) {
        startActivity(new Intent(this, SponsorActivity.class));
        overridePendingTransition(0, 0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.elv = findViewById(R.id.lvExp);
        setTitle("UP Cebu Intramurals 2019");
        res = getResources();
        this.mTextMessage = (TextView) findViewById(R.id.message);
        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
        colleges = new ArrayList();
        games = new ArrayList();
        pseudoCollege = new ArrayList();
        College college = new College("CCAD", "Tyrell", "College of Communication, Art, and Design");
        College college2 = new College("COS", "Baratheon", "College of Science");
        College college3 = new College("CSS", "Targaryen", "College of Social Sciences");
        College college4 = new College("SOM", "Arryn", "School of Management");
        colleges.add(college);
        colleges.add(college2);
        colleges.add(college3);
        colleges.add(college4);
        College college5 = new College("W", null, null);
        College college6 = new College("W1", null, null);
        College college7 = new College("L", null, null);
        College college8 = new College("L1", null, null);
        pseudoCollege.add(college5);
        pseudoCollege.add(college6);
        pseudoCollege.add(college7);
        pseudoCollege.add(college8);
        for (College college9 : colleges) {
            BadmintonMen badmintonMen = new BadmintonMen(null, null, null, 0, 0, 0, 0);
            college9.addGame(badmintonMen);
            BadmintonWomen badmintonWomen = new BadmintonWomen(null, null, null, 0, 0, 0, 0);
            college9.addGame(badmintonWomen);
            BasketballMen basketballMen = new BasketballMen(null, null, null, 0, 0, 0, 0);
            college9.addGame(basketballMen);
            BasketballWomen basketballWomen = new BasketballWomen(null, null, null, 0, 0, 0, 0);
            college9.addGame(basketballWomen);
            Frisbee frisbee = new Frisbee(null, null, null, 0, 0, 0, 0);
            college9.addGame(frisbee);
            Softball softball = new Softball(null, null, null, 0, 0, 0, 0);
            college9.addGame(softball);
            SoccerMen soccerMen = new SoccerMen(null, null, null, 0, 0, 0, 0);
            college9.addGame(soccerMen);
            SoccerWomen soccerWomen = new SoccerWomen(null, null, null, 0, 0, 0, 0);
            college9.addGame(soccerWomen);
            TableTennisMen tableTennisMen = new TableTennisMen(null, null, null, 0, 0, 0, 0);
            college9.addGame(tableTennisMen);
            TableTennisWomen tableTennisWomen = new TableTennisWomen(null, null, null, 0, 0, 0, 0);
            college9.addGame(tableTennisWomen);
            TableTennisMixed tableTennisMixed = new TableTennisMixed(null, null, null, 0, 0, 0, 0);
            college9.addGame(tableTennisMixed);
            VolleyballMen volleyballMen = new VolleyballMen(null, null, null, 0, 0, 0, 0);
            college9.addGame(volleyballMen);
            VolleyballWomen volleyballWomen = new VolleyballWomen(null, null, null, 0, 0, 0, 0);
            college9.addGame(volleyballWomen);
            Chess chess = new Chess(null, null, null, 0, 0, 0, 0);
            college9.addGame(chess);
            Scrabble scrabble = new Scrabble(null, 0, 0, 0, 0);
            college9.addGame(scrabble);
            Zumba zumba = new Zumba(null, 0, 0, 0, 0);
            college9.addGame(zumba);
            Rubiks rubiks = new Rubiks(null, 0, 0, 0, 0);
            college9.addGame(rubiks);
            DanceFusion danceFusion = new DanceFusion(null, 0, 0, 0, 0);
            college9.addGame(danceFusion);
            DanceSport danceSport = new DanceSport(null, 0, 0, 0, 0);
            college9.addGame(danceSport);
            FieldDemo fieldDemo = new FieldDemo(null, 0, 0, 0, 0);
            college9.addGame(fieldDemo);
            LarongPinoy larongPinoy = new LarongPinoy(null, 0, 0, 0, 0);
            college9.addGame(larongPinoy);
            MrMsFitness mrMsFitness = new MrMsFitness(null, 0, 0, 0, 0);
            college9.addGame(mrMsFitness);
            Parade parade = new Parade(null, 0, 0, 0, 0);
            college9.addGame(parade);
        }
        for (College college10 : pseudoCollege) {
            BadmintonMen badmintonMen2 = new BadmintonMen(null, null, null, 0, 0, 0, 0);
            college10.addGame(badmintonMen2);
            BadmintonWomen badmintonWomen2 = new BadmintonWomen(null, null, null, 0, 0, 0, 0);
            college10.addGame(badmintonWomen2);
            BasketballMen basketballMen2 = new BasketballMen(null, null, null, 0, 0, 0, 0);
            college10.addGame(basketballMen2);
            BasketballWomen basketballWomen2 = new BasketballWomen(null, null, null, 0, 0, 0, 0);
            college10.addGame(basketballWomen2);
            Frisbee frisbee2 = new Frisbee(null, null, null, 0, 0, 0, 0);
            college10.addGame(frisbee2);
            Softball softball2 = new Softball(null, null, null, 0, 0, 0, 0);
            college10.addGame(softball2);
            SoccerMen soccerMen2 = new SoccerMen(null, null, null, 0, 0, 0, 0);
            college10.addGame(soccerMen2);
            SoccerWomen soccerWomen2 = new SoccerWomen(null, null, null, 0, 0, 0, 0);
            college10.addGame(soccerWomen2);
            TableTennisMen tableTennisMen2 = new TableTennisMen(null, null, null, 0, 0, 0, 0);
            college10.addGame(tableTennisMen2);
            TableTennisWomen tableTennisWomen2 = new TableTennisWomen(null, null, null, 0, 0, 0, 0);
            college10.addGame(tableTennisWomen2);
            VolleyballMen volleyballMen2 = new VolleyballMen(null, null, null, 0, 0, 0, 0);
            college10.addGame(volleyballMen2);
            VolleyballWomen volleyballWomen2 = new VolleyballWomen(null, null, null, 0, 0, 0, 0);
            college10.addGame(volleyballWomen2);
            Chess chess2 = new Chess(null, null, null, 0, 0, 0, 0);
            college10.addGame(chess2);
            Scrabble scrabble2 = new Scrabble(null, 0, 0, 0, 0);
            college10.addGame(scrabble2);
            Zumba zumba2 = new Zumba(null, 0, 0, 0, 0);
            college10.addGame(zumba2);
            Rubiks rubiks2 = new Rubiks(null, 0, 0, 0, 0);
            college10.addGame(rubiks2);
            DanceFusion danceFusion2 = new DanceFusion(null, 0, 0, 0, 0);
            college10.addGame(danceFusion2);
            DanceSport danceSport2 = new DanceSport(null, 0, 0, 0, 0);
            college10.addGame(danceSport2);
            FieldDemo fieldDemo2 = new FieldDemo(null, 0, 0, 0, 0);
            college10.addGame(fieldDemo2);
            LarongPinoy larongPinoy2 = new LarongPinoy(null, 0, 0, 0, 0);
            college10.addGame(larongPinoy2);
            MrMsFitness mrMsFitness2 = new MrMsFitness(null, 0, 0, 0, 0);
            college10.addGame(mrMsFitness2);
            Parade parade2 = new Parade(null, 0, 0, 0, 0);
            college10.addGame(parade2);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        FirebaseFirestore.getInstance().collection("bad001").addSnapshotListener(new EventListener<QuerySnapshot>() {
            /* JADX WARNING: type inference failed for: r3v1, types: [com.upcusc.jdserato.upcintrams.Game, java.lang.Object] */
            /* JADX WARNING: type inference failed for: r9v14, types: [com.upcusc.jdserato.upcintrams.Games.BadmintonMen] */
            /* JADX WARNING: type inference failed for: r9v19, types: [com.upcusc.jdserato.upcintrams.Games.BadmintonMen] */
            /* JADX WARNING: type inference failed for: r7v2 */
            /* JADX WARNING: type inference failed for: r3v4 */
            /* JADX WARNING: type inference failed for: r9v24, types: [com.upcusc.jdserato.upcintrams.Games.BadmintonWomen] */
            /* JADX WARNING: type inference failed for: r9v29, types: [com.upcusc.jdserato.upcintrams.Games.BadmintonWomen] */
            /* JADX WARNING: type inference failed for: r3v5 */
            /* JADX WARNING: type inference failed for: r9v30, types: [com.upcusc.jdserato.upcintrams.Games.BasketballMen] */
            /* JADX WARNING: type inference failed for: r9v31, types: [com.upcusc.jdserato.upcintrams.Games.BasketballMen] */
            /* JADX WARNING: type inference failed for: r3v8 */
            /* JADX WARNING: type inference failed for: r9v32, types: [com.upcusc.jdserato.upcintrams.Games.BasketballWomen] */
            /* JADX WARNING: type inference failed for: r9v33, types: [com.upcusc.jdserato.upcintrams.Games.BasketballWomen] */
            /* JADX WARNING: type inference failed for: r9v38, types: [com.upcusc.jdserato.upcintrams.Games.Frisbee] */
            /* JADX WARNING: type inference failed for: r9v39, types: [com.upcusc.jdserato.upcintrams.Games.Frisbee] */
            /* JADX WARNING: type inference failed for: r3v13 */
            /* JADX WARNING: type inference failed for: r9v40, types: [com.upcusc.jdserato.upcintrams.Games.Softball] */
            /* JADX WARNING: type inference failed for: r9v41, types: [com.upcusc.jdserato.upcintrams.Games.Softball] */
            /* JADX WARNING: type inference failed for: r3v17 */
            /* JADX WARNING: type inference failed for: r9v42, types: [com.upcusc.jdserato.upcintrams.Games.SoccerMen] */
            /* JADX WARNING: type inference failed for: r9v43, types: [com.upcusc.jdserato.upcintrams.Games.SoccerMen] */
            /* JADX WARNING: type inference failed for: r3v21 */
            /* JADX WARNING: type inference failed for: r9v44, types: [com.upcusc.jdserato.upcintrams.Games.SoccerWomen] */
            /* JADX WARNING: type inference failed for: r9v45, types: [com.upcusc.jdserato.upcintrams.Games.SoccerWomen] */
            /* JADX WARNING: type inference failed for: r3v24 */
            /* JADX WARNING: type inference failed for: r9v46, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisMen] */
            /* JADX WARNING: type inference failed for: r9v47, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisMen] */
            /* JADX WARNING: type inference failed for: r3v27 */
            /* JADX WARNING: type inference failed for: r9v48, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisWomen] */
            /* JADX WARNING: type inference failed for: r9v49, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisWomen] */
            /* JADX WARNING: type inference failed for: r3v30 */
            /* JADX WARNING: type inference failed for: r9v50, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisMixed] */
            /* JADX WARNING: type inference failed for: r9v51, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisMixed] */
            /* JADX WARNING: type inference failed for: r3v33 */
            /* JADX WARNING: type inference failed for: r9v52, types: [com.upcusc.jdserato.upcintrams.Games.VolleyballMen] */
            /* JADX WARNING: type inference failed for: r9v53, types: [com.upcusc.jdserato.upcintrams.Games.VolleyballMen] */
            /* JADX WARNING: type inference failed for: r3v36 */
            /* JADX WARNING: type inference failed for: r9v54, types: [com.upcusc.jdserato.upcintrams.Games.VolleyballWomen] */
            /* JADX WARNING: type inference failed for: r9v55, types: [com.upcusc.jdserato.upcintrams.Games.VolleyballWomen] */
            /* JADX WARNING: type inference failed for: r3v39 */
            /* JADX WARNING: type inference failed for: r9v56, types: [com.upcusc.jdserato.upcintrams.Games.Chess] */
            /* JADX WARNING: type inference failed for: r9v57, types: [com.upcusc.jdserato.upcintrams.Games.Chess] */
            /* JADX WARNING: type inference failed for: r15v29, types: [com.upcusc.jdserato.upcintrams.Games.Scrabble] */
            /* JADX WARNING: type inference failed for: r15v30, types: [com.upcusc.jdserato.upcintrams.Games.Zumba] */
            /* JADX WARNING: type inference failed for: r15v31, types: [com.upcusc.jdserato.upcintrams.Games.Rubiks] */
            /* JADX WARNING: type inference failed for: r15v32, types: [com.upcusc.jdserato.upcintrams.Games.DanceFusion] */
            /* JADX WARNING: type inference failed for: r15v33, types: [com.upcusc.jdserato.upcintrams.Games.DanceSport] */
            /* JADX WARNING: type inference failed for: r15v34, types: [com.upcusc.jdserato.upcintrams.Games.FieldDemo] */
            /* JADX WARNING: type inference failed for: r15v35, types: [com.upcusc.jdserato.upcintrams.Games.LarongPinoy] */
            /* JADX WARNING: type inference failed for: r15v36, types: [com.upcusc.jdserato.upcintrams.Games.MrMsFitness] */
            /* JADX WARNING: type inference failed for: r15v37, types: [com.upcusc.jdserato.upcintrams.Games.Parade] */
            /* JADX WARNING: type inference failed for: r3v51 */
            /* JADX WARNING: type inference failed for: r9v90, types: [com.upcusc.jdserato.upcintrams.Games.BadmintonMen] */
            /* JADX WARNING: type inference failed for: r9v91, types: [com.upcusc.jdserato.upcintrams.Games.BadmintonMen] */
            /* JADX WARNING: type inference failed for: r9v92, types: [com.upcusc.jdserato.upcintrams.Games.BadmintonWomen] */
            /* JADX WARNING: type inference failed for: r9v93, types: [com.upcusc.jdserato.upcintrams.Games.BadmintonWomen] */
            /* JADX WARNING: type inference failed for: r3v54 */
            /* JADX WARNING: type inference failed for: r9v94, types: [com.upcusc.jdserato.upcintrams.Games.BasketballMen] */
            /* JADX WARNING: type inference failed for: r9v95, types: [com.upcusc.jdserato.upcintrams.Games.BasketballMen] */
            /* JADX WARNING: type inference failed for: r3v55 */
            /* JADX WARNING: type inference failed for: r9v96, types: [com.upcusc.jdserato.upcintrams.Games.BasketballWomen] */
            /* JADX WARNING: type inference failed for: r9v97, types: [com.upcusc.jdserato.upcintrams.Games.BasketballWomen] */
            /* JADX WARNING: type inference failed for: r9v98, types: [com.upcusc.jdserato.upcintrams.Games.Frisbee] */
            /* JADX WARNING: type inference failed for: r9v99, types: [com.upcusc.jdserato.upcintrams.Games.Frisbee] */
            /* JADX WARNING: type inference failed for: r3v56 */
            /* JADX WARNING: type inference failed for: r9v100, types: [com.upcusc.jdserato.upcintrams.Games.Softball] */
            /* JADX WARNING: type inference failed for: r9v101, types: [com.upcusc.jdserato.upcintrams.Games.Softball] */
            /* JADX WARNING: type inference failed for: r3v57 */
            /* JADX WARNING: type inference failed for: r9v102, types: [com.upcusc.jdserato.upcintrams.Games.SoccerMen] */
            /* JADX WARNING: type inference failed for: r9v103, types: [com.upcusc.jdserato.upcintrams.Games.SoccerMen] */
            /* JADX WARNING: type inference failed for: r3v58 */
            /* JADX WARNING: type inference failed for: r9v104, types: [com.upcusc.jdserato.upcintrams.Games.SoccerWomen] */
            /* JADX WARNING: type inference failed for: r9v105, types: [com.upcusc.jdserato.upcintrams.Games.SoccerWomen] */
            /* JADX WARNING: type inference failed for: r3v59 */
            /* JADX WARNING: type inference failed for: r9v106, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisMen] */
            /* JADX WARNING: type inference failed for: r9v107, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisMen] */
            /* JADX WARNING: type inference failed for: r3v60 */
            /* JADX WARNING: type inference failed for: r9v108, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisWomen] */
            /* JADX WARNING: type inference failed for: r9v109, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisWomen] */
            /* JADX WARNING: type inference failed for: r3v61 */
            /* JADX WARNING: type inference failed for: r9v110, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisMixed] */
            /* JADX WARNING: type inference failed for: r9v111, types: [com.upcusc.jdserato.upcintrams.Games.TableTennisMixed] */
            /* JADX WARNING: type inference failed for: r3v62 */
            /* JADX WARNING: type inference failed for: r9v112, types: [com.upcusc.jdserato.upcintrams.Games.VolleyballMen] */
            /* JADX WARNING: type inference failed for: r9v113, types: [com.upcusc.jdserato.upcintrams.Games.VolleyballMen] */
            /* JADX WARNING: type inference failed for: r3v63 */
            /* JADX WARNING: type inference failed for: r9v114, types: [com.upcusc.jdserato.upcintrams.Games.VolleyballWomen] */
            /* JADX WARNING: type inference failed for: r9v115, types: [com.upcusc.jdserato.upcintrams.Games.VolleyballWomen] */
            /* JADX WARNING: type inference failed for: r3v64 */
            /* JADX WARNING: type inference failed for: r9v116, types: [com.upcusc.jdserato.upcintrams.Games.Chess] */
            /* JADX WARNING: type inference failed for: r9v117, types: [com.upcusc.jdserato.upcintrams.Games.Chess] */
            /* JADX WARNING: type inference failed for: r15v38, types: [com.upcusc.jdserato.upcintrams.Games.Scrabble] */
            /* JADX WARNING: type inference failed for: r15v39, types: [com.upcusc.jdserato.upcintrams.Games.Zumba] */
            /* JADX WARNING: type inference failed for: r15v40, types: [com.upcusc.jdserato.upcintrams.Games.Rubiks] */
            /* JADX WARNING: type inference failed for: r15v41, types: [com.upcusc.jdserato.upcintrams.Games.DanceFusion] */
            /* JADX WARNING: type inference failed for: r15v42, types: [com.upcusc.jdserato.upcintrams.Games.DanceSport] */
            /* JADX WARNING: type inference failed for: r15v43, types: [com.upcusc.jdserato.upcintrams.Games.FieldDemo] */
            /* JADX WARNING: type inference failed for: r15v44, types: [com.upcusc.jdserato.upcintrams.Games.LarongPinoy] */
            /* JADX WARNING: type inference failed for: r15v45, types: [com.upcusc.jdserato.upcintrams.Games.MrMsFitness] */
            /* JADX WARNING: type inference failed for: r15v46, types: [com.upcusc.jdserato.upcintrams.Games.Parade] */
            /* JADX WARNING: type inference failed for: r3v65 */
            /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v4
              assigns: [?[OBJECT, ARRAY], com.upcusc.jdserato.upcintrams.Games.BadmintonMen, com.upcusc.jdserato.upcintrams.Games.Frisbee, com.upcusc.jdserato.upcintrams.Games.Scrabble, com.upcusc.jdserato.upcintrams.Games.Zumba, com.upcusc.jdserato.upcintrams.Games.Rubiks, com.upcusc.jdserato.upcintrams.Games.DanceFusion, com.upcusc.jdserato.upcintrams.Games.DanceSport, com.upcusc.jdserato.upcintrams.Games.FieldDemo, com.upcusc.jdserato.upcintrams.Games.LarongPinoy, com.upcusc.jdserato.upcintrams.Games.MrMsFitness, com.upcusc.jdserato.upcintrams.Games.Parade]
              uses: [com.upcusc.jdserato.upcintrams.Game, java.lang.Object, com.upcusc.jdserato.upcintrams.Games.BadmintonMen, com.upcusc.jdserato.upcintrams.Games.Frisbee, com.upcusc.jdserato.upcintrams.Games.Scrabble, com.upcusc.jdserato.upcintrams.Games.Zumba, com.upcusc.jdserato.upcintrams.Games.Rubiks, com.upcusc.jdserato.upcintrams.Games.DanceFusion, com.upcusc.jdserato.upcintrams.Games.DanceSport, com.upcusc.jdserato.upcintrams.Games.FieldDemo, com.upcusc.jdserato.upcintrams.Games.LarongPinoy, com.upcusc.jdserato.upcintrams.Games.MrMsFitness, com.upcusc.jdserato.upcintrams.Games.Parade]
              mth insns count: 719
            	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:30)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
            	at jadx.core.ProcessClass.process(ProcessClass.java:35)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
             */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x01b5  */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x01c1  */
            /* JADX WARNING: Removed duplicated region for block: B:108:0x01cd  */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x01d8  */
            /* JADX WARNING: Removed duplicated region for block: B:114:0x01e4  */
            /* JADX WARNING: Removed duplicated region for block: B:117:0x01ef  */
            /* JADX WARNING: Removed duplicated region for block: B:120:0x01fa  */
            /* JADX WARNING: Removed duplicated region for block: B:123:0x0204  */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x020f  */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x021a  */
            /* JADX WARNING: Removed duplicated region for block: B:132:0x0224  */
            /* JADX WARNING: Removed duplicated region for block: B:135:0x022e  */
            /* JADX WARNING: Removed duplicated region for block: B:138:0x0239  */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x0244  */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x0251  */
            /* JADX WARNING: Removed duplicated region for block: B:146:0x0254  */
            /* JADX WARNING: Removed duplicated region for block: B:147:0x025e  */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x0268  */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x0272  */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x027c  */
            /* JADX WARNING: Removed duplicated region for block: B:151:0x0286  */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x0290  */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x029a  */
            /* JADX WARNING: Removed duplicated region for block: B:154:0x02a4  */
            /* JADX WARNING: Removed duplicated region for block: B:155:0x02ae  */
            /* JADX WARNING: Removed duplicated region for block: B:159:0x02f5  */
            /* JADX WARNING: Removed duplicated region for block: B:163:0x033c  */
            /* JADX WARNING: Removed duplicated region for block: B:167:0x0383  */
            /* JADX WARNING: Removed duplicated region for block: B:171:0x03ca  */
            /* JADX WARNING: Removed duplicated region for block: B:175:0x0411  */
            /* JADX WARNING: Removed duplicated region for block: B:179:0x0458  */
            /* JADX WARNING: Removed duplicated region for block: B:184:0x04a3  */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x04ee  */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x0534  */
            /* JADX WARNING: Removed duplicated region for block: B:196:0x057c  */
            /* JADX WARNING: Removed duplicated region for block: B:200:0x05c2  */
            /* JADX WARNING: Removed duplicated region for block: B:204:0x0608  */
            /* JADX WARNING: Removed duplicated region for block: B:208:0x064e  */
            /* JADX WARNING: Removed duplicated region for block: B:213:0x06ad A[ADDED_TO_REGION] */
            /* JADX WARNING: Removed duplicated region for block: B:220:0x06ff A[LOOP:5: B:218:0x06f9->B:220:0x06ff, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x00d8 A[SYNTHETIC, Splitter:B:52:0x00d8] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x0104 A[SYNTHETIC, Splitter:B:64:0x0104] */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x014d  */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x0158  */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x0163  */
            /* JADX WARNING: Removed duplicated region for block: B:84:0x016f  */
            /* JADX WARNING: Removed duplicated region for block: B:87:0x017a  */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0185  */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x0191  */
            /* JADX WARNING: Removed duplicated region for block: B:96:0x019d  */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x01a9  */
            /* JADX WARNING: Unknown variable types count: 50 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onEvent(@javax.annotation.Nullable com.google.firebase.firestore.QuerySnapshot r31, @javax.annotation.Nullable com.google.firebase.firestore.FirebaseFirestoreException r32) {
                Log.d("I", "HEY");
                /*
                    r30 = this;
                    r0 = r30
                    r1 = r32
                    if (r1 == 0) goto L_0x000e
                    java.lang.String r2 = ""
                    java.lang.String r3 = "Listen failed."
                    android.util.Log.w(r2, r3, r1)
                    return
                L_0x000e:
                    java.util.List r1 = r31.getDocumentChanges()
                    java.util.Iterator r1 = r1.iterator()
                L_0x0016:
                    boolean r2 = r1.hasNext()
                    if (r2 == 0) goto L_0x002a
                    java.lang.Object r2 = r1.next()
                    java.lang.String r3 = ""
                    java.lang.String r2 = r2.toString()
                    android.util.Log.i(r3, r2)
                    goto L_0x0016
                L_0x002a:
                    java.io.PrintStream r1 = java.lang.System.out
                    java.lang.String r2 = "I AM LISTENING!"
                    r1.println(r2)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    com.upcusc.jdserato.upcintrams.MainActivity.games = r1
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r1 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.util.Iterator r1 = r1.iterator()
                L_0x003e:
                    boolean r2 = r1.hasNext()
                    if (r2 == 0) goto L_0x004e
                    java.lang.Object r2 = r1.next()
                    com.upcusc.jdserato.upcintrams.College r2 = (com.upcusc.jdserato.upcintrams.College) r2
                    r2.refreshGames()
                    goto L_0x003e
                L_0x004e:
                    java.util.Iterator r1 = r31.iterator()
                L_0x0052:
                    boolean r2 = r1.hasNext()
                    r3 = 1
                    if (r2 == 0) goto L_0x0714
                    java.lang.Object r2 = r1.next()
                    com.google.firebase.firestore.QueryDocumentSnapshot r2 = (com.google.firebase.firestore.QueryDocumentSnapshot) r2
                    java.lang.String r4 = "sport"
                    java.lang.String r4 = r2.getString(r4)
                    java.lang.String r5 = "opp1"
                    java.lang.String r5 = r2.getString(r5)
                    java.lang.String r6 = "opp2"
                    java.lang.String r6 = r2.getString(r6)
                    r7 = 0
                    java.lang.String r8 = "score1"
                    java.lang.Long r8 = r2.getLong(r8)     // Catch:{ NullPointerException -> 0x0089 }
                    int r8 = r8.intValue()     // Catch:{ NullPointerException -> 0x0089 }
                    java.lang.String r9 = "score2"
                    java.lang.Long r9 = r2.getLong(r9)     // Catch:{ NullPointerException -> 0x008a }
                    int r9 = r9.intValue()     // Catch:{ NullPointerException -> 0x008a }
                    r13 = r8
                    r14 = r9
                    goto L_0x008c
                L_0x0089:
                    r8 = 0
                L_0x008a:
                    r13 = r8
                    r14 = 0
                L_0x008c:
                    java.lang.String r8 = "standing3"
                    java.lang.Long r8 = r2.getLong(r8)     // Catch:{ NullPointerException -> 0x00a5 }
                    int r8 = r8.intValue()     // Catch:{ NullPointerException -> 0x00a5 }
                    java.lang.String r9 = "standing4"
                    java.lang.Long r9 = r2.getLong(r9)     // Catch:{ NullPointerException -> 0x00a6 }
                    int r9 = r9.intValue()     // Catch:{ NullPointerException -> 0x00a6 }
                    r19 = r8
                    r20 = r9
                    goto L_0x00aa
                L_0x00a5:
                    r8 = 0
                L_0x00a6:
                    r19 = r8
                    r20 = 0
                L_0x00aa:
                    java.lang.String r8 = "standing1"
                    java.lang.Long r8 = r2.getLong(r8)     // Catch:{ NullPointerException -> 0x00b7 }
                    int r8 = r8.intValue()     // Catch:{ NullPointerException -> 0x00b7 }
                    r17 = r8
                    goto L_0x00b9
                L_0x00b7:
                    r17 = 0
                L_0x00b9:
                    java.lang.String r8 = "standing2"
                    java.lang.Long r8 = r2.getLong(r8)     // Catch:{ NullPointerException -> 0x00c6 }
                    int r8 = r8.intValue()     // Catch:{ NullPointerException -> 0x00c6 }
                    r18 = r8
                    goto L_0x00c8
                L_0x00c6:
                    r18 = 0
                L_0x00c8:
                    java.lang.String r8 = "date"
                    com.google.firebase.Timestamp r2 = r2.getTimestamp(r8)
                    java.util.Date r16 = r2.toDate()
                    r2 = 0
                    r8 = 0
                    r9 = 0
                L_0x00d5:
                    r15 = 4
                    if (r2 >= r15) goto L_0x00fe
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r10 = com.upcusc.jdserato.upcintrams.MainActivity.colleges     // Catch:{ NullPointerException -> 0x00fa }
                    java.lang.Object r10 = r10.get(r2)     // Catch:{ NullPointerException -> 0x00fa }
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10     // Catch:{ NullPointerException -> 0x00fa }
                    java.lang.String r11 = r10.getCollegeName()     // Catch:{ NullPointerException -> 0x00fa }
                    boolean r11 = r5.equals(r11)     // Catch:{ NullPointerException -> 0x00fa }
                    if (r11 == 0) goto L_0x00ec
                    r8 = r2
                    goto L_0x00f7
                L_0x00ec:
                    java.lang.String r10 = r10.getCollegeName()     // Catch:{ NullPointerException -> 0x00fa }
                    boolean r10 = r6.equals(r10)     // Catch:{ NullPointerException -> 0x00fa }
                    if (r10 == 0) goto L_0x00f7
                    r9 = r2
                L_0x00f7:
                    int r2 = r2 + 1
                    goto L_0x00d5
                L_0x00fa:
                    r10 = r9
                    r9 = r8
                    r8 = 0
                    goto L_0x0129
                L_0x00fe:
                    r10 = r9
                    r2 = 0
                    r9 = r8
                    r8 = 0
                L_0x0102:
                    if (r2 >= r15) goto L_0x0129
                    java.util.List r11 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege     // Catch:{ NullPointerException -> 0x0129 }
                    java.lang.Object r11 = r11.get(r2)     // Catch:{ NullPointerException -> 0x0129 }
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11     // Catch:{ NullPointerException -> 0x0129 }
                    java.lang.String r12 = r11.getCollegeName()     // Catch:{ NullPointerException -> 0x0129 }
                    boolean r12 = r5.equals(r12)     // Catch:{ NullPointerException -> 0x0129 }
                    if (r12 == 0) goto L_0x011a
                    r9 = r2
                    r8 = 1
                L_0x011a:
                    java.lang.String r11 = r11.getCollegeName()     // Catch:{ NullPointerException -> 0x0129 }
                    boolean r11 = r6.equals(r11)     // Catch:{ NullPointerException -> 0x0129 }
                    if (r11 == 0) goto L_0x0126
                    r10 = r2
                    r8 = 1
                L_0x0126:
                    int r2 = r2 + 1
                    goto L_0x0102
                L_0x0129:
                    r2 = r9
                    r5 = r10
                    r9 = -1
                    int r10 = r4.hashCode()
                    r21 = 7
                    r22 = 8
                    r11 = 22
                    r12 = 21
                    r23 = 20
                    r24 = 19
                    r25 = 18
                    r26 = 17
                    r27 = 16
                    r28 = 15
                    r29 = 14
                    r6 = 13
                    switch(r10) {
                        case -1976345405: goto L_0x0244;
                        case -1911561087: goto L_0x0239;
                        case -1784272503: goto L_0x022e;
                        case -1567224185: goto L_0x0224;
                        case -1017136004: goto L_0x021a;
                        case -892257368: goto L_0x020f;
                        case -882853973: goto L_0x0204;
                        case -783762785: goto L_0x01fa;
                        case -627759791: goto L_0x01ef;
                        case -350757160: goto L_0x01e4;
                        case -329497206: goto L_0x01d8;
                        case -308316957: goto L_0x01cd;
                        case 65074912: goto L_0x01c1;
                        case 86710321: goto L_0x01b5;
                        case 147631785: goto L_0x01a9;
                        case 401391592: goto L_0x019d;
                        case 407244935: goto L_0x0191;
                        case 552508106: goto L_0x0185;
                        case 1064964524: goto L_0x017a;
                        case 1383348553: goto L_0x016f;
                        case 1573747618: goto L_0x0163;
                        case 1760561147: goto L_0x0158;
                        case 1794379044: goto L_0x014d;
                        default: goto L_0x014b;
                    }
                L_0x014b:
                    goto L_0x024e
                L_0x014d:
                    java.lang.String r10 = "Badminton Women"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 1
                    goto L_0x024e
                L_0x0158:
                    java.lang.String r10 = "Basketball Men"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 2
                    goto L_0x024e
                L_0x0163:
                    java.lang.String r10 = "Volleyball Men"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 11
                    goto L_0x024e
                L_0x016f:
                    java.lang.String r10 = "Softball"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 5
                    goto L_0x024e
                L_0x017a:
                    java.lang.String r10 = "Frisbee"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 4
                    goto L_0x024e
                L_0x0185:
                    java.lang.String r10 = "Volleyball Women"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 12
                    goto L_0x024e
                L_0x0191:
                    java.lang.String r10 = "Dance Sport"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 18
                    goto L_0x024e
                L_0x019d:
                    java.lang.String r10 = "Rubik's Cube"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 16
                    goto L_0x024e
                L_0x01a9:
                    java.lang.String r10 = "Mr Ms Fitness"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 21
                    goto L_0x024e
                L_0x01b5:
                    java.lang.String r10 = "Zumba"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 15
                    goto L_0x024e
                L_0x01c1:
                    java.lang.String r10 = "Chess"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 13
                    goto L_0x024e
                L_0x01cd:
                    java.lang.String r10 = "Basketball Women"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 3
                    goto L_0x024e
                L_0x01d8:
                    java.lang.String r10 = "Larong Pinoy"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 20
                    goto L_0x024e
                L_0x01e4:
                    java.lang.String r10 = "Scrabble"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 14
                    goto L_0x024e
                L_0x01ef:
                    java.lang.String r10 = "Dance Fusion"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 17
                    goto L_0x024e
                L_0x01fa:
                    java.lang.String r10 = "Soccer Men"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 6
                    goto L_0x024e
                L_0x0204:
                    java.lang.String r10 = "Table Tennis Women"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 9
                    goto L_0x024e
                L_0x020f:
                    java.lang.String r10 = "Table Tennis Mixed"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 10
                    goto L_0x024e
                L_0x021a:
                    java.lang.String r10 = "Badminton Men"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 0
                    goto L_0x024e
                L_0x0224:
                    java.lang.String r10 = "Soccer Women"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 7
                    goto L_0x024e
                L_0x022e:
                    java.lang.String r10 = "Field Demo"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 19
                    goto L_0x024e
                L_0x0239:
                    java.lang.String r10 = "Parade"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 22
                    goto L_0x024e
                L_0x0244:
                    java.lang.String r10 = "Table Tennis Men"
                    boolean r10 = r4.equals(r10)
                    if (r10 == 0) goto L_0x024e
                    r9 = 8
                L_0x024e:
                    switch(r9) {
                        case 0: goto L_0x064e;
                        case 1: goto L_0x0608;
                        case 2: goto L_0x05c2;
                        case 3: goto L_0x057c;
                        case 4: goto L_0x0534;
                        case 5: goto L_0x04ee;
                        case 6: goto L_0x04a3;
                        case 7: goto L_0x0458;
                        case 8: goto L_0x0411;
                        case 9: goto L_0x03ca;
                        case 10: goto L_0x0383;
                        case 11: goto L_0x033c;
                        case 12: goto L_0x02f5;
                        case 13: goto L_0x02ae;
                        case 14: goto L_0x02a4;
                        case 15: goto L_0x029a;
                        case 16: goto L_0x0290;
                        case 17: goto L_0x0286;
                        case 18: goto L_0x027c;
                        case 19: goto L_0x0272;
                        case 20: goto L_0x0268;
                        case 21: goto L_0x025e;
                        case 22: goto L_0x0254;
                        default: goto L_0x0251;
                    }
                L_0x0251:
                    r3 = 0
                    goto L_0x0691
                L_0x0254:
                    com.upcusc.jdserato.upcintrams.Games.Parade r3 = new com.upcusc.jdserato.upcintrams.Games.Parade
                    r15 = r3
                    r15.<init>(r16, r17, r18, r19, r20)
                    r7 = 22
                    goto L_0x0691
                L_0x025e:
                    com.upcusc.jdserato.upcintrams.Games.MrMsFitness r3 = new com.upcusc.jdserato.upcintrams.Games.MrMsFitness
                    r15 = r3
                    r15.<init>(r16, r17, r18, r19, r20)
                    r7 = 21
                    goto L_0x0691
                L_0x0268:
                    com.upcusc.jdserato.upcintrams.Games.LarongPinoy r3 = new com.upcusc.jdserato.upcintrams.Games.LarongPinoy
                    r15 = r3
                    r15.<init>(r16, r17, r18, r19, r20)
                    r7 = 20
                    goto L_0x0691
                L_0x0272:
                    com.upcusc.jdserato.upcintrams.Games.FieldDemo r3 = new com.upcusc.jdserato.upcintrams.Games.FieldDemo
                    r15 = r3
                    r15.<init>(r16, r17, r18, r19, r20)
                    r7 = 19
                    goto L_0x0691
                L_0x027c:
                    com.upcusc.jdserato.upcintrams.Games.DanceSport r3 = new com.upcusc.jdserato.upcintrams.Games.DanceSport
                    r15 = r3
                    r15.<init>(r16, r17, r18, r19, r20)
                    r7 = 18
                    goto L_0x0691
                L_0x0286:
                    com.upcusc.jdserato.upcintrams.Games.DanceFusion r3 = new com.upcusc.jdserato.upcintrams.Games.DanceFusion
                    r15 = r3
                    r15.<init>(r16, r17, r18, r19, r20)
                    r7 = 17
                    goto L_0x0691
                L_0x0290:
                    com.upcusc.jdserato.upcintrams.Games.Rubiks r3 = new com.upcusc.jdserato.upcintrams.Games.Rubiks
                    r15 = r3
                    r15.<init>(r16, r17, r18, r19, r20)
                    r7 = 16
                    goto L_0x0691
                L_0x029a:
                    com.upcusc.jdserato.upcintrams.Games.Zumba r3 = new com.upcusc.jdserato.upcintrams.Games.Zumba
                    r15 = r3
                    r15.<init>(r16, r17, r18, r19, r20)
                    r7 = 15
                    goto L_0x0691
                L_0x02a4:
                    com.upcusc.jdserato.upcintrams.Games.Scrabble r3 = new com.upcusc.jdserato.upcintrams.Games.Scrabble
                    r15 = r3
                    r15.<init>(r16, r17, r18, r19, r20)
                    r7 = 14
                    goto L_0x0691
                L_0x02ae:
                    if (r8 == 0) goto L_0x02d3
                    com.upcusc.jdserato.upcintrams.Games.Chess r3 = new com.upcusc.jdserato.upcintrams.Games.Chess
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x02f1
                L_0x02d3:
                    com.upcusc.jdserato.upcintrams.Games.Chess r3 = new com.upcusc.jdserato.upcintrams.Games.Chess
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x02f1:
                    r7 = 13
                    goto L_0x0691
                L_0x02f5:
                    if (r8 == 0) goto L_0x031a
                    com.upcusc.jdserato.upcintrams.Games.VolleyballWomen r3 = new com.upcusc.jdserato.upcintrams.Games.VolleyballWomen
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x0338
                L_0x031a:
                    com.upcusc.jdserato.upcintrams.Games.VolleyballWomen r3 = new com.upcusc.jdserato.upcintrams.Games.VolleyballWomen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x0338:
                    r7 = 12
                    goto L_0x0691
                L_0x033c:
                    if (r8 == 0) goto L_0x0361
                    com.upcusc.jdserato.upcintrams.Games.VolleyballMen r3 = new com.upcusc.jdserato.upcintrams.Games.VolleyballMen
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x037f
                L_0x0361:
                    com.upcusc.jdserato.upcintrams.Games.VolleyballMen r3 = new com.upcusc.jdserato.upcintrams.Games.VolleyballMen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x037f:
                    r7 = 11
                    goto L_0x0691
                L_0x0383:
                    if (r8 == 0) goto L_0x03a8
                    com.upcusc.jdserato.upcintrams.Games.TableTennisMixed r3 = new com.upcusc.jdserato.upcintrams.Games.TableTennisMixed
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x03c6
                L_0x03a8:
                    com.upcusc.jdserato.upcintrams.Games.TableTennisMixed r3 = new com.upcusc.jdserato.upcintrams.Games.TableTennisMixed
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x03c6:
                    r7 = 10
                    goto L_0x0691
                L_0x03ca:
                    if (r8 == 0) goto L_0x03ef
                    com.upcusc.jdserato.upcintrams.Games.TableTennisWomen r3 = new com.upcusc.jdserato.upcintrams.Games.TableTennisWomen
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x040d
                L_0x03ef:
                    com.upcusc.jdserato.upcintrams.Games.TableTennisWomen r3 = new com.upcusc.jdserato.upcintrams.Games.TableTennisWomen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x040d:
                    r7 = 9
                    goto L_0x0691
                L_0x0411:
                    if (r8 == 0) goto L_0x0436
                    com.upcusc.jdserato.upcintrams.Games.TableTennisMen r3 = new com.upcusc.jdserato.upcintrams.Games.TableTennisMen
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x0454
                L_0x0436:
                    com.upcusc.jdserato.upcintrams.Games.TableTennisMen r3 = new com.upcusc.jdserato.upcintrams.Games.TableTennisMen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x0454:
                    r7 = 8
                    goto L_0x0691
                L_0x0458:
                    java.io.PrintStream r3 = java.lang.System.out
                    r3.println()
                    if (r8 == 0) goto L_0x0482
                    com.upcusc.jdserato.upcintrams.Games.SoccerWomen r3 = new com.upcusc.jdserato.upcintrams.Games.SoccerWomen
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x04a0
                L_0x0482:
                    com.upcusc.jdserato.upcintrams.Games.SoccerWomen r3 = new com.upcusc.jdserato.upcintrams.Games.SoccerWomen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x04a0:
                    r7 = 7
                    goto L_0x0691
                L_0x04a3:
                    java.io.PrintStream r3 = java.lang.System.out
                    r3.println()
                    if (r8 == 0) goto L_0x04cd
                    com.upcusc.jdserato.upcintrams.Games.SoccerMen r3 = new com.upcusc.jdserato.upcintrams.Games.SoccerMen
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x04eb
                L_0x04cd:
                    com.upcusc.jdserato.upcintrams.Games.SoccerMen r3 = new com.upcusc.jdserato.upcintrams.Games.SoccerMen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x04eb:
                    r7 = 6
                    goto L_0x0691
                L_0x04ee:
                    if (r8 == 0) goto L_0x0513
                    com.upcusc.jdserato.upcintrams.Games.Softball r3 = new com.upcusc.jdserato.upcintrams.Games.Softball
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x0531
                L_0x0513:
                    com.upcusc.jdserato.upcintrams.Games.Softball r3 = new com.upcusc.jdserato.upcintrams.Games.Softball
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x0531:
                    r7 = 5
                    goto L_0x0691
                L_0x0534:
                    if (r8 == 0) goto L_0x055b
                    com.upcusc.jdserato.upcintrams.Games.Frisbee r3 = new com.upcusc.jdserato.upcintrams.Games.Frisbee
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r7 = 4
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x0691
                L_0x055b:
                    r7 = 4
                    com.upcusc.jdserato.upcintrams.Games.Frisbee r3 = new com.upcusc.jdserato.upcintrams.Games.Frisbee
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r9 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r9 = r9.get(r2)
                    r10 = r9
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r9 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r9 = r9.get(r5)
                    r11 = r9
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x0691
                L_0x057c:
                    if (r8 == 0) goto L_0x05a1
                    com.upcusc.jdserato.upcintrams.Games.BasketballWomen r3 = new com.upcusc.jdserato.upcintrams.Games.BasketballWomen
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x05bf
                L_0x05a1:
                    com.upcusc.jdserato.upcintrams.Games.BasketballWomen r3 = new com.upcusc.jdserato.upcintrams.Games.BasketballWomen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x05bf:
                    r7 = 3
                    goto L_0x0691
                L_0x05c2:
                    if (r8 == 0) goto L_0x05e7
                    com.upcusc.jdserato.upcintrams.Games.BasketballMen r3 = new com.upcusc.jdserato.upcintrams.Games.BasketballMen
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r7 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x0605
                L_0x05e7:
                    com.upcusc.jdserato.upcintrams.Games.BasketballMen r3 = new com.upcusc.jdserato.upcintrams.Games.BasketballMen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r2)
                    r10 = r7
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r7 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r7 = r7.get(r5)
                    r11 = r7
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x0605:
                    r7 = 2
                    goto L_0x0691
                L_0x0608:
                    if (r8 == 0) goto L_0x062d
                    com.upcusc.jdserato.upcintrams.Games.BadmintonWomen r7 = new com.upcusc.jdserato.upcintrams.Games.BadmintonWomen
                    java.util.List r9 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r9 = r9.get(r2)
                    r10 = r9
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r9 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r9 = r9.get(r5)
                    r11 = r9
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r7
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x064b
                L_0x062d:
                    com.upcusc.jdserato.upcintrams.Games.BadmintonWomen r7 = new com.upcusc.jdserato.upcintrams.Games.BadmintonWomen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r9 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r9 = r9.get(r2)
                    r10 = r9
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r9 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r9 = r9.get(r5)
                    r11 = r9
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r7
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x064b:
                    r3 = r7
                    r7 = 1
                    goto L_0x0691
                L_0x064e:
                    if (r8 == 0) goto L_0x0673
                    com.upcusc.jdserato.upcintrams.Games.BadmintonMen r3 = new com.upcusc.jdserato.upcintrams.Games.BadmintonMen
                    java.util.List r9 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r9 = r9.get(r2)
                    r10 = r9
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List r9 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r9 = r9.get(r5)
                    r11 = r9
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x0691
                L_0x0673:
                    com.upcusc.jdserato.upcintrams.Games.BadmintonMen r3 = new com.upcusc.jdserato.upcintrams.Games.BadmintonMen
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r9 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r9 = r9.get(r2)
                    r10 = r9
                    com.upcusc.jdserato.upcintrams.College r10 = (com.upcusc.jdserato.upcintrams.College) r10
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r9 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r9 = r9.get(r5)
                    r11 = r9
                    com.upcusc.jdserato.upcintrams.College r11 = (com.upcusc.jdserato.upcintrams.College) r11
                    r9 = r3
                    r12 = r16
                    r15 = r17
                    r16 = r18
                    r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                L_0x0691:
                    java.io.PrintStream r9 = java.lang.System.out
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder
                    r10.<init>()
                    java.lang.String r11 = "Sport is "
                    r10.append(r11)
                    r10.append(r4)
                    java.lang.String r4 = r10.toString()
                    r9.println(r4)
                    boolean r4 = r3.isOnce()
                    if (r4 != 0) goto L_0x06f3
                    if (r7 > r6) goto L_0x06f3
                    if (r8 != 0) goto L_0x06d0
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r4 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r2 = r4.get(r2)
                    com.upcusc.jdserato.upcintrams.College r2 = (com.upcusc.jdserato.upcintrams.College) r2
                    com.upcusc.jdserato.upcintrams.Game r2 = r2.getGame(r7)
                    r2.addSubGame(r3)
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r2 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.lang.Object r2 = r2.get(r5)
                    com.upcusc.jdserato.upcintrams.College r2 = (com.upcusc.jdserato.upcintrams.College) r2
                    com.upcusc.jdserato.upcintrams.Game r2 = r2.getGame(r7)
                    r2.addSubGame(r3)
                    goto L_0x070d
                L_0x06d0:
                    java.util.List r4 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r2 = r4.get(r2)
                    com.upcusc.jdserato.upcintrams.College r2 = (com.upcusc.jdserato.upcintrams.College) r2
                    com.upcusc.jdserato.upcintrams.Game r2 = r2.getGame(r7)
                    r2.addSubGame(r3)
                    java.util.List r2 = com.upcusc.jdserato.upcintrams.MainActivity.pseudoCollege
                    java.lang.Object r2 = r2.get(r5)
                    com.upcusc.jdserato.upcintrams.College r2 = (com.upcusc.jdserato.upcintrams.College) r2
                    com.upcusc.jdserato.upcintrams.Game r2 = r2.getGame(r7)
                    r2.addSubGame(r3)
                    goto L_0x070d
                L_0x06f3:
                    java.util.List<com.upcusc.jdserato.upcintrams.College> r2 = com.upcusc.jdserato.upcintrams.MainActivity.colleges
                    java.util.Iterator r2 = r2.iterator()
                L_0x06f9:
                    boolean r4 = r2.hasNext()
                    if (r4 == 0) goto L_0x070d
                    java.lang.Object r4 = r2.next()
                    com.upcusc.jdserato.upcintrams.College r4 = (com.upcusc.jdserato.upcintrams.College) r4
                    com.upcusc.jdserato.upcintrams.Game r4 = r4.getGame(r7)
                    r4.addSubGame(r3)
                    goto L_0x06f9
                L_0x070d:
                    java.util.List<com.upcusc.jdserato.upcintrams.Game> r2 = com.upcusc.jdserato.upcintrams.MainActivity.games
                    r2.add(r3)
                    goto L_0x0052
                L_0x0714:
                    java.lang.String r1 = ""
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r4 = "Current games in CA: "
                    r2.append(r4)
                    java.util.List<com.upcusc.jdserato.upcintrams.Game> r4 = com.upcusc.jdserato.upcintrams.MainActivity.games
                    r2.append(r4)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r1, r2)
                    com.upcusc.jdserato.upcintrams.MainActivity r1 = com.upcusc.jdserato.upcintrams.MainActivity.this
                    com.upcusc.jdserato.upcintrams.ELVAResults r2 = new com.upcusc.jdserato.upcintrams.ELVAResults
                    r2.<init>(r1)
                    r1.adapter = r2
                    com.upcusc.jdserato.upcintrams.MainActivity r1 = com.upcusc.jdserato.upcintrams.MainActivity.this
                    android.widget.ExpandableListView r1 = r1.elv
                    com.upcusc.jdserato.upcintrams.MainActivity r2 = com.upcusc.jdserato.upcintrams.MainActivity.this
                    com.upcusc.jdserato.upcintrams.ELVAResults r2 = r2.adapter
                    r1.setAdapter(r2)
                    com.upcusc.jdserato.upcintrams.MainActivity r1 = com.upcusc.jdserato.upcintrams.MainActivity.this
                    boolean r1 = r1.init
                    if (r1 != 0) goto L_0x074c
                    com.upcusc.jdserato.upcintrams.MainActivity r1 = com.upcusc.jdserato.upcintrams.MainActivity.this
                    r1.init = r3
                L_0x074c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.upcusc.jdserato.upcintrams.MainActivity.C14352.onEvent(com.google.firebase.firestore.QuerySnapshot, com.google.firebase.firestore.FirebaseFirestoreException):void");
            }
        });
    }
}
