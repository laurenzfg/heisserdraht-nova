package io.github.laufi.heisserdraht.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Highscore implements Serializable{
    private static final long serialVersionUID = -1L;
    private List<HighscoreEintrag> score = new ArrayList<HighscoreEintrag>();
    public void addScore(HighscoreEintrag score){
        this.score.add(score);
    }
    public HighscoreEintrag getScore (int nummer) {
        return this.score.get(nummer);
    }
    public void sortScore(Comparator comparator){
        Collections.sort(this.score, comparator);
    }
    public HighscoreEintrag[] top (int top){
        sortScore(new HighscoreEintragAbsteigendComparator());
        HighscoreEintrag[] ergebnis = new HighscoreEintrag[20];
        for (int i=0; i < 20; i++){
            try {
                ergebnis[i] = getScore(i);
            } catch (IndexOutOfBoundsException e){
                ergebnis[i] = new HighscoreEintrag(0);
            }
        }
        return  ergebnis;
    }
}