package LV1;

import java.util.Scanner;

public class CalculatorLV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        while (true) {
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                try {
                    num1 = sc.nextInt();
                    if (num1 < 0) {
                        System.out.println("0 이상의 양의 정수만 입력 가능합니다.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
                    sc.nextLine(); // 버퍼 비우기
                }
            }

            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                try {
                    num2 = sc.nextInt();
                    if (num2 < 0) {
                        System.out.println("0 이상의 양의 정수만 입력 가능합니다.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
                    sc.nextLine();
                }
            }

            sc.nextLine();


            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.nextLine().charAt(0);

            boolean isValid = true;
            double result = 0;

            switch (operator) {
                case '+':
                    result = add(num1, num2);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        isValid = false;
                    } else {
                        result = divide(num1, num2);
                    }
                    break;
                default:
                    System.out.println("올바른 사칙연산 기호를 입력해주세요.");
                    isValid = false;
            }

            if (isValid) {
                System.out.println("결과: " + result);
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

        sc.close();
    }

    public static double add(int a, int b) {
        return a + b;
    }

    public static double subtract(int a, int b) {
        return a - b;
    }

    public static double multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        return (double) a / b;
    }
}
