package com.example.udion.infiscroll;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by udion on 7/10/17.
 */

public class ListMaker {
    public static List<List<String>> getStrings(){
        List<String> r1 =new ArrayList<String>();
        List<String> r2 =new ArrayList<String>();
        List<String> r3 =new ArrayList<String>();

        for(int i=0; i<1000; i++){
            String s = "test"+i;
            r1.add(s);
            s = "udion"+i;
            r2.add(s);
            s = "post"+i;
            r3.add(s);
        }
        List<List<String>> t = new ArrayList<>();
        for(int i=0; i<1000; i++){
            List<String> k = new ArrayList<String>();
            k.add(r1.get(i));
            k.add(r2.get(i));
            k.add(r3.get(i));
            t.add(k);
        }
        return t;
    }
}
