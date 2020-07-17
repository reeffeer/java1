public class Animal {
    public int maxRunDistance;
    public double maxJumpHeight;
    public double maxSwimDistance;


    public Animal(int maxRunDistance, double maxJumpHeight, double maxSwimDistance) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;

    }

    void run(int runDistance) {
        if (runDistance <= maxRunDistance) {
            System.out.println("run: " + true);
        } else {
            System.out.println("run: " + false);
        }
    }

     void jump (double jumpHeight) {
        if (jumpHeight <= maxJumpHeight) {
            System.out.println("jump: " + true);
        } else {
            System.out.println("jump: " + false);
        }
    }

    void swim (double swimDistance) {
        if (swimDistance <= maxSwimDistance && swimDistance > 0) { //второе условие поставил для подстраховки на случай, если создадим класс Попугай, которого представитель не умеет плавать, и забудем в самом классе указать false при любом параметре maxSwimDistance
            System.out.println("swim: " + true);
        } else {
            System.out.println("swim: " + false);
        }

    }

}
