package web.service;

import web.model.Car;
import java.util.List;

public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getSomeCars(List<Car> cars, Integer count) {
        if (count <= 0) {
            return null;
        } else if (count >= 5) {
            return cars;
        } else {
            return cars.stream().limit(count).toList();
        }
    }
}
