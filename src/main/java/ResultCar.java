public class ResultCar {

    private static final String MOVEMENT_PRINT_CHARACTER = "-";

    private final int movement;

    private ResultCar(int movement) {
        this.movement = movement;
    }

    public static ResultCar of(Car car) {
        return new ResultCar(car.getMovement());
    }

    public String getMovementToString() {
        return MOVEMENT_PRINT_CHARACTER.repeat(Math.max(0, movement));
    }

}
