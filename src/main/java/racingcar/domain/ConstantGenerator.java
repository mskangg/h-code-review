package racingcar.domain;

public class ConstantGenerator implements NumberGenerator{

    private final int constant;

    private ConstantGenerator(int constant) {
        this.constant = constant;
    }

    public static ConstantGenerator of(int constant) {
        return new ConstantGenerator(constant);
    }

    @Override
    public int getNumber() {
        return constant;
    }
}
