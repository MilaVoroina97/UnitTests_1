package org.example;

public class Calculator {
    public Calculator(){

    }
    public  int calculation(int firstOperand, int secondOperand, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }


    public double calculateDiscount(double price, double discount) {

        if (price < 0 || discount < 0 || discount > 100) {

            throw new ArithmeticException("Invalid arguments");
        }

        return price * (discount / 100);

    }
}