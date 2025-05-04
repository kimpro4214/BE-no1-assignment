package LV3;

import java.util.Scanner;

public class CalculatorLV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = Double.parseDouble(sc.nextLine());

                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = Double.parseDouble(sc.nextLine());

                System.out.print("연산 기호를 입력하세요 (+, -, *, /): ");
                char opChar = sc.nextLine().charAt(0);
                OperatorType operator = OperatorType.fromChar(opChar);

                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);

                System.out.print("기준보다 큰 결과값을 보고 싶다면 숫자를 입력하세요 (스킵하려면 엔터): ");
                String thresholdInput = sc.nextLine();
                if (!thresholdInput.isBlank()) {
                    double threshold = Double.parseDouble(thresholdInput);
                    System.out.println("\n[" + threshold + "보다 큰 결과들]");
                    System.out.println(calculator.getResultsGreaterThan(threshold));
                }

                System.out.print("계속 하시겠습니까? (exit 입력 시 종료): ");
                String exit = sc.nextLine();
                if (exit.equalsIgnoreCase("exit")) break;

            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }

        sc.close();
    }
}
