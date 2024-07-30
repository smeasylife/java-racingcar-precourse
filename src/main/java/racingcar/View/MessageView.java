package racingcar.View;

public class MessageView {
    public static void numErrorMessage(){
        System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
    }
    public static void nameErrorMessage(){
        System.out.println("[ERROR] 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.");
    }
}
