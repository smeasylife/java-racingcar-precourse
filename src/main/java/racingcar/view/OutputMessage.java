package racingcar.view;

public class OutputMessage {
    public void ResultFormMessage(String name, String bars){
        System.out.println(name + " : " + bars);
    }
    public void printStartPlayMessage() {
        System.out.println("실행 결과");
    }
    public void printEndMessage(String winnerNames) {
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
