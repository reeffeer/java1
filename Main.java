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
        System.out.println("Аппетит кота " + oneOfTheCats.getName() + ": " + oneOfTheCats.getAppetite() + ".");
        oneOfTheCats.eat(plate1); //кот ест или не ест (в методе сказано)

        if (foodCount - oneOfTheCats.getAppetite() >= 0) {//если в тарелке достаточно еды (остается что-то после того, как кот поел, или только-только для утоления голода)
            oneOfTheCats.full = true; //кот сыт
            oneOfTheCats.setAppetite(0); //аппетит исчез
            System.out.println(oneOfTheCats.getName() + " сыт: " + oneOfTheCats.full + ".");
        } else {
            oneOfTheCats.full = false; //кот голоден
            oneOfTheCats.setAppetite(oneOfTheCats.getAppetite()); //аппетит остался,
            System.out.println(oneOfTheCats.getName() + " сыт: " + oneOfTheCats.full + ". " + oneOfTheCats.getName() + " все еще голоден.");
        }
        System.out.println("Аппетит кота " + oneOfTheCats.getName() + ": " + oneOfTheCats.getAppetite() + ".");
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
