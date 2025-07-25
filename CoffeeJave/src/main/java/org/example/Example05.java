package org.example;

public class Example05 {
//    public static int addUpTo(int n) {
//        int result = 0;
//        for (int i=0; i<=n; i++){
//            result += i;
//        }
//        return result;
//    }

    public static int addUpTo(int n) {
        return ((1 + n) * n / 2); // 等差級數：首項＋末項＊項數/2
    }

    public static void main(String[] args) {
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(100));
        System.out.println(addUpTo(1000));
        System.out.println(addUpTo(10000));
    }
}
