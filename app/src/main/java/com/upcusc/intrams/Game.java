package com.upcusc.intrams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Game {
    private College college1;
    private College college2;
    private College college3;
    private College college4;
    private List<Game> games;
    private boolean isMajor;
    private int ivRes;
    private boolean once;
    private int score1;
    private int score2;
    private String sport;
    private int standing1;
    private int standing2;
    private int standing3;
    private int standing4;
    private Date time;

    public Game(String str, College college, College college5, College college6, College college7, boolean z, boolean z2, int i, int i2, int i3, int i4, int i5, int i6, Date date, int i7) {
        this.sport = str;
        this.college1 = college;
        this.college2 = college5;
        this.college3 = college6;
        this.college4 = college7;
        this.once = z;
        this.isMajor = z2;
        this.score1 = i;
        this.score2 = i2;
        this.standing1 = i3;
        this.standing2 = i4;
        this.standing3 = i5;
        this.standing4 = i6;
        this.time = date;
        this.games = new ArrayList();
        this.ivRes = i7;
    }

    public Game(String str, boolean z, boolean z2, College college, College college5, Date date, int i, int i2, int i3, int i4, int i5) {
        this(str, college, college5, null, null, z, z2, i, i2, i3, i4, 0, 0, date, i5);
    }

    public String getSport() {
        return this.sport;
    }

    public College getCollege1() {
        return this.college1;
    }

    public College getCollege2() {
        return this.college2;
    }

    public int getScore1() {
        return this.score1;
    }

    public int getScore2() {
        return this.score2;
    }

    public boolean isMajor() {
        return this.isMajor;
    }

    public boolean isOnce() {
        return this.once;
    }

    public College getCollege3() {
        return this.college3;
    }

    public College getCollege4() {
        return this.college4;
    }

    public int getStanding1() {
        return this.standing1;
    }

    public int getStanding2() {
        return this.standing2;
    }

    public int getStanding3() {
        return this.standing3;
    }

    public int getStanding4() {
        return this.standing4;
    }

    /* access modifiers changed from: 0000 */
    public void addSubGame(Game game) {
        this.games.add(game);
    }

    public List<Game> getGames() {
        return this.games;
    }

    /* access modifiers changed from: 0000 */
    public void clear() {
        this.games = new ArrayList();
    }

    public Date getTime() {
        return this.time;
    }

    public int getIvRes() {
        return this.ivRes;
    }
}
