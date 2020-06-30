public class Main {

    public static void main(String[] args) {
	    vYear(2024);
    }

    public static void vYear(int year) {
        if (year % 400 == 0) {
            System.out.println(year + " - високосный год.");
        } else if (year % 100 == 0) {
            System.out.println(year + " - невисокосный год.");
        } else if (year % 4 == 0) {
            System.out.println(year + " - високосный год.");
        } else
            System.out.println(year + " - невисокосный год.");
    }
}
