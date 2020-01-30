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
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

public class ELVAResults extends BaseExpandableListAdapter {
    private List<College> colleges = MainActivity.colleges;
    private Context context;
    private int height = MainActivity.height;
    private int width = MainActivity.width;

    public long getChildId(int i, int i2) {
        return (long) i2;
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

    public ELVAResults(Context context2) {
        this.context = context2;
    }

    public int getGroupCount() {
        return this.colleges.size();
    }

    public int getChildrenCount(int i) {
        return ((College) this.colleges.get(i)).numberOfGames();
    }

    public Object getGroup(int i) {
        return this.colleges.get(i);
    }

    public Object getChild(int i, int i2) {
        return ((College) this.colleges.get(i)).getGame(i2);
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setPadding(5, 0, 5, 25);
        ImageView imageView = new ImageView(this.context);
        switch (i) {
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
        imageView.setLayoutParams(new LayoutParams(220, 220/*Callback.DEFAULT_SWIPE_ANIMATION_DURATION*/));
        imageView.setPadding(0, 0, 5, 0);
        linearLayout.addView(imageView);
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        linearLayout2.setPadding(0, 10, 0, 10);
        TextView textView = new TextView(this.context);
        textView.setText(((College) this.colleges.get(i)).toString());
        textView.setTextSize(15.0f);
        textView.setPadding(0, 5, 0, 0);
        textView.setTextColor(-1);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.context);
        textView2.setText(((College) this.colleges.get(i)).getThemeName());
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTextSize(15.0f);
        textView2.setPadding(0, 0, 0, 5);
        textView2.setTextColor(-1);
        linearLayout2.addView(textView2);
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        relativeLayout.setMinimumHeight(45);
        ImageView imageView2 = new ImageView(this.context);
        switch (i) {
            case 0:
                imageView2.setBackgroundResource(R.drawable.tyrell_loading);
                break;
            case 1:
                imageView2.setBackgroundResource(R.drawable.baratheon_loading);
                break;
            case 2:
                imageView2.setBackgroundResource(R.drawable.targaryen_loading);
                break;
            case 3:
                imageView2.setBackgroundResource(R.drawable.arryn_loading);
                break;
        }
        imageView2.setLayoutParams(new LayoutParams(125, 125));
        imageView2.getLayoutParams().height = 125;
        int i2 = 0;
        for (College college : this.colleges) {
            if (college.getTotalScore() > i2) {
                i2 = college.getTotalScore();
            }
        }
        if (((College) this.colleges.get(i)).getTotalScore() != 0) {
            float f = (float) i2;
            if ((((float) (this.width - 270)) * ((float) ((College) this.colleges.get(i)).getTotalScore())) / f >= 50.0f) {
                imageView2.getLayoutParams().width = (int) ((((float) (this.width - 270)) * ((float) ((College) this.colleges.get(i)).getTotalScore())) / f);
                relativeLayout.addView(imageView2);
                TextView textView3 = new TextView(this.context);
                textView3.setText(String.valueOf(((College) this.colleges.get(i)).getTotalScore()));
                textView3.setTextSize(32.0f);
                textView3.setBackgroundColor(0);
                relativeLayout.addView(textView3);
                linearLayout2.addView(relativeLayout);
                linearLayout.addView(linearLayout2);
                return linearLayout;
            }
        }
        imageView2.getLayoutParams().width = 50;
        relativeLayout.addView(imageView2);
        TextView textView32 = new TextView(this.context);
        textView32.setText(String.valueOf(((College) this.colleges.get(i)).getTotalScore()));
        textView32.setTextSize(32.0f);
        textView32.setBackgroundColor(0);
        relativeLayout.addView(textView32);
        linearLayout2.addView(relativeLayout);
        linearLayout.addView(linearLayout2);
        return linearLayout;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        int i3;
        int i4;
        List<Game> list = MainActivity.games;
        LinearLayout linearLayout = new LinearLayout(this.context);
        ImageView imageView = new ImageView(this.context);
        Game game = ((College) this.colleges.get(i)).getGame(i2);
        if (!game.isOnce()) {
            i3 = findStanding(game, i);
        } else {
            i3 = gameSelectOnce(game, i);
        }
        switch (i3) {
            case 1:
                i4 = R.drawable.first;
                break;
            case 2:
                i4 = R.drawable.second;
                break;
            case 3:
                i4 = R.drawable.third;
                break;
            case 4:
                i4 = R.drawable.fourth;
                break;
            default:
                i4 = 0;
                break;
        }
        if (i4 != 0) {
            setScaledImage(imageView, i4);
        } else {
            setScaledImage(imageView, game.getIvRes());
        }
        imageView.setLayoutParams(new LayoutParams(60, 75));
        linearLayout.addView(imageView);
        String collegeName = ((College) this.colleges.get(i)).getCollegeName();
        TextView textView = new TextView(this.context);
        textView.setText(game.getSport());
        textView.setTextColor(-1);
        textView.setTextSize(18.0f);
        linearLayout.addView(textView);
        if (!game.isOnce()) {
            int gameSelectWin = gameSelectWin(game, collegeName);
            TextView textView2 = new TextView(this.context);
            textView2.setText(String.format("W:%s", new Object[]{String.valueOf(gameSelectWin)}));
            textView2.setTextColor(-1);
            textView2.setPadding(20, 0, 0, 0);
            linearLayout.addView(textView2);
            TextView textView3 = new TextView(this.context);
            textView3.setText(R.string.dash);
            textView3.setTextColor(-1);
            linearLayout.addView(textView3);
            TextView textView4 = new TextView(this.context);
            textView4.setText(String.format("L:%s", new Object[]{String.valueOf(gameSelectLose(0, game, collegeName))}));
            textView4.setTextColor(-1);
            linearLayout.addView(textView4);
        }
        linearLayout.setGravity(17);
        linearLayout.setPadding(200, 0, 0, 0);
        return linearLayout;
    }

    private void setScaledImage(final ImageView imageView, final int i) {
        imageView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = imageView.getMeasuredHeight();
                imageView.setImageBitmap(ELVAResults.decodeSampledBitmapFromResource(MainActivity.res, i, imageView.getMeasuredWidth(), measuredHeight));
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

    private int gameSelectLose(int i, Game game, String str) {
        try {
            for (Game game2 : game.getGames()) {
                if (game2.getCollege1().getCollegeName().equals(str)) {
                    if (game2.getScore1() < game2.getScore2()) {
                        i++;
                    }
                } else if (game2.getCollege2().getCollegeName().equals(str) && game2.getScore1() > game2.getScore2()) {
                    i++;
                }
            }
        } catch (NullPointerException unused) {
        }
        return i;
    }

    private int gameSelectWin(Game game, String str) {
        int i = 0;
        try {
            for (Game game2 : game.getGames()) {
                if (game2.getCollege1().getCollegeName().equals(str)) {
                    if (game2.getScore1() > game2.getScore2()) {
                        i++;
                    }
                } else if (game2.getCollege2().getCollegeName().equals(str) && game2.getScore1() < game2.getScore2()) {
                    i++;
                }
            }
        } catch (NullPointerException unused) {
        }
        return i;
    }

    private int gameSelectOnce(Game game, int i) {
        if (game.getGames().size() > 0) {
            Game game2 = (Game) game.getGames().get(0);
            switch (i) {
                case 0:
                    return game2.getStanding1();
                case 1:
                    return game2.getStanding2();
                case 2:
                    return game2.getStanding3();
                case 3:
                    return game2.getStanding4();
            }
        }
        return 0;
    }

    private int findStanding(Game game, int i) {
        for (Game game2 : game.getGames()) {
            switch (i) {
                case 0:
                    if (game2.getCollege1().getCollegeName().equals("CCAD") && game2.getStanding1() > 0) {
                        return game2.getStanding1();
                    }
                    if (game2.getCollege2().getCollegeName().equals("CCAD") && game2.getStanding2() > 0) {
                        return game2.getStanding2();
                    }
                    break;
                case 1:
                    if (game2.getCollege1().getCollegeName().equals("COS") && game2.getStanding1() > 0) {
                        return game2.getStanding1();
                    }
                    if (game2.getCollege2().getCollegeName().equals("COS") && game2.getStanding2() > 0) {
                        return game2.getStanding2();
                    }
                    break;
                case 2:
                    if (game2.getCollege1().getCollegeName().equals("CSS") && game2.getStanding1() > 0) {
                        return game2.getStanding1();
                    }
                    if (game2.getCollege2().getCollegeName().equals("CSS") && game2.getStanding2() > 0) {
                        return game2.getStanding2();
                    }
                    break;
                case 3:
                    if (game2.getCollege1().getCollegeName().equals("SOM") && game2.getStanding1() > 0) {
                        return game2.getStanding1();
                    }
                    if (game2.getCollege2().getCollegeName().equals("SOM") && game2.getStanding2() > 0) {
                        return game2.getStanding2();
                    }
                    break;
            }
        }
        return 0;
    }
}
