package org.example;

import java.util.Scanner;

public class Sample02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入a: ");
        int a = scanner.nextInt();
        System.out.println("請輸入n: ");
        int n = scanner.nextInt();

        int result = 0;
        for (int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                result += (int) (a * Math.pow(10, j));
            }
        }
        // a+aa+aaa+....a(n)
        System.out.println("計算結果為: " + result);
    }
}
