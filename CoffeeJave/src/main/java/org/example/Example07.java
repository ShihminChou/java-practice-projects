package org.example;

public class Example07 {
    public static boolean confirmEnding(String s1, String s2){
        int j = s1.length() -1;
        for (int i = s2.length()-1; i>=0; i--) {
            if(s2.charAt(i) != s1.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(confirmEnding("Bastian", "n"));
        System.out.println(confirmEnding("Connor", "n"));
        System.out.println(confirmEnding("Open sesame", "same"));
    }
}
