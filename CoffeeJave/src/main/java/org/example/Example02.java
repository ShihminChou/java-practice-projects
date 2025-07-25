package org.example;

public class Example02 {
    public static void nineTable(){
        for(int i = 1; i<=9; i++ ){
            for(int j = 1; j<=9; j++ ){
                System.out.println( i + " * " + j + " = " + i*j );
            }
        }
    }
    public static void main(String[] args) {
        nineTable();
    }
}
