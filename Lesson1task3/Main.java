public class Main {

    public static void main(String[] args) {

        System.out.println(calculate(1, 2, 3, 4));
    }




    public static float calculate(float a, float b, float c, float d) {
        return (a * (b + (c / d)));
    }
}
