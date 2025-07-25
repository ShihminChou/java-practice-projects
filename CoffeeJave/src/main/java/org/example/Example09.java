package org.example;

public class Example09 {
    public static void pyramid(int n){
        String s = "";
        for( int i = 1; i <= n; i++ ){
            s += "*";
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        pyramid(1);
        System.out.println("====================");
        pyramid(3);
        System.out.println("====================");
        pyramid(5);
    }
}
