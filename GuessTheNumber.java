import java.util.Scanner;
public class GuessTheNumber {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        playGame(9);
        do {
            System.out.println("Хотите сыграть еще? 1 - да. 0 - нет.");
            int input_answer = scanner.nextInt();
            if (input_answer == 1) {
                playGame(9);
            } else {
                System.out.println("Спасибо за игру!");
                break;
            }
        } while (true);
        scanner.close();
    }
    private static void playGame (int range) {
        int number = (int) (Math.random() * range);
        int maxEffort = 3;
        for (int effort = 1; effort <= maxEffort; effort++) {
            System.out.println("Угадайте число от 0 до " + range);
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println("Вы угадали.");
                break;
            } else if (input_number > number) {
                System.out.println("Загаданное число меньше.");
            } else {
                System.out.println("Загаданное число больше.");
            }
            System.out.println("Количество попыток: " + (maxEffort - effort));
            if (maxEffort - effort == 0) {
                System.out.println("Вы проиграли.");
                break;
            }
        }
    }
}
