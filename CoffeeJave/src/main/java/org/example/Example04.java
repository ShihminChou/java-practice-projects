package org.example;

public class Example04 {
    public static int[] reverseArray(int[] arr){
        int[] newArray = new int[arr.length];
        int j = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            newArray[j] = arr[i];
            j++;
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 6, 7, 9, 10, 33, 0, -4, 12, 400, 133, 324, 1234231, 12334};
        int[] reversedArray = reverseArray(array);
        for (int i : reversedArray) {
            System.out.print(i + " ");
        }
    }
}
