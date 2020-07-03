import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        maxAndMinNumbInArray();
    }


    //задание 1
    public static void invertArray() {
                int[] arr = { 1, 0, 1, 0, 0, 1 };
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == 1) {
                        arr[i] = 0;
                    } else {
                        arr[i] = 1;
                    }

                    }
                }

    //задание 2
    public static void fillArray() {
        int [] array = new int[8];
        for(int i = 0; i < array.length; i++) {
            array[i] = array[i] * 3;

        }
    }

    //задание 3
    public static void changeArray() {
        int[] w = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < w.length; i++) {
            if (w[i] < 6) {
               w[i] = w[i] * 2;
            }

        }
    }


    //задание 4
    public static void fillDiagonal() {
        int[][] duoArray = new int[5][5];
        for (int i = 0; i < duoArray.length; i++) {
            for (int j = 0; j < duoArray.length; j++) {
                if(i==j || duoArray.length-i == j+1) {
                    duoArray[i][j] = duoArray[i][duoArray.length - i - 1] = 1;
                }
            }
        }
    }


    //задание 5
    public static void maxAndMinNumbInArray() {
        int [] arr = { 1, 3, 15, 6 };
        arr[0] = 1;
        for (int i = 1; i <= arr.length; i++) {
            if (arr[i] < arr[i+1] || arr[i] < arr[i-1]) {
               arr[i] = arr[i+1]; //System.out.println(arr[i+1]);
               arr[i] = arr[i-1]; //System.out.println(arr[i-1]);
            }
        }
    }


  //к сожалению, не успеваю. но все равно выполню эти задания.
    //задание 6
    //задание 7


}










