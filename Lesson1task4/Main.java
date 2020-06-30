public class Main {

    public static void main(String[] args) {
        System.out.println(checkInterval(6, 11));
    }
    public static boolean checkInterval(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else
            return false;
    }
}
