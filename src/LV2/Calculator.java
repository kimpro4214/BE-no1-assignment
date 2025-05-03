package LV2;

import java.util.ArrayList;
import java.util.List;
 
public class Calculator {
    private List<Double> results;

    public Calculator() {
        results = new ArrayList<>();
    }

    // 메인 계산 메서드
    public double calculate(int a, int b, char operator) {
        boolean isValid = true;
        double result;
        switch (operator) {
            case '+':
                result = add(a, b);
                break;
            case '-':
                result = subtract(a, b);
                break;
            case '*':
                result = multiply(a, b);
                break;
            case '/':
                result = divide(a, b);
                break;
            default:
                throw new IllegalArgumentException("올바른 사칙연산 기호를 입력해주세요.");
        }




        results.add(result);
        return result;

    }

    private double add(int a, int b) {
        return a + b;
    }

    private double subtract(int a, int b) {
        return a - b;
    }

    private double multiply(int a, int b) {
        return a * b;
    }

    private double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return (double) a / b;
    }


    public List<Double> getResults() {
        return results;
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }
}
