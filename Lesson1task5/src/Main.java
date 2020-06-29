public class Main {

    public static void main(String[] args) {
        System.out.println(result(-12));
    }
    public static String result(int a) {
        if(a >= 0) {
            return "Число положительное.";
        } else
            return "Число отрицательное.";
    }
}
