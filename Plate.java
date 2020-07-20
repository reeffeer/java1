package LessonSeven.homework;

public class Plate {

    private int food;
    private int newFood;

    public Plate(int food) {
        this.food = food;
        this.newFood = 10;
    }

    public void info() {
        System.out.println("На тарелке " + food + " еды.");
    }

    public void decreaseFood(int appetite) { //если аппетит кота больше количества еды, то кот не ест.
        if (appetite > food) { //Значит, мы игнорируем выполнение задания 2.
            food = food;
            System.out.println("Кот не поел, потому что в тарелке недостаточно еды. " + "Аппетит: " + appetite + ".");
        } else {
            food -= appetite;
        }
    }

    public void addFood(int appetite) { //Создали метод, с помощью которого можно добавлять еду
        if (appetite > food) {
            food += newFood;
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}