package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.crosscutting.util.MapperJsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/carpooling")
public class TestController {

    @Autowired
    private MapperJsonObject mapperJsonObject;

    @GetMapping("/{message}")
    public String sayHello(@PathVariable String message) {
        return message; //UtilText.getUtilText().getDefault(message, "Buenas mi mountruito ❤️");
        }
    }
