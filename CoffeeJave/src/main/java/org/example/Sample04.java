package org.example;

public class Sample04 {
    public static void printStars(int space, int stars){
        String result = "";
        for (int i = 0; i < space; i++){
            result += " ";
        }
        for (int i = 0; i < stars; i++){
            result += "*";
        }
        System.out.println(result);
    }
    public static void pyramid(int n){
        int stars = 1;
        int space = n - 1;
        while ( space >= 0 ){
            printStars(space, stars);
            space--;
            stars += 2;
        }
    }

    public static void main(String[] args) {
        pyramid(1);
        System.out.println("========================");
        pyramid(3);
        System.out.println("========================");
        pyramid(5);
    }
}
