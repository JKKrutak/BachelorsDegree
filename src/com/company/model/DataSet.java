package com.company.model;
import java.util.Random;


public class DataSet {
    private int size;
    private String[] names = new String[] {"Sienna","Harold","Dwight","Manfred","Wilona","Walter","Todd","Lee","Lara","Celeste"};
    private String[] surrnames = new String[] {"Hum","Schneider","Greene","Johnston","Currey","Elliott","Mann","Ray","Frazier","Tenny"};
    private int[] ages = new int[] {18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44};
    private String[] states = new String[] {"Alabama","Alaska","Arizona","Arkansas","Califorania","Colorado",
            "Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas",
            "Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi",
            "Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New mexico","New York",
            "North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina",
            "South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin",
            "Wyoming"};


    private String[] randomNames;
    private String[] randomSurrnames;
    private int[] randomAges;
    private String[] randomStates;



    public String[] getRandomNames() {
        return randomNames;
    }

    public String[] getRandomSurrnames() {
        return randomSurrnames;
    }

    public int[] getRandomAges() {
        return randomAges;
    }

    public String[] getRandomStates() {
        return randomStates;
    }

    public int getSize() {
        return size;
    }

    public DataSet(int size) {
        this.size = size;
        Random rand = new Random();
        randomNames = new String[size];
        randomSurrnames = new String[size];
        randomAges = new int[size];
        randomStates = new String[size];

        for(int i = 0; i < size; i++) {
            randomNames[i] = names[rand.nextInt(names.length)];
            randomSurrnames[i] = surrnames[rand.nextInt(surrnames.length)];
            randomAges[i] = ages[rand.nextInt(ages.length)];
            randomStates[i] = states[rand.nextInt(states.length)];
        }
    }
}