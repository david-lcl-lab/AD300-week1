package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GradesToolBox {

    public GradesToolBox() {
    }

    /**
     * Calculates the GPA given a percentage range.
     * This method expects a percentage range formatted like "95.0% to 90.0%"
     *
     * @param pctRange The percent range of the grade.
     * @exception NumberFormatException if input string is not well-formed or empty
     * @return the GPA as a String
     */
    public String pctToGpaIf(String pctRange){

        if(!pctRange.isEmpty()){
            String regex = "to\\s*(\\d+\\.?\\d*)";  // filter digits after 'to'
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(pctRange);
            double pct;// = -1.0;
            if (matcher.find()) {                
                pct = Double.parseDouble(matcher.group(1));
            }
            else {
                throw new NumberFormatException();
            }            
            if (pct >= 95.0) {
                return "4.0";
            } else if (pct >= 94.0) {
                return "3.9";
            } else if (pct >= 93.0) {
                return "3.8";
            } else if (pct >= 92.0) {
                return "3.7";
            } else if (pct >= 91.0) {
                return "3.6";
            } else if (pct >= 90.0) {
                return "3.5";
            } else if (pct >= 89.0) {
                return "3.4";
            } else if (pct >= 88.0) {
                return "3.3";
            } else if (pct >= 87.0) {
                return "3.2";
            } else if (pct >= 86.0) {
                return "3.1";
            } else if (pct >= 85.0) {
                return "3.0";
            } else if (pct >= 84.0) {
                return "2.9";
            } else if (pct >= 83.0) {
                return "2.8";
            } else if (pct >= 82.0) {
                return "2.7";
            } else if (pct >= 81.0) {
                return "2.6";
            } else if (pct >= 80.0) {
                return "2.5";
            } else if (pct >= 79.0) {
                return "2.4";
            } else if (pct >= 78.0) {
                return "2.3";
            } else if (pct >= 77.0) {
                return "2.2";
            } else if (pct >= 76.0) {
                return "2.1";
            } else if (pct >= 75.0) {
                return "2.0";
            } else if (pct >= 74.0) {
                return "1.9";
            } else if (pct >= 73.0) {
                return "1.8";
            } else if (pct >= 72.0) {
                return "1.7";
            } else if (pct >= 71.0) {
                return "1.6";
            } else if (pct >= 70.0) {
                return "1.5";
            } else if (pct >= 69.0) {
                return "1.4";
            } else if (pct >= 68.0) {
                return "1.3";
            } else if (pct >= 67.0) {
                return "1.2";
            } else if (pct >= 66.0) {
                return "1.1";
            } else if (pct >= 65.0) {
                return "1.0";
            } else {
                return "0.0"; // Below 65% GPA is 0.0
            }
        }
        else{
            throw new NumberFormatException("Empty input string");
        }
    }


    /**
     * Calculates the percentage range when given a GPA.
     *
     * @param gpaScore grade point represented from 0 to 4.0.
     * @exception NumberFormatException if input string is not well-formed or empty
     * @return the grade as a percent range
     */
    public String gpaToPctSwitch(String gpaScore){
       double gpaScoreDouble = Double.parseDouble(gpaScore);
        if ((Double.isNaN(gpaScoreDouble))|(gpaScoreDouble < 0.0)|(gpaScoreDouble > 4.0)){
           throw new NumberFormatException("Invalid input");
       }
        int adjScore = (int)(10*gpaScoreDouble); //shift left for integer conversion

        return switch (adjScore) {
            case 40 -> "100.0% to 95.0%";
            case 39 -> "<95.0% to 94.0%";
            case 38 -> "<94.0% to 93.0%";
            case 37 -> "<93.0% to 92.0%";
            case 36 -> "<92.0% to 91.0%";
            case 35 -> "<91.0% to 90.0%";
            case 34 -> "<90.0% to 89.0%";
            case 33 -> "<89.0% to 88.0%";
            case 32 -> "<88.0% to 87.0%";
            case 31 -> "<87.0% to 86.0%";
            case 30 -> "<86.0% to 85.0%";
            case 29 -> "<85.0% to 84.0%";
            case 28 -> "<84.0% to 83.0%";
            case 27 -> "<83.0% to 82.0%";
            case 26 -> "<82.0% to 81.0%";
            case 25 -> "<81.0% to 80.0%";
            case 24 -> "<80.0% to 79.0%";
            case 23 -> "<79.0% to 78.0%";
            case 22 -> "<78.0% to 77.0%";
            case 21 -> "<77.0% to 76.0%";
            case 20 -> "<76.0% to 75.0%";
            case 19 -> "<75.0% to 74.0%";
            case 18 -> "<74.0% to 73.0%";
            case 17 -> "<73.0% to 72%.0";
            case 16 -> "<72.0% to 71.0%";
            case 15 -> "<71.0% to 70.0%";
            case 14 -> "<70.0% to 69.0%";
            case 13 -> "<69.0% to 68.0%";
            case 12 -> "<68.0% to 67.0%";
            case 11 -> "<67.0% to 66.0%";
            case 10 -> "<66.0% to 65.0%";
            case 0 -> "<65.0% to 0%";
            default -> throw new NumberFormatException("Invalid input");
        };
    }
}
