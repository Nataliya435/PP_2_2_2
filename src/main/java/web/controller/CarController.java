package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;


@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {

        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(required = false) Integer count, Model model) {
        if (count == null) {
            count = 0;
        }
        model.addAttribute("cars", carService.printCars(count));
        return "cars";
    }
}
