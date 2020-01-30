package com.upcusc.intrams.Games;

import com.upcusc.intrams.R;
import com.upcusc.intrams.Game;
import java.util.Date;

public class Rubiks extends Game {
    public Rubiks(Date date, int i, int i2, int i3, int i4) {
        super("Rubik's Cube", null, null, null, null, true, false, 0, 0, i, i2, i3, i4, date, R.drawable.rubiks);
    }
}
