package racingcar;

public class Random {

    private final static int MAX = 9;
    private final java.util.Random random;

    public Random() {
        random = new java.util.Random();
    }

    public int getNumber() {
        return random.nextInt(MAX+1);
    }
}
