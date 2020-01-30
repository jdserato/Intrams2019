package com.upcusc.intrams;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.upcusc.intrams.Games.*;
import java.util.ArrayList;
import java.util.List;

public class ELVAEvents extends BaseExpandableListAdapter {
    private Context context;
    List<Game> games = new ArrayList();

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public int getChildrenCount(int i) {
        return 4;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return false;
    }

    public ELVAEvents(Context context2) {
        this.context = context2;
        List<Game> list = this.games;
        BadmintonMen badmintonMen = new BadmintonMen(null, null, null, 0, 0, 0, 0);
        list.add(badmintonMen);
        List<Game> list2 = this.games;
        BadmintonWomen badmintonWomen = new BadmintonWomen(null, null, null, 0, 0, 0, 0);
        list2.add(badmintonWomen);
        List<Game> list3 = this.games;
        BasketballMen basketballMen = new BasketballMen(null, null, null, 0, 0, 0, 0);
        list3.add(basketballMen);
        List<Game> list4 = this.games;
        BasketballWomen basketballWomen = new BasketballWomen(null, null, null, 0, 0, 0, 0);
        list4.add(basketballWomen);
        List<Game> list5 = this.games;
        Frisbee frisbee = new Frisbee(null, null, null, 0, 0, 0, 0);
        list5.add(frisbee);
        List<Game> list6 = this.games;
        Softball softball = new Softball(null, null, null, 0, 0, 0, 0);
        list6.add(softball);
        List<Game> list7 = this.games;
        SoccerMen soccerMen = new SoccerMen(null, null, null, 0, 0, 0, 0);
        list7.add(soccerMen);
        List<Game> list8 = this.games;
        SoccerWomen soccerWomen = new SoccerWomen(null, null, null, 0, 0, 0, 0);
        list8.add(soccerWomen);
        List<Game> list9 = this.games;
        TableTennisMen tableTennisMen = new TableTennisMen(null, null, null, 0, 0, 0, 0);
        list9.add(tableTennisMen);
        List<Game> list10 = this.games;
        TableTennisWomen tableTennisWomen = new TableTennisWomen(null, null, null, 0, 0, 0, 0);
        list10.add(tableTennisWomen);
        List<Game> list11 = this.games;
        TableTennisMixed tableTennisMixed = new TableTennisMixed(null, null, null, 0, 0, 0, 0);
        list11.add(tableTennisMixed);
        List<Game> list12 = this.games;
        VolleyballMen volleyballMen = new VolleyballMen(null, null, null, 0, 0, 0, 0);
        list12.add(volleyballMen);
        List<Game> list13 = this.games;
        VolleyballWomen volleyballWomen = new VolleyballWomen(null, null, null, 0, 0, 0, 0);
        list13.add(volleyballWomen);
        List<Game> list14 = this.games;
        Chess chess = new Chess(null, null, null, 0, 0, 0, 0);
        list14.add(chess);
        List<Game> list15 = this.games;
        Scrabble scrabble = new Scrabble(null, 0, 0, 0, 0);
        list15.add(scrabble);
        List<Game> list16 = this.games;
        Zumba zumba = new Zumba(null, 0, 0, 0, 0);
        list16.add(zumba);
        List<Game> list17 = this.games;
        Rubiks rubiks = new Rubiks(null, 0, 0, 0, 0);
        list17.add(rubiks);
        List<Game> list18 = this.games;
        DanceFusion danceFusion = new DanceFusion(null, 0, 0, 0, 0);
        list18.add(danceFusion);
        List<Game> list19 = this.games;
        DanceSport danceSport = new DanceSport(null, 0, 0, 0, 0);
        list19.add(danceSport);
        List<Game> list20 = this.games;
        FieldDemo fieldDemo = new FieldDemo(null, 0, 0, 0, 0);
        list20.add(fieldDemo);
        List<Game> list21 = this.games;
        LarongPinoy larongPinoy = new LarongPinoy(null, 0, 0, 0, 0);
        list21.add(larongPinoy);
        List<Game> list22 = this.games;
        MrMsFitness mrMsFitness = new MrMsFitness(null, 0, 0, 0, 0);
        list22.add(mrMsFitness);
        List<Game> list23 = this.games;
        Parade parade = new Parade(null, 0, 0, 0, 0);
        list23.add(parade);
        for (Game game : this.games) {
            for (Game game2 : MainActivity.games) {
                if (game2.getSport().equals(game.getSport())) {
                    game.addSubGame(game2);
                }
            }
        }
    }

    public int getGroupCount() {
        return this.games.size();
    }

    public Object getGroup(int i) {
        return this.games.get(i);
    }

