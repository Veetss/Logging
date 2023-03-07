package co.develhope.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicService.class);
    @Value("${customEnvs.n1}")
    private double n1;

    @Value("${customEnvs.n2}")
    private double n2;

    public double getExp(){
        LOGGER.debug("Starting calculation");
        double t = Math.pow(n1, n2);
        LOGGER.debug("Calculation ended");
        return t;
    }
}