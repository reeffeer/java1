package LessonSeven.homework;


public class Cat {

    private String name;
    private int appetite;
    public boolean full;

    public Cat(String name, int appetite, boolean full) {
        this.name = name;
        this.appetite = appetite;
        this.full = full;
    }

    public void eat(Plate plate) {
        plate.decreaseFood(appetite);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAppetite() {

        return appetite;
    }

    public void setAppetite(int appetite) {

        this.appetite = appetite;
    }


   
}
