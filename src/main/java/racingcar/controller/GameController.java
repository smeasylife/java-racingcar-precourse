package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.validator.Validator;
import racingcar.view.ErrorMessage;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

import java.util.ArrayList;
import java.util.List;


public class GameController {
    private int repeatStep;
    private InputMessage inputMessage = new InputMessage();
    private ErrorMessage errorMessage = new ErrorMessage();
    private OutputMessage outputMessage = new OutputMessage();
    Validator validator = new Validator();
    CarRepository carRepository;

    public void gameStarter() {
        carRepository = new CarRepository(generateCarList());
        getRepeatStep();
        play();
        printWinner();
    }

    private List<Car> generateCarList() {
        inputMessage.printInputNameMessage();
        String[] carNames = getCarNames();
        validateCarNames(carNames);
        return stringArrayToCarList(carNames);
    }

    private List<Car> stringArrayToCarList(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    private void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            try {
                validator.validateNames(name);
            } catch (IllegalArgumentException e) {
                errorMessage.nameErrorMessage();
                generateCarList();
            }
        }
    }

    private String[] getCarNames() {
        String input = Console.readLine();
        return input.split(",");
    }

    private void getRepeatStep() {
        inputMessage.printInputRepeatStepMessage();
        String strOfRepeatStep = Console.readLine();
        checkRepeatStepIsNum(strOfRepeatStep);
        repeatStep = Integer.parseInt(strOfRepeatStep);
    }

    private void checkRepeatStepIsNum(String str) {
        try {
            validator.validateStringIsNum(str);
        } catch (IllegalArgumentException e) {
            errorMessage.NotNumberErrorMessage();
            getRepeatStep();
        }
    }

    private void play() {
        outputMessage.printStartPlayMessage();
        for (int i = 0; repeatStep > i; i++) {
            game();
            System.out.println();
        }
    }

    private void game() {
        List<Car> carList = carRepository.getCarList();
        carList.stream()
                .forEach(car -> {
                    car.goFoward();
                });
    }

    private void printWinner() {
        int maxPosition = getMaxPosition();
        outputMessage.printEndMessage(getWinnerNames(maxPosition));
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : carRepository.getCarList()) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private String getWinnerNames(int maxPosition) {
        List<String> winnerNames = new ArrayList<>();
        carRepository.getCarList().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .forEach(car -> winnerNames.add(car.getName()));
        return String.join(", ", winnerNames);
    }
}
