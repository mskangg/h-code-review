package racingcar.exception;

import racingcar.domain.Car;

public class NameLengthException extends RuntimeException{
    public NameLengthException(String name) {
        super(String.format("이름이 %d글자로 너무 깁니다. 최대 %d글자 이하여야 합니다.", name.length(), Car.NAME_MAX_LEN));
    }
}
