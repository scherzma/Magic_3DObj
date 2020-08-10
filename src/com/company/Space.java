package com.company;

import java.util.Random;

public class Space {
    public boolean[][][] space;
    private int percentFilled;
    private Random rand = new Random();


    public Space(int size, int percentFilled){
        space = new boolean[size][size][size];
        this.percentFilled = percentFilled;
        fillSpace();
    }

    private void fillSpace(){

        for(boolean[][]i : space){
            for(boolean[] j : i){
                for(int k = 0; k < j.length; k++){
                    if(rand.nextInt(100) < percentFilled){
                        j[k] = true;
                    }else{
                        j[k] = false;
                    }
                }
            }
        }

    }

    public String singlePlaneString(int planeN, boolean[][][] space){
        boolean[][] plane = space[planeN];

        StringBuilder ret = new StringBuilder();

        for(boolean[] i : plane){
            for(boolean j : i){
                ret.append("[");
                ret.append(j ? "X" : "O");
                ret.append("]");
            }
            ret.append("\n");
        }

        return ret.toString();
    }

    public String singlePlaneString(int planeN){
        return singlePlaneString(planeN, this.space);
    }

    public String planesString(boolean[][][] space){
        StringBuilder ret = new StringBuilder();

        for(int i = 0; i < space.length; i++){
            ret.append(singlePlaneString(i, space));
            ret.append("_".repeat(space.length*3) + "\n");
        }

        return ret.toString();
    }

    public String planesString(){
        return planesString(this.space);
    }

}
