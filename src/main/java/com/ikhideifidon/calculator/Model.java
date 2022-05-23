package com.ikhideifidon.calculator;

import java.util.stream.LongStream;

public class Model {

    public float calculateUnaryNumber(float number1, String operator) {
        switch (operator) {
            case "±":
                return number1 * -1;
            case "﹪":
                return number1 / 100;
            case "⅟x":
                return number1 == 0 ? 0 : 1 / number1;
            case "sin":
                return (float) Math.sin(number1);
            case "cos":
                return (float) Math.cos(number1);
            case "In":
                return (float) Math.log(number1);
            case "tan":
                return (float) Math.tan(number1);
            case "x²":
                return (float) Math.pow(number1, 2);
            case "√x":
                return (float) Math.sqrt(number1);
            case "∛x":
                return (float) Math.cbrt(number1);
            case "x!":
                return LongStream.range(1L, (long) number1)
                        .reduce(1, (long x, long y) -> x * y);
            default:
                break;
        }
        return 0;
    }

    public float calculateBinaryNumber(float number1, float number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "×":
                return number1 * number2;
            case "÷":
                return number2 == 0 ? 0 : number1 / number2;
            case "xⁿ":
                return (float) Math.pow(number1, number2);
            default:
                break;
        }
        return 0;
    }
}
