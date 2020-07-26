package LessonSeven.homework;

public class Plate {

    private int food;


    public Plate(int food) {
        this.food = food;

    }

    public void info(int food) {
        System.out.println("На тарелке " + food + " еды.");
    }

    public void decreaseFood(int appetite) { //если аппетит кота больше количества еды, то кот не ест.
        if (food < appetite) { //Значит, мы игнорируем выполнение задания 2.
            System.out.println(" не поел. На тарелке недостаточно еды: " + food + ".");
        } else {
            food -= appetite;
            System.out.println(" поел. На тарелке осталось " + food + " еды.");
        }
    }

    public void addFood(int appetite) { //Создали метод, с помощью которого можно добавлять еду
        if (appetite > food) {
            food += (appetite - food);
            System.out.println("На тарелке " + food + " еды.");
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }


}
