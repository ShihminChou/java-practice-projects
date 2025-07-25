package org.example;

import java.lang.reflect.Array;

public class Example06 {
    public static void position(String s){
        boolean isFound = false;
        for (int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.toUpperCase(c) == c){
                System.out.println(c + " " + i);
                return;
            }
        }
        if (!isFound) {
            System.out.println("-1");
        }
    }
    public static void main(String[] args) {
        position("abcd"); // prints -1
        position("AbcD"); // prints A 0
        position("abCD"); // prints C 2
    }
}
