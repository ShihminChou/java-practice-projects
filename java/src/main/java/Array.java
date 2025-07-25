import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] intArray = new int[3];

        intArray[0] = 10;
        intArray[1] = 20;
        intArray[2] = 99;

        System.out.println(intArray[0]);
        System.out.println(intArray[1]);
        System.out.println(intArray[2]);

        int[] intArray2 = { 10 , 20 , 99 };

        int[] intArr = { 100 , 300 , 666};
        System.out.println(Arrays.toString(intArr));


    }
}
