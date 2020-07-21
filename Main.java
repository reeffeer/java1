package LessonSeven;


import LessonSeven.homework.Cat;
import LessonSeven.homework.Plate;

public class Main {

    public static void main(String[] args) {

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Moore", 10, 0);
        cats[1] = new Cat("Mew", 5, 0);
        cats[2] = new Cat("Tom", 15, 0);

        int foodCount = 30;
        Plate plate1 = new Plate(foodCount);

        plate1.info();

        //вызываем один из методов
        // этот
        //oneCatEats(cats, plate1, foodCount);
        //или этот
        catsEat(cats, plate1);

    }

    public static void oneCatEats(Cat[] cats, Plate plate1, int foodCount) {
        Cat oneOfTheCats = cats[0];
        System.out.println("Аппетит кота " + oneOfTheCats.getName() + ": " + oneOfTheCats.getAppetite());
        oneOfTheCats.eat(plate1);
        plate1.info();
        if (oneOfTheCats.getAppetite() - foodCount <= 0) {
            oneOfTheCats.setAppetite(0);
            oneOfTheCats.getFull();
            System.out.println(true);
            System.out.println(oneOfTheCats.getName() + " наелся.");
        } else {
            oneOfTheCats.setAppetite(oneOfTheCats.getAppetite());
            oneOfTheCats.setFull(0);
            System.out.println(false);
            System.out.println(oneOfTheCats.getName() + " не поел.");
        }
        System.out.println("Аппетит кота " + oneOfTheCats.getName() + ": " + oneOfTheCats.getAppetite());
    }

    public static void catsEat (Cat[] cats, Plate plate1) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate1);
            System.out.println(cats[i].getName() + " поел.");
            plate1.info();
        }
        System.out.print("Итого: ");
        plate1.info();
    }


}
