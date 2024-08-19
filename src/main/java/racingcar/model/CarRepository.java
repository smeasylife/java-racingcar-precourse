package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    List<Car> carList;

    public CarRepository(List<Car> cars) {
        carList = cars;
    }

    public List<Car> getCarList() {
        return carList;
    }

}
