public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat (200, 2, 0);
        //if (runDistance <= cat1.maxRunDistance)
        cat1.run(120);
        cat1.jump(3);
        cat1.swim(1);

        Dog dog1 = new Dog(500, 0.5, 10);
        Dog dog2 = new Dog(400, 0.3, 12);
        dog1.run(450);
        dog1.jump(0.2);
        dog1.swim(14);
        dog2.run(450);

    }

}
