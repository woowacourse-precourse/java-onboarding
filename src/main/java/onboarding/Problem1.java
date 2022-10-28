package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeft, pobiRight, crongLeft, crongRight;



        return answer;
    }

    private static int addedNumber(int number) {
        List<Integer> separatedNumbers = new ArrayList<>();
        while (true) {
            separatedNumbers.add(number % 10);
            if (number / 10 == 0)
                break;
            number /= 10;
        }

        int result = 0;
        for (int i : separatedNumbers) {
            result += i;
        }
        return result;
    }

    private static int multipliedNumbers(int number) {
        List<Integer> separatedNumbers = new ArrayList<>();
        while (true) {
            separatedNumbers.add(number % 10);
            if (number / 10 == 0)
                break;
            number /= 10;
        }

        int result = 1;
        for (int i : separatedNumbers) {
            result *= i;
        }
        return result;
    }

    private static int comparingNumbers(int addedNum, int multipliedNum) {
        return addedNum > multipliedNum ? addedNum : multipliedNum;
    }

    private int selectingWinner(int pobiNumber, int crongNumber) {
        if (pobiNumber > crongNumber) {
            return 1;
        } else if (pobiNumber < crongNumber) {
            return 2;
        }
        return 0;
    }

    private static int judgmentException(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        return 0;
    }

}