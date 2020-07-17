public class Dog extends Animal {

    public Dog(int maxRunDistance, double maxJumpHeight, double maxSwimDistance) {
        super(maxRunDistance, maxJumpHeight, maxSwimDistance);
    }

    @Override
    public void run(int runDistance) {
            super.run(runDistance);
    }

    @Override
    void jump(double jumpHeight) {
        super.jump(jumpHeight);
    }

    @Override
    void swim (double swimDistance) {
        super.swim(swimDistance);
    }



}
