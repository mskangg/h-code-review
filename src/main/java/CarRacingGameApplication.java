import controller.CarRacingController;
import view.request.CarRacingGameRequest;
import view.result.CarRacingGameResponse;

public class CarRacingGameApplication {

    public static void main(String[] args) {
        CarRacingController controller = new CarRacingController(
                new CarRacingGameRequest(), new CarRacingGameResponse());

        // trace-off : 애플리케이션의 실제 역할은 '실행 가능한 상태까지' 만 이다.
        controller.run();
    }

}
