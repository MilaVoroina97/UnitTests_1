package seminar.first.homework.calculator;

import java.util.Scanner;

public class Calculator {

    private final Scanner scanner = new Scanner(System.in);
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

    public String getOperation(){


        while (true){

            System.out.println("Enter the operation: ");
            String operation = scanner.next();
            if(operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")){

                try{
                    return operation;

                }catch (IllegalStateException ex){
                    System.out.println("Input is not a number, continue");
                }
            }else{
                System.out.println("Incorrect data,try again: ");
            }
        }



    }

    public int getOperand(){

        System.out.println("Enter the operand: ");
        int operand = 0;
        if(scanner.hasNextInt())
        {
             operand = scanner.nextInt();
        }else{
            System.out.println("You need to enter only numbers, please, try again. ");
            if(scanner.hasNextInt()){
                scanner.next();
                operand = getOperand();
            }else{
                throw new IllegalStateException("Incorrect data enter. ");
            }
        }
        return operand;
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