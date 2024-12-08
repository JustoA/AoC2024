package main.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintingJob {
    public ArrayList<Integer> pages = new ArrayList<>();
    public PrintingJob(String job){
        //holy fuck
        pages.addAll(Arrays.stream(job.split(",")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new)));
    }
    public Integer getMiddlePage(){
        if (!this.pages.isEmpty()){
            // thank you java for rounding down
            return this.pages.get(this.pages.size()/2);
        }
        else return 0;
    }

    public void swap(Integer a, Integer b){
        if (!this.pages.isEmpty() && this.pages.contains(a) && this.pages.contains(b)){
            int indexOfA = this.pages.indexOf(a);
            int indexOfB = this.pages.indexOf(b);
            this.pages.set(indexOfA, b);
            this.pages.set(indexOfB, a);
        }
    }


}
