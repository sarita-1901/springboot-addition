package com.example.MathOperation;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public interface MathOperationService {


    BigDecimal sumNumbers(List<BigDecimal> operands);

}