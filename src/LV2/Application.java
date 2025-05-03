package LV2;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            int num1, num2;

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
                    sc.nextLine();
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

            sc.nextLine(); // 개행 처리

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.nextLine().charAt(0);

            try {
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
                System.out.println("저장된 결과 목록: " + calculator.getResults());
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }

            while (true) {
                System.out.print("가장 오래된 결과를 삭제하시겠습니까? (yes/no): ");
                String delete = sc.nextLine().trim().toLowerCase();

                if (delete.equals("yes")) {
                    calculator.removeResult();
                    System.out.println("삭제 후 결과 목록: " + calculator.getResults());
                    break;
                } else if (delete.equals("no")) {
                    break;
                } else {
                    System.out.println("잘못 입력하셨습니다. 'yes' 또는 'no'만 입력해주세요.");
                }
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
}
