package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class SpaceObject {

    private boolean[][][] space;
    public ArrayList<Body> objects;
    public HashMap<Integer, Body> objectsBySize;
    int count;

    public SpaceObject(boolean[][][] space){
        this.space = copyOf3Dim(space);
        objects = new ArrayList<>();
        getObjects();
    }

    public boolean[][][] copyOf3Dim(boolean[][][] array) {
        boolean[][][] copy;
        copy = new boolean[array.length][][];
        for (int i = 0; i < array.length; i++) {
            copy[i] = new boolean[array[i].length][];
            for (int j = 0; j < array[i].length; j++) {
                copy[i][j] = new boolean[array[i][j].length];
                System.arraycopy(array[i][j], 0, copy[i][j], 0,
                        array[i][j].length);
            }
        }
        return copy;
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
        space[i][j][k] = false;
        int[] dirs = new int[]{-1,0,1};

        Body body = new Body(new boolean[space.length][space.length][space.length],i,j,k);
        Stack<int[]> st = new Stack<>();
        st.add(new int[]{i,j,k});

        while(!st.empty()){
            int[] coord = st.pop();
            i = coord[0];
            j = coord[1];
            k = coord[2];

            body.space[i][j][k] = true;
            body.size++;

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
                        if(space[i + a][j + b][k + c]){
                            st.add(new int[]{i + a, j + b, k + c});
                            space[i + a][j + b][k + c] = false;
                        }
                    }
                }
            }
        }

        //System.out.println(body.size);
        //objectsBySize.put(body.size, body);
        objects.add(body);
        if(count < body.size){
            count = body.size;
        }

    }
}