    public Object getChild(int i, int i2) {
        return MainActivity.colleges.get(i2);
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        Game game = (Game) this.games.get(i);
        LinearLayout linearLayout = new LinearLayout(this.context);
        ImageView imageView = new ImageView(this.context);
        setScaledImage(imageView, game.getIvRes());
        imageView.setLayoutParams(new LayoutParams(75, 75));
        linearLayout.addView(imageView);
        TextView textView = new TextView(this.context);
        textView.setText(game.getSport());
        textView.setTextSize(30.0f);
        textView.setTextColor(-1);
        linearLayout.setGravity(17);
        linearLayout.addView(textView);
        return linearLayout;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        int i3 = i;
        int[] iArr = new int[4];
        int i4 = 0;
        while (true) {
            int i5 = -1;
            if (i4 < 4) {
                College college = (College) MainActivity.colleges.get(i4);
                for (Game game : college.getGame(i3).getGames()) {
                    if (game.isOnce()) {
                        switch (i4) {
                            case 0:
                                iArr[i4] = (game.getStanding1() - 5) * -1;
                                break;
                            case 1:
                                iArr[i4] = (game.getStanding2() - 5) * -1;
                                break;
                            case 2:
                                iArr[i4] = (game.getStanding3() - 5) * -1;
                                break;
                            case 3:
                                iArr[i4] = (game.getStanding4() - 5) * -1;
                                break;
                        }
                    } else if (college.equals(game.getCollege1()) && game.getScore1() > game.getScore2()) {
                        iArr[i4] = iArr[i4] + 1;
                    } else if (college.equals(game.getCollege1())) {
                        iArr[i4] = iArr[i4] - 1;
                    } else if (college.equals(game.getCollege2()) && game.getScore2() > game.getScore1()) {
                        iArr[i4] = iArr[i4] + 1;
                    } else if (college.equals(game.getCollege2())) {
                        iArr[i4] = iArr[i4] - 1;
                    }
                }
                i4++;
            } else {
                int i6 = i2;
                int i7 = 0;
                int i8 = 0;
                while (i7 <= i6) {
                    int i9 = i8;
                    int i10 = Integer.MIN_VALUE;
                    for (int i11 = 0; i11 < 4; i11++) {
                        if (iArr[i11] > i10) {
                            i10 = iArr[i11];
                            i9 = i11;
                        }
                    }
                    iArr[i9] = Integer.MIN_VALUE;
                    i7++;
                    i8 = i9;
                }
                LinearLayout linearLayout = new LinearLayout(this.context);
                linearLayout.setPadding(5, 0, 5, 25);
                ImageView imageView = new ImageView(this.context);
                switch (i8) {
                    case 0:
                        imageView.setBackgroundResource(R.drawable.tyrell);
                        break;
                    case 1:
                        imageView.setBackgroundResource(R.drawable.baratheon);
                        break;
                    case 2:
                        imageView.setBackgroundResource(R.drawable.targaryen);
                        break;
                    case 3:
                        imageView.setBackgroundResource(R.drawable.arryn);
                        break;
                }
                imageView.setLayoutParams(new LayoutParams(120, 135));
                imageView.setPadding(0, 0, 5, 0);
                linearLayout.addView(imageView);
                LinearLayout linearLayout2 = new LinearLayout(this.context);
                linearLayout2.setOrientation(LinearLayout.VERTICAL);
                linearLayout2.setPadding(0, 10, 0, 10);
                TextView textView = new TextView(this.context);
                textView.setText(((College) MainActivity.colleges.get(i8)).getThemeName());
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextSize(15.0f);
                textView.setPadding(0, 0, 0, 5);
                textView.setTextColor(-1);
                linearLayout2.addView(textView);
                TextView textView2 = new TextView(this.context);
                textView2.setText(((College) MainActivity.colleges.get(i8)).getCollegeName());
                textView2.setTextSize(15.0f);
                textView2.setPadding(0, 5, 0, 0);
                textView2.setTextColor(-1);
                linearLayout2.addView(textView2);
                linearLayout2.setLayoutParams(new LayoutParams(150, 150));
                linearLayout.addView(linearLayout2);
                ImageView imageView2 = new ImageView(this.context);
                if (((Game) this.games.get(i3)).isOnce()) {
                    if (((Game) this.games.get(i3)).getGames().size() > 0) {
                        Game game2 = (Game) ((Game) this.games.get(i3)).getGames().get(0);
                        if (!((College) MainActivity.colleges.get(i8)).getCollegeName().equals("CCAD")) {
                            if (!((College) MainActivity.colleges.get(i8)).getCollegeName().equals("COS")) {
                                if (!((College) MainActivity.colleges.get(i8)).getCollegeName().equals("CSS")) {
                                    if (((College) MainActivity.colleges.get(i8)).getCollegeName().equals("SOM")) {
                                        switch (game2.getStanding4()) {
                                            case 1:
                                                setScaledImage(imageView2, R.drawable.first);
                                                break;
                                            case 2:
                                                setScaledImage(imageView2, R.drawable.second);
                                                break;
                                            case 3:
                                                setScaledImage(imageView2, R.drawable.third);
                                                break;
                                            case 4:
                                                setScaledImage(imageView2, R.drawable.fourth);
                                                break;
                                        }
                                    }
                                } else {
                                    switch (game2.getStanding3()) {
                                        case 1:
                                            setScaledImage(imageView2, R.drawable.first);
                                            break;
                                        case 2:
                                            setScaledImage(imageView2, R.drawable.second);
                                            break;
                                        case 3:
                                            setScaledImage(imageView2, R.drawable.third);
                                            break;
                                        case 4:
                                            setScaledImage(imageView2, R.drawable.fourth);
                                            break;
                                    }
                                }
                            } else {
                                switch (game2.getStanding2()) {
                                    case 1:
                                        setScaledImage(imageView2, R.drawable.first);
                                        break;
                                    case 2:
                                        setScaledImage(imageView2, R.drawable.second);
                                        break;
                                    case 3:
                                        setScaledImage(imageView2, R.drawable.third);
                                        break;
                                    case 4:
                                        setScaledImage(imageView2, R.drawable.fourth);
                                        break;
                                }
                            }
                        } else {
                            switch (game2.getStanding1()) {
                                case 1:
                                    setScaledImage(imageView2, R.drawable.first);
                                    break;
                                case 2:
                                    setScaledImage(imageView2, R.drawable.second);
                                    break;
                                case 3:
                                    setScaledImage(imageView2, R.drawable.third);
                                    break;
                                case 4:
                                    setScaledImage(imageView2, R.drawable.fourth);
                                    break;
                            }
                        }
                    }
                } else {
                    TextView textView3 = new TextView(this.context);
                    textView3.setTextSize(40.0f);
                    TextView textView4 = new TextView(this.context);
                    textView4.setPadding(15, 0, 15, 0);
                    textView4.setTextSize(25.0f);
                    TextView textView5 = new TextView(this.context);
                    textView5.setTextSize(40.0f);
                    int i12 = 0;
                    int i13 = 0;
                    for (Game game3 : ((Game) this.games.get(i3)).getGames()) {
                        if (((College) MainActivity.colleges.get(i8)).equals(game3.getCollege1())) {
                            if (game3.getScore1() > game3.getScore2()) {
                                i12++;
                            } else if (game3.getScore1() < game3.getScore2()) {
                                i13++;
                            }
                            if (game3.getStanding1() != 0) {
                                if (game3.getStanding1() == 1) {
                                    setScaledImage(imageView2, R.drawable.first);
                                } else if (game3.getStanding1() == 2) {
                                    setScaledImage(imageView2, R.drawable.second);
                                } else if (game3.getStanding1() == 3) {
                                    setScaledImage(imageView2, R.drawable.third);
                                } else {
                                    setScaledImage(imageView2, R.drawable.fourth);
                                }
                            }
                        } else if (((College) MainActivity.colleges.get(i8)).equals(game3.getCollege2())) {
                            if (game3.getScore1() > game3.getScore2()) {
                                i13++;
                            } else if (game3.getScore1() < game3.getScore2()) {
                                i12++;
                            }
                            if (game3.getStanding2() != 0) {
                                if (game3.getStanding2() == 1) {
                                    setScaledImage(imageView2, R.drawable.first);
                                } else if (game3.getStanding2() == 2) {
                                    setScaledImage(imageView2, R.drawable.second);
                                } else if (game3.getStanding2() == 3) {
                                    setScaledImage(imageView2, R.drawable.third);
                                } else {
                                    setScaledImage(imageView2, R.drawable.fourth);
                                }
                            }
                        }
                        i5 = -1;
                    }
                    textView3.setTextColor(i5);
                    textView4.setTextColor(i5);
                    textView5.setTextColor(i5);
                    textView3.setText(String.format("%d", new Object[]{Integer.valueOf(i12)}));
                    linearLayout.addView(textView3);
                    textView4.setText("-");
                    linearLayout.addView(textView4);
                    textView5.setText(String.format("%d", new Object[]{Integer.valueOf(i13)}));
                    linearLayout.addView(textView5);
                }
                imageView2.setLayoutParams(new LayoutParams(75, 85));
                linearLayout.addView(imageView2);
                linearLayout.setGravity(17);
                linearLayout.setPadding(100, 10, 0, 0);
                return linearLayout;
            }
        }
    }

    private void setScaledImage(final ImageView imageView, final int i) {
        imageView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = imageView.getMeasuredHeight();
                imageView.setImageBitmap(ELVAEvents.decodeSampledBitmapFromResource(EventActivity.res, i, imageView.getMeasuredWidth(), measuredHeight));
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
