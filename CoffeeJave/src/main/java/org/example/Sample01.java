package org.example;

import java.util.Scanner;

public class Sample01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入年份");
        int year = scanner.nextInt();
        System.out.println("請輸入月份");
        int month = scanner.nextInt();
        System.out.println("請輸入日期");
        int day = scanner.nextInt();

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapYear = (year % 4  == 0);
        if (leapYear) {
            days[1] = 29;
        }

        int result = 0;
        for (int i = 0; i < month; i++){
            result += days[i];
        }
        System.out.println(result + day);
    }
}
