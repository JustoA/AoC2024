package main.day5;

import java.util.ArrayList;

public class Day5Part1Solver {
    Day5Parser parser;
    ArrayList<PrintingRule> rules;
    ArrayList<PrintingJob> jobs;
    public Day5Part1Solver(Day5Parser parser){
        this.parser = parser;
        this.rules = parser.rules;
        this.jobs = parser.jobs;
    }
    public int solve() {
        int answer = 0;
        // loop to know whether a rule is broken
        boolean ok = true;
        for (PrintingJob job: jobs){
            for (PrintingRule rule : rules){
                if (rule.isViolatedByJob(job)){
                    ok = false;
                    break;
                }
            }
            if (ok) answer+=job.getMiddlePage();
            ok = true;
        }

        return answer;
    }
}
