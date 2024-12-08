package main.day5;

import java.util.ArrayList;

public class Day5Part2Solver {
    Day5Parser parser;
    ArrayList<PrintingRule> rules;
    ArrayList<PrintingJob> jobs;
    ArrayList<PrintingJob> naughtyJobs = new ArrayList<>();
    public Day5Part2Solver(Day5Parser parser){
        this.parser = parser;
        this.rules = parser.rules;
        this.jobs = parser.jobs;
    }
    public int solve() {
        int answer = 0;
        // loop to know whether a rule is broken
        for (PrintingJob job: jobs){
            for (PrintingRule rule : rules) {
                if (rule.isViolatedByJob(job)) {
                    naughtyJobs.add(job);
                    break;
                }
            }
        }

        for (PrintingJob naughtyJob : naughtyJobs){
            boolean allGood = false;
            while(!allGood) {
                allGood = true;
                for (PrintingRule rule : rules) {
                    if (rule.isViolatedByJob(naughtyJob)) {
                        naughtyJob.swap(rule.before, rule.after);
                        allGood = false;
                    }
                }
            }
        }

        for (PrintingJob niceJob : naughtyJobs){
            answer += niceJob.getMiddlePage();
        }

        return answer;
    }
}
