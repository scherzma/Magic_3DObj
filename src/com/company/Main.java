package com.company;

public class Main {

    public static void main(String[] args) {
        Space space = new Space(10,20u);
        //System.out.println(space.planesString());
        SpaceObject obj = new SpaceObject(space.space);
        System.out.println("X".repeat(40)+ "\n" + obj.count + "\n");
        System.out.println(obj.objects.size());
        //System.out.println(space.planesString(obj.objects.get(0).space));
    }
}
