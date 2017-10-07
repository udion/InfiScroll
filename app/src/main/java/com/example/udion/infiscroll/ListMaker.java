package com.example.udion.infiscroll;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by udion on 7/10/17.
 */

public class ListMaker {
    public static List<List<String>> getStrings(){
        List<String> r1 =new ArrayList<String>();
        List<String> r2 =new ArrayList<String>();
        List<String> r3 =new ArrayList<String>();
        List<String> r4 =new ArrayList<String>();
        List<String> r5 =new ArrayList<String>();

        for(int i=0; i<1000; i++){
            r1.add("udion"+i);
            r2.add("post"+i);
            r3.add("time"+i);
            r4.add("comment"+i);
            r5.add(""+i);
        }
        List<List<String>> t = new ArrayList<>();
        for(int i=0; i<1000; i++){
            List<String> k = new ArrayList<String>();
            k.add(r1.get(i));
            k.add(r2.get(i));
            k.add(r3.get(i));
            k.add(r4.get(i));
            k.add(r5.get(i));
            t.add(k);
        }
        return t;
    }
}
