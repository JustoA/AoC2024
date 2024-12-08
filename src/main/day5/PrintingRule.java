package main.day5;

public class PrintingRule {
    int before;
    int after;
    public PrintingRule(String unparsedRule){
        this.before =  Integer.parseInt(unparsedRule.split("\\|")[0]);
        this.after  =  Integer.parseInt(unparsedRule.split("\\|")[1]);
    }

    public boolean isViolatedByJob(PrintingJob job){
        // check if both numbers are present in job, if not we don't care.
        if (job.pages.contains(before) && job.pages.contains(after)){
            return job.pages.indexOf(before) > job.pages.indexOf(after);
        }
        return false;
    }

}
