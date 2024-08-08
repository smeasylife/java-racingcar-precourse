package racingcar.model;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void moveForward(){


        System.out.print("\n");
    }
    public void goFoward() {
        this.distance++;
    }

    public int getDistance(){
        return this.distance;
    }

    public String getName(){
        return this.name;
    }
}
