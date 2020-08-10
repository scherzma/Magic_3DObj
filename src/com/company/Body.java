package com.company;

public class Body {

    public boolean[][][] space;
    public int size = 0;
    public int[] koord = new int[3];

    public Body(boolean[][][] space, int i, int j, int k){
        this.space = space;
        this.size = size;
        koord[0] = i;
        koord[1] = j;
        koord[2] = k;
    }

}
