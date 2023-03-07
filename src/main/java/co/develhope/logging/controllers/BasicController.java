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
        LOGGER.debug("Exponent calculation started");
        int base = Integer.parseInt(enviroment.getProperty("customEnvs.n1"));
        int exponent = Integer.parseInt(enviroment.getProperty("customEnvs.n2"));
        double result = Math.pow(base, exponent);
        LOGGER.debug("Exponent calculation finished with result: {}", result);
        return "The exponent of " + base + " and " + exponent + " is " + result;
    }

    @GetMapping("/get-errors")
    public void getErrors() throws MyCustomException {
        LOGGER.error("Custom error thrown");
        throw new MyCustomException("Sorry, you get an error :(");
    }

    private static class MyCustomException extends Exception {
        public MyCustomException(String message) {
            super(message);
        }
    }
}