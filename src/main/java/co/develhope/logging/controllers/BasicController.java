package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    private BasicService basicService;
    @Autowired
    private Environment enviroment;


    @GetMapping("/")
    public String welcome() {
        LOGGER.info("Welcome message returned");
        return "Welcome to Basic Controller!";
    }

    @RequestMapping("/exp")
    public String exponent() {
        return "The result is: " + basicService.getExp();
    }

    @GetMapping("/get-errors")
    public void getError(){
        LOGGER.error("Error thrown");
        throw new RuntimeException("Sorry, you got an error :(");
    }

}