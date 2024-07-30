package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

import java.util.ArrayList;


public class GameController {
    private static ArrayList<Car> cars = new ArrayList();
    public static int numOfStep = 0;
    public static void gameStarter(){
        createCarArray();
        getNumOfStep();
    }
    public static void createCarArray(){
        String input = Console.readLine();
        String[] arr = input.split(",");
        for(String str: arr) {
            checkLength(str);
            checkSeparator(str);
            cars.add(new Car(str));
        }
    }
    public static void checkSeparator(String str){
        char[] arr = str.toCharArray();
        for(char ch: arr){
            if(!Character.isAlphabetic(ch)){
                throw new IllegalArgumentException();
            }
        }
    }
    public static void checkLength(String str){
        if (str.length() > 5){
            throw new IllegalArgumentException();
        }
    }
    public static void getNumOfStep(){
        String strOfNum = Console.readLine();
        checkIsNum(strOfNum);
        numOfStep = Integer.parseInt(strOfNum);
    }

    public static void checkIsNum(String str){
        char[] arr = str.toCharArray();
        for(char ch: arr){
            if(!Character.isDigit(ch)){
                throw new IllegalArgumentException();
            }
        }
    }
}
