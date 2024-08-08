package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.MessageView;

import java.util.ArrayList;
import java.util.List;


public class GameController {
    private static CarList cars = new CarList();
    private static int numOfStep = 0;
    public void gameStarter(){
        generateCarList();
        getNumOfStep();

        play();

        printWinnerAndEnd();
    }
    public static void generateCarList(){
        String input = Console.readLine();
        String[] arr = input.split(",");
        for(String str: arr) {
            try {
                validate(str);
                cars.getCars().add(new Car(str));
            }catch (IllegalArgumentException e){
                MessageView.nameErrorMessage();
                generateCarList();
            }

        }
    }
    private static void validate(String str){
        checkSeparator(str);
        checkLength(str);
    }

    private static void checkSeparator(String str){
        char[] arr = str.toCharArray();
        for(char ch: arr){
            if(!Character.isAlphabetic(ch)){
                throw new IllegalArgumentException();
            }
        }
    }
    private static void checkLength(String str){
        if (str.length() > 5){
            throw new IllegalArgumentException();
        }
    }
    private static void getNumOfStep(){
        String strOfNum = Console.readLine();
        try {
            checkIsNum(strOfNum);
            numOfStep = Integer.parseInt(strOfNum);
        } catch (IllegalArgumentException e){
            MessageView.NotNumberErrorMessage();
            getNumOfStep();
        }
    }
    private static void checkIsNum(String str) {
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException();
            }
        }
    }
    private static void play(){
        for (int i = 0; numOfStep > i; i++) {
            for (Car car : cars.getCars()) {
                MessageView.ResultFormMessage(car.getName());
                int num = Randoms.pickNumberInRange(1,9);
                int count = 0;
                while (num > 4){
                    car.goFoward();
                    count++;
                    num = Randoms.pickNumberInRange(1,9);
                }
                MessageView.printNumOfStep(count);
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void printWinnerAndEnd(){
        int max = getCarIndexOfMaxDistance();
        List<String> winnerNames = new ArrayList<>();
        for (int i = 0; cars.getCars().size() > i; i++){
            if (cars.getCars().get(i).getDistance() == cars.getCars().get(max).getDistance()){
                winnerNames.add(cars.getCars().get(i).getName());
            }
        }
        String[] nameArray = winnerNames.toArray(new String[winnerNames.size()]);
        MessageView.printWinner(String.join(", ", nameArray));
    }
    private static int getCarIndexOfMaxDistance(){
        int maxIndex = 0;
        for (int i = 1; i < cars.getCars().size(); i++){
            int num = cars.getCars().get(i).getDistance();
            if (num > cars.getCars().get(maxIndex).getDistance()){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
