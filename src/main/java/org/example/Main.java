package org.example;

public class Main {
    public static void main(String[] args) {
       GradesToolBox gradesToolBox = new GradesToolBox();
       System.out.println(gradesToolBox.gpaToPctSwitch("4.0"));
       System.out.println(gradesToolBox.pctToGpaIf("95.0% to 90.1%"));

    }
}