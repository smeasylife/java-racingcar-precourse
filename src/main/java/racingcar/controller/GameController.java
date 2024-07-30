package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

import java.util.ArrayList;


public class GameController {
    public static ArrayList<Car> cars = new ArrayList();
    public static void getCars(){
        String input = Console.readLine();
        createCarArray(input);
    }
    public static void createCarArray(String input){
        String[] arr = input.split(",");
        for(String str: arr) {
            cars.add(new Car(str));
        }
        System.out.println(cars.toString());
    }
}
