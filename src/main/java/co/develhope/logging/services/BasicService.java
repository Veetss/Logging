package co.develhope.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicService.class);
    @Autowired
    private Environment enviroment;


    public int calculateExponent() {
        LOGGER.debug("Calculating exponent...");
        int base = Integer.parseInt(enviroment.getProperty("customEnvs.n1"));
        int exponent = Integer.parseInt(enviroment.getProperty("customEnvs.n2"));
        int result = (int) Math.pow(base, exponent);
        LOGGER.debug("Exponent calculated: {}", result);
        return result;
    }
}