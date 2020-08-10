package com.company;

import java.util.ArrayList;

public class SpaceObject {

    private boolean[][][] space;
    public ArrayList<Body> objects;
    int count;

    public SpaceObject(boolean[][][] space){
        this.space = space.clone();
        objects = new ArrayList<>();
        getObjects();
    }

    private void getObjects(){

        for(int i = 0; i < space.length; i++){
            for(int j = 0; j < space[i].length; j++){
                for(int k = 0; k < space[i][j].length; k++){
                    if(space[i][j][k]){
                        getObject(i, j, k);
                    }
                }
            }
        }

    }

    private void getObject(int i, int j, int k){
        objects.add(new Body(new boolean[space.length][space.length][space.length],i,j,k));
        getObjectRec(i,j,k,objects.get(objects.size()-1));
        if(count < objects.get(objects.size()-1).size){
            count = objects.get(objects.size()-1).size;
        }
    }

    private void getObjectRec(int i, int j, int k, Body body){

        int[] dirs = new int[]{-1,0,1};

        if(space[i][j][k]) {
            body.space[i][j][k] = true;
            body.size++;
            space[i][j][k] = false;


            for (int a : dirs) {
                for (int b : dirs) {
                    for (int c : dirs) {
                        if (a == 0 && b == 0 && c == 0) {
                            continue;
                        } else if (i + a < 0 || i + a > space.length - 1) {
                            continue;
                        } else if (j + b < 0 || j + b > space[i + a].length - 1) {
                            continue;
                        } else if (k + c < 0 || k + c > space[i + a][j + b].length - 1) {
                            continue;
                        }
                        getObjectRec(i + a, j + b, k + c, body);
                    }
                }
            }
        }
    }


}
