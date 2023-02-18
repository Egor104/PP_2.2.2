package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController extends CarServiceImpl {

    CarServiceImpl carService = new CarServiceImpl();
    static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("Tesla", "white", 300));
        cars.add(new Car("Ferrari", "red", 350));
        cars.add(new Car("Porsche", "yellow", 240));
        cars.add(new Car("Lexus", "black", 220));
        cars.add(new Car("Honda", "green", 200));
    }

    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(value = "count", defaultValue = "5") Integer count, Model model) {
        model.addAttribute("cars", carService.getSomeCars(cars, count));
        return "car";
    }
}
