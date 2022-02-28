package com.example.MathOperation;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BasicMathOperationService implements MathOperationService {


    @Override
    public BigDecimal sumNumbers(List<BigDecimal> operands) {

        if (operands.size() < 2) {
            throw new RuntimeException("Less than 2 operands");
        }
//         return (operands.stream().reduce(0.0,(total, number) -> total + number));
        BigDecimal result = operands.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return result;
    }


}