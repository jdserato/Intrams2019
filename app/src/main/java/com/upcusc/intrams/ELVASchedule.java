package com.upcusc.intrams;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ELVASchedule extends BaseExpandableListAdapter {
    private Context context;
    List<Game>[] date = new List[4];
    List<Game> games = MainActivity.games;

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public int getGroupCount() {
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

    public ELVASchedule(Context context2) {
        List<Game>[] listArr;
        this.context = context2;
        for (int i = 0; i < 4; i++) {
            this.date[i] = new ArrayList();
        }
        for (Game game : this.games) {
            this.date[game.getTime().getDay() - 3].add(game);
        }
        for (List<Game> list : this.date) {
            if (VERSION.SDK_INT >= 24) {
                list.sort(new Comparator<Game>() {
                    public int compare(Game game, Game game2) {
                        if (game.getTime().before(game2.getTime())) {
                            return -1;
                        }
                        return game.getTime().after(game2.getTime()) ? 1 : 0;
                    }
                });
            }
        }
    }

    public int getChildrenCount(int i) {
        return this.date[i].size();
    }

    public Object getGroup(int i) {
        return this.date[i];
    }

    public Object getChild(int i, int i2) {
        return this.date[i].get(i2);
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(this.context);
        textView.setText(String.format("March %d", new Object[]{Integer.valueOf(i + 20)}));
        textView.setTextColor(-1);
        textView.setWidth(MainActivity.width);
        textView.setTextSize(40.0f);
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        return textView;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        Game game = (Game) this.date[i].get(i2);
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView textView = new TextView(this.context);
        textView.setText(String.format("%d:%d", new Object[]{Integer.valueOf(game.getTime().getHours()), Integer.valueOf(game.getTime().getMinutes())}));
        textView.setTextColor(-1);
        if (game.getTime().getMinutes() < 10) {
            textView.setText(String.format("%s0", new Object[]{textView.getText()}));
        }
        if (game.getTime().getHours() < 10) {
            textView.setText(String.format("0%s", new Object[]{textView.getText()}));
        }
        textView.setTextSize(25.0f);
        textView.setPadding(25, 0, 0, 0);
        linearLayout.addView(textView);
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        LinearLayout linearLayout3 = new LinearLayout(this.context);
        linearLayout3.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout2.setLayoutParams(new LayoutParams((MainActivity.width / 5) * 3, 180));
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append(MainActivity.width - 500);
        sb.append(" is allocated as width. Allocated width remains to be ");
        sb.append(MainActivity.width - textView.getWidth());
        printStream.println(sb.toString());
        linearLayout2.setPadding(50, 0, 80, 0);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        ImageView imageView = new ImageView(this.context);
        setScaledImage(imageView, game.getIvRes());
        imageView.setLayoutParams(new LayoutParams(75, 75));
        linearLayout3.addView(imageView);
        TextView textView2 = new TextView(this.context);
        textView2.setTextColor(-1);
        textView2.setTextSize(18.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setText(game.getSport());
        linearLayout3.addView(textView2);
        linearLayout2.addView(linearLayout3);
        if (!game.isOnce()) {
            LinearLayout linearLayout4 = new LinearLayout(this.context);
            linearLayout4.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView3 = new TextView(this.context);
            textView3.setTextColor(-1);
            textView3.setText(game.getCollege1().getCollegeName());
            if (game.getCollege1().getCollegeName().equals("CCAD")) {
                textView3.setTextColor(-16711936);
            } else if (game.getCollege1().getCollegeName().equals("COS")) {
                textView3.setTextColor(InputDeviceCompat.SOURCE_ANY);
            } else if (game.getCollege1().getCollegeName().equals("CSS")) {
                textView3.setTextColor(SupportMenu.CATEGORY_MASK);
            } else if (game.getCollege1().getCollegeName().equals("SOM")) {
                textView3.setTextColor(-16711681);
            }
            linearLayout4.addView(textView3);
            TextView textView4 = new TextView(this.context);
            textView4.setTextColor(-1);
            textView4.setPadding(5, 0, 5, 0);
            textView4.setText("vs");
            linearLayout4.addView(textView4);
            TextView textView5 = new TextView(this.context);
            textView5.setTextColor(-1);
            textView5.setText(game.getCollege2().getCollegeName());
            if (game.getCollege2().getCollegeName().equals("CCAD")) {
                textView5.setTextColor(-16711936);
            } else if (game.getCollege2().getCollegeName().equals("COS")) {
                textView5.setTextColor(InputDeviceCompat.SOURCE_ANY);
            } else if (game.getCollege2().getCollegeName().equals("CSS")) {
                textView5.setTextColor(SupportMenu.CATEGORY_MASK);
            } else if (game.getCollege2().getCollegeName().equals("SOM")) {
                textView5.setTextColor(-16711681);
            }
            linearLayout4.addView(textView5);
            linearLayout2.addView(linearLayout4);
        }
        linearLayout2.setGravity(17);
        linearLayout.addView(linearLayout2);
        TextView textView6 = new TextView(this.context);
        textView6.setTextColor(-1);
        TextView textView7 = new TextView(this.context);
        textView7.setTextColor(-1);
        if (game.isOnce() && game.getStanding1() > 0) {
            if (game.getStanding1() == 1) {
                textView6.setText("CCAD");
                textView6.setTextColor(-16711936);
            } else if (game.getStanding2() == 1) {
                textView6.setText("COS");
                textView6.setTextColor(InputDeviceCompat.SOURCE_ANY);
            } else if (game.getStanding3() == 1) {
                textView6.setText("CSS");
                textView6.setTextColor(SupportMenu.CATEGORY_MASK);
            } else {
                textView6.setText("SOM");
                textView6.setTextColor(-16776961);
            }
            textView6.setText(String.format("%s wins", new Object[]{textView6.getText()}));
        } else if (game.isOnce() || (game.getScore1() <= 0 && game.getScore2() <= 0)) {
            textView6.setText("No results");
        } else if (game.getScore1() > game.getScore2()) {
            if (game.getCollege1().getCollegeName().equals("CCAD")) {
                textView6.setTextColor(-16711936);
                textView7.setTextColor(-16711936);
            } else if (game.getCollege1().getCollegeName().equals("COS")) {
                textView6.setTextColor(InputDeviceCompat.SOURCE_ANY);
                textView7.setTextColor(InputDeviceCompat.SOURCE_ANY);
            } else if (game.getCollege1().getCollegeName().equals("CSS")) {
                textView6.setTextColor(SupportMenu.CATEGORY_MASK);
                textView7.setTextColor(SupportMenu.CATEGORY_MASK);
            } else {
                textView6.setTextColor(-16711681);
                textView7.setTextColor(-16711681);
            }
            textView6.setText(String.format("%s leads", new Object[]{game.getCollege1().getCollegeName()}));
            textView7.setText(String.format("%d - %d", new Object[]{Integer.valueOf(game.getScore1()), Integer.valueOf(game.getScore2())}));
        } else if (game.getScore1() < game.getScore2()) {
            if (game.getCollege2().getCollegeName().equals("CCAD")) {
                textView6.setTextColor(-16711936);
                textView7.setTextColor(-16711936);
            } else if (game.getCollege2().getCollegeName().equals("COS")) {
                textView6.setTextColor(InputDeviceCompat.SOURCE_ANY);
                textView7.setTextColor(InputDeviceCompat.SOURCE_ANY);
            } else if (game.getCollege2().getCollegeName().equals("CSS")) {
                textView6.setTextColor(SupportMenu.CATEGORY_MASK);
                textView7.setTextColor(SupportMenu.CATEGORY_MASK);
            } else {
                textView6.setTextColor(-16711681);
                textView7.setTextColor(-16711681);
            }
            textView6.setText(String.format("%s leads", new Object[]{game.getCollege2().getCollegeName()}));
            textView7.setText(String.format("%d - %d", new Object[]{Integer.valueOf(game.getScore2()), Integer.valueOf(game.getScore1())}));
        } else {
            textView6.setText("Score tied");
            textView7.setText(String.format("%d - %d", new Object[]{Integer.valueOf(game.getScore2()), Integer.valueOf(game.getScore1())}));
        }
        LinearLayout linearLayout5 = new LinearLayout(this.context);
        linearLayout5.setOrientation(LinearLayout.VERTICAL);
        linearLayout5.addView(textView6);
        linearLayout5.addView(textView7);
        linearLayout.addView(linearLayout5);
        linearLayout.setGravity(17);
        return linearLayout;
    }

    private void setScaledImage(final ImageView imageView, final int i) {
        imageView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = imageView.getMeasuredHeight();
                imageView.setImageBitmap(ELVASchedule.decodeSampledBitmapFromResource(ScheduleActivity.res, i, imageView.getMeasuredWidth(), measuredHeight));
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
