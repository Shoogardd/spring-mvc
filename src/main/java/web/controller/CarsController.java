package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
public class CarsController {

    private final CarServiceImpl carService;

    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String carController (@RequestParam (value = "count",required = false) Integer count, Model model) {
        if (count == null) {
            model.addAttribute("cars", carService.getCars());
        } else {
            model.addAttribute("cars", carService.getCount(count));
        }
        return "CarsTable";
    }
}
