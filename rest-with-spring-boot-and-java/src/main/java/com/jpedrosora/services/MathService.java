package com.jpedrosora.services;

import com.jpedrosora.exception.UnsupportedMathOperationException;
import com.jpedrosora.util.NumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    private final NumberConverter numberConverter;

    @Autowired
    public MathService(NumberConverter numberConverter){
        this.numberConverter = numberConverter;
    }


    public Double sum(String numberOne, String numberTwo) {
        validateNumericInput(numberOne, numberTwo);
        return numberConverter.convertToDouble(numberOne) + numberConverter.convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        validateNumericInput(numberOne, numberTwo);
        return numberConverter.convertToDouble(numberOne) - numberConverter.convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        validateNumericInput(numberOne, numberTwo);
        return numberConverter.convertToDouble(numberOne) * numberConverter.convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        validateNumericInput(numberOne, numberTwo);
        return numberConverter.convertToDouble(numberOne) / numberConverter.convertToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) {
        validateNumericInput(numberOne, numberTwo);
        return (numberConverter.convertToDouble(numberOne) + numberConverter.convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {
        validateNumericInput(number);
        return Math.sqrt(numberConverter.convertToDouble(number));
    }

    private void validateNumericInput(String... numbers){
        for(String num : numbers){
            if(!numberConverter.isNumeric(num)){
                throw new UnsupportedMathOperationException("Please set a numeric value");
            }
        }
    }

}
