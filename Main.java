import java.awt.event.ActionEvent;

public class Main {
    private static int[] array;

    public static void main(String[] args) {

        new MyWindow();

       /* array = new int[15];
        array();
        maxMinAvgInArray();
        isPrimeNumber();*/

    }

    //Task 1
    public static void array() {

        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * array.length);
            System.out.println(array[i]);
        }
    }
    public static void maxMinAvgInArray() {
        int max = array[0];
        int min = array[0];
        int summ = 0;

        for(int i = 0; i < array.length; i++) {

            if (max < array[i]) {
                max = array[i];
            }
            if (min >array[i]) {
                min = array[i];
            }
            summ = array[i] + summ;
        }
        System.out.println("Минимальное число в массиве: " + min);
        System.out.println("Максимальное число в массиве: " + max);
        System.out.println("Среднее значение массива: " + summ / array.length);

    }

    //Task 2
    public static void isPrimeNumber() {



    }



}
