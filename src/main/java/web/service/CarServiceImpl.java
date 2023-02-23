package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    public static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("Tesla", "white", 300));
        cars.add(new Car("Ferrari", "red", 350));
        cars.add(new Car("Porsche", "yellow", 240));
        cars.add(new Car("Lexus", "black", 220));
        cars.add(new Car("Honda", "green", 200));
    }

    @Override
    public List<Car> getSomeCars(Integer count) {
        if (count <= 0) {
            return null;
        } else if (count >= 5) {
            return cars;
        } else {
            return cars.stream().limit(count).toList();
        }
    }
}
