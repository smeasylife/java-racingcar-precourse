package racingcar.view;

public class ErrorMessage {
    public void NotNumberErrorMessage(){
        System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
    }
    public void nameErrorMessage(){
        System.out.println("[ERROR] 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.");
    }
}
