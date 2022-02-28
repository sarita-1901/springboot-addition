package com.example.MathOperation;

import org.apache.logging.log4j.LogManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@CrossOrigin (origins = "http://localhost:3000")

public class MathOperationController {
    @Autowired
    public MathOperationService mathOperationService;
//private static final Logger logger = LoggerFactory.getLogger(MathOperationController.class);
private static final Logger logger = LogManager.getLogger(MathOperationController.class);
     //Get Sum
    @GetMapping("/add/{numbers}")
    public ResponseEntity<BigDecimal> getSum(@PathVariable List<BigDecimal> numbers) {
        //  Boolean valid = mathOperationService.validateRequestParam(numbers);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        logger.info("Entering method at " + timestamp);

        BigDecimal output = mathOperationService.sumNumbers(numbers);
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
         logger.info("Exiting method at " + timestamp1);
        return ResponseEntity.status(HttpStatus.OK).body(output);
        //  return ResponseEntity.status(HttpStatus.OK).body(numbers.stream().reduce(0.0,(total,number) -> total + number));

    }


    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.BAD_REQUEST);
    }

}
