package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.View.MessageView;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void moveForward(){
        MessageView.resultForm(this.name);
        int num = Randoms.pickNumberInRange(1,9);
        while (num > 4){
            this.position++;
            System.out.print("-");
            num = Randoms.pickNumberInRange(1,9);
        }
    }
}
