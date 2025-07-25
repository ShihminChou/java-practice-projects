package org.example;

public class Example03 {
    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] array = {4, 3, 6, 7, 9, 10, 33, 0, -4, 12, 400, 133, 324, 1234231, 12334};
        System.out.println(findMax(array));
    }
}
