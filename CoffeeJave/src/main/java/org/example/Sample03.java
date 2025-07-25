package org.example;

public class Sample03 {
    public static int[] rightShift(int[] arr, int n){
        for (int k = 1; k <= n; k++){
            rightShiftOnce(arr);
        }
        return arr;
    }

    public static void rightShiftOnce(int[] arr){
        int lastElement = arr[arr.length-1];
        for(int i = arr.length-1; i >=1; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = lastElement;
    }

    public static void main(String[] args) {
        int[] newArr = rightShift(new int[] {4, 21, 4, 3, 6, 7, 12, 43, 11, 233}, 1);
        for (int i : newArr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("==========================");
        int[] newArr2 = rightShift(new int[] {4, 21, 4, 3, 6, 7, 12, 43, 11, 233}, 4);
        for (int i : newArr2) {
            System.out.print(i + " ");
        }
    }
}
