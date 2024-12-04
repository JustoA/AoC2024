package main.common;

import java.util.ArrayList;
import java.util.Comparator;

public class Toolbox {

    public static int getSmallestNumberAndRemoveIt(ArrayList<Integer> list){
        Integer smallest = list.stream().min(Comparator.naturalOrder()).get();
        list.remove(smallest);
        return smallest;
    }
}
