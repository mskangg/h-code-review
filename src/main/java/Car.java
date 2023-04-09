public class Car {

    private int movement;

    private Car(int movement) {
        this.movement = movement;
    }

    public static Car getInstance() {
        return new Car(0);
    }

    public void incrementMovement() {
        movement++;
    }

    public int getMovement() {
        return movement;
    }

}
