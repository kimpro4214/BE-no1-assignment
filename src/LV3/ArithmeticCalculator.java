package LV3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private final List<Double> results = new ArrayList<>();

    public double calculate(T a, T b, OperatorType operator) {
        double x = a.doubleValue();
        double y = b.doubleValue();
        double result;

        switch (operator) {
            case PLUS: result = x + y; break;
            case MINUS: result = x - y; break;
            case MULTIPLY: result = x * y; break;
            case DIVIDE:
                if (y == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                result = x / y; break;
            default:
                throw new IllegalArgumentException("알 수 없는 연산자");
        }

        results.add(result);
        return result;
    }

    public List<Double> getResults() {
        return results;
    }

    public List<Double> getResultsGreaterThan(double threshold) {
        return results.stream()
                .filter(r -> r > threshold)
                .collect(Collectors.toList());
    }
}