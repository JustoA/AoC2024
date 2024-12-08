package main.day5;

import main.common.InputParser;

import java.util.ArrayList;

public class Day5Parser extends InputParser {
    ArrayList<PrintingRule> rules = new ArrayList<>();
    ArrayList<PrintingJob> jobs = new ArrayList<>();
    public Day5Parser(String filepath) {
        super(filepath);
        boolean makinRules = true;
        for(String line : fileContentByLine){
            if ("".equals(line)){
                makinRules = false;
                continue;
                }
            if (makinRules){
                rules.add(new PrintingRule(line));
            }
            else {
                jobs.add(new PrintingJob(line));
            }
            }
        }
    }

