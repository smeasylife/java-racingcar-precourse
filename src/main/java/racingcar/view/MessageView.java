package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class MessageView {
    public static void NotNumberErrorMessage(){
        System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
    }
    public static void nameErrorMessage(){
        System.out.println("[ERROR] 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.");
    }
    public static void ResultFormMessage(String name){
        System.out.print(name + " : ");
    }
    public static void printNumOfStep(int num){
        for (int i = 0; num > i; i++){
            System.out.print('-');
        }
    }
    public static void printWinner(String winnerNames){
        System.out.print("최종 우승자 : " + winnerNames);
    }
}
