package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputMessage;

public class Car {
    private final String name;
    private int position = 0;
    private OutputMessage outputMessage = new OutputMessage();
    private StringBuilder barsOfPosition = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void goFoward() {
        int num = Randoms.pickNumberInRange(1,9);
        if (num > 4) {
            this.position++;
            barsOfPosition.append("-");
        }
        outputMessage.ResultFormMessage(this.name, barsOfPosition.toString());
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }
}
