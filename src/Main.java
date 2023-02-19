import java.util.Arrays;
import java.util.Scanner;

import static jdk.internal.joptsimple.util.RegexMatcher.regex;

public class Main {
    public static void main(String[] args) throws Exception {
        ToRomanConverter converter = new ToRomanConverter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String expression = scanner.nextLine();
        System.out.println(calc(expression));



    }

    public static String calc(String input) throws Exception {
        ToRomanConverter converter = new ToRomanConverter();
        String[] actions = {"+", "-", "*", "/" };
        String[] regex = {"\\+", "-", "\\*", "/" };

        int operationIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                operationIndex = i;
                break;
            }
        }
        if (operationIndex == -1) {
            throw new Exception("Калькулятор работает только с операторами +, -, *, /");
        }


        String[] numbers = input.split(regex[operationIndex]);

        if (numbers.length > 2) {
            throw new Exception("Калькулятор работает только с двумя операндами");
        }


        int x;
        int y;
        if (converter.isRoman(numbers[0]) && converter.isRoman(numbers[1])) {
            x = converter.romanToArab(numbers[0]);
            y = converter.romanToArab(numbers[1]);
        } else if (!converter.isRoman(numbers[0]) && !converter.isRoman(numbers[1])) {
            x = Integer.parseInt(numbers[0]);
            y = Integer.parseInt(numbers[1]);
        } else {
            throw new Exception("Калькулятор работает только с числами в одном формате");
        }



        if (x > 10 || x < 0 || y > 10|| y < 1 ) {
            throw new Exception("Калькулятор работает только с числами от 1 до 10");
        }

        int result;

        switch (regex[operationIndex]) {
            case "\\+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "\\*":
                result = x * y;
                break;
            default:
                result = x / y;
                break;
        }
        if (converter.isRoman(numbers[0]) && converter.isRoman(numbers[1])) {
            return converter.arabToRoman(result);
        } else if (converter.isRoman(numbers[0]) && converter.isRoman(numbers[1]) && result < 1) {
            throw new Exception("Результат операции с римскими числами не может быть < 1");
        } else {
            return Integer.toString(result);
        }
    }
}