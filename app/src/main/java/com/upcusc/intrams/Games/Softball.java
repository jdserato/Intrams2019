package com.upcusc.intrams.Games;

import com.upcusc.intrams.R;
import com.upcusc.intrams.College;
import com.upcusc.intrams.Game;
import java.util.Date;

public class Softball extends Game {
    public Softball(College college, College college2, Date date, int i, int i2, int i3, int i4) {
        super("Softball", false, true, college, college2, date, i, i2, i3, i4, R.drawable.softball);
    }
}
