public class Main {
    public static void main(String[] args) {
        negativeOrNot(-46);
    }

    public static void negativeOrNot(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else
            System.out.println("Число отрицательное");
    }
}
