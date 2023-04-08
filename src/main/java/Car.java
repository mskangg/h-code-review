public class Car {

    private int distance;

    public Car() {
        distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int number) {
        if (number >= 4) {
            distance++;
        }
    }

    public void print() {
        System.out.println("-".repeat(distance));
    }
}
