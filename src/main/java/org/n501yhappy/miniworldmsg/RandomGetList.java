package org.n501yhappy.miniworldmsg;

import java.util.List;
import java.util.Random;

public class RandomGetList {
    public static String get(List<String> sl){
        Random rand = new Random();
        int index = rand.nextInt(sl.size());
        return sl.get(index);
    }
}
