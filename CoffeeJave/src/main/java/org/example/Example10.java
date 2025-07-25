package org.example;

public class Example10 {
    public static int findSmallCount(int[] arr, int n){
        int counter = 0;
        for (int i : arr ) {
            if( i < n ){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(findSmallCount(new int[] {1, 2, 3}, 2));
        System.out.println(findSmallCount(new int[] {1, 2, 3, 4, 5}, 0));
    }
}
