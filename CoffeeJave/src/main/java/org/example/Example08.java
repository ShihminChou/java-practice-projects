package org.example;

public class Example08 {
    public  static boolean findDuplicate(int[] arr){
        for (int i = 0; i < arr.length; i++ ){
            for (int j = i + 1; j < arr.length; j++ ){
                if ( arr[i] == arr[j] ){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println( findDuplicate(new int[] {1, 3, 5, 7, 9, 3}));
        System.out.println( findDuplicate(new int[] {})); // returns false
        System.out.println( findDuplicate(new int[] {3, 4, 5, 6, 7, 10000, 0}));
    }
}
