public class Cat extends Animal {

    public Cat(int maxRunDistance, double maxJumpHeight, double maxSwimDistance) {
        super(maxRunDistance, maxJumpHeight, maxSwimDistance);
    }

    @Override
    public void run(int runDistance) {
            super.run(runDistance);
    }

    @Override
    public void jump(double jumpHeight) {
        super.jump(jumpHeight);
    }


    void swim (double swimDistance) {
        System.out.println("swim: " + false);
    }
}
