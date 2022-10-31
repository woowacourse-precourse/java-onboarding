package onboarding;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        ThreeSixNine.checkNumberRange(number);
        answer = ThreeSixNine.accumulatedClaps(number);
        return answer;
    }

    public static void main(String[] args) {
        Game3.start();
        int inputNumber = Game3.inputNumber();
        int accumulatedClaps = Game3.calculate(inputNumber);
        Game3.end(inputNumber, accumulatedClaps);
    }
}

class Game3 {
    static void start() {
        OutView3.printStart();
    }

    static int inputNumber() {
        int inputNumber = 0;
        try {
            inputNumber = Input3.inputNumber();
            ThreeSixNine.checkNumberRange(inputNumber);
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요!");
            return inputNumber();
        }
        return inputNumber;
    }

    static int calculate(int inputNumber) {
        return ThreeSixNine.accumulatedClaps(inputNumber);
    }

    static void end(int inputNumber, int accumulatedClaps) {
        OutView3.printHead();
        OutView3.printResult(inputNumber, accumulatedClaps);
    }
}

class Input3 {
    static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}

class ThreeSixNine {

    static void checkNumberRange(int inputNumber) {
        if (inputNumber < 1 || 10000 < inputNumber) {
            throw new IllegalStateException("1이상 10,000 이하인 자연수를 입력하세요");
        }
    }

    static int clapsPerNumber(int inputNumber) {
        int clap = 0;
        ArrayList<Integer> inputNumberList = new ArrayList<>();
        int digitCount = digitCount(inputNumber);
        inputNumerToList(inputNumber, inputNumberList, digitCount);
        clap = countClaps(clap, inputNumberList);
        return clap;
    }

    private static int countClaps(int clap, ArrayList<Integer> inputNumberList) {
        for (int i = 0; i < inputNumberList.size(); i++) {
            if (inputNumberList.get(i) == 3) {
                clap++;
            }
            if (inputNumberList.get(i) == 6) {
                clap++;
            }
            if (inputNumberList.get(i) == 9) {
                clap++;
            }
        }
        return clap;
    }

    private static void inputNumerToList(int inputNumber, ArrayList<Integer> inputNumberList, int digitCount) {
        for (int i = digitCount; i > 0; i--) {
            inputNumberList.add(
                    inputNumber / (int) Math.pow(10, i - 1) % 10);
        }
    }

    private static int digitCount(int inputNumber) {
        boolean done = false;
        int digit = 0;
        while (!done) {
            if (inputNumber / 10 == 0) {
                done = true;
            }
            digit++;
            inputNumber /= 10;
        }
        return digit;
    }

    static int accumulatedClaps(int number) {
        int accumulateClap = 0;
        for (int i = 1; i <= number; i++) {
            accumulateClap += clapsPerNumber(i);
        }
        return accumulateClap;
    }

}

class OutView3 {

    static void printStart() {
        System.out.println("1 이상 10,000 이하인 자연수를 입력해주세요");
    }
    static void printHead() {
        System.out.println("number" + "\t" + "result");
    }

    static void printResult(int inputNumber, int result) {
        System.out.println(inputNumber + "\t" + result);
    }
}