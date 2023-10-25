package seminar.first.homework.calculator;

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

        if (price < 0)
            throw new ArithmeticException("Price cannot be less than 0");
        if(discount > 100)
            throw new ArithmeticException("Discount cannot be more than 100%");
        if(discount < 0)
            throw new ArithmeticException("Discount cannot be less than 0");

        return price - (price * discount / 100);

    }
}