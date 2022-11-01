package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) {
            return answer;
        }

        int pobiOdd = Math.max(sumEachDigit(pobi.get(0)), multiEachDigit(pobi.get(0)));
        int pobiEven = Math.max(sumEachDigit(pobi.get(1)), multiEachDigit(pobi.get(1)));
        int pobiScore = Math.max(pobiOdd, pobiEven);

        int crongOdd = Math.max(sumEachDigit(crong.get(0)), multiEachDigit(crong.get(0)));
        int crongEven = Math.max(sumEachDigit(crong.get(1)), multiEachDigit(crong.get(1)));
        int crongScore = Math.max(crongOdd, crongEven);

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else if (pobiScore == crongScore) {
            answer = 0;
        }

        return answer;
    }

    private static int sumEachDigit(int number) {
        int sum = 0;
        int changeNumber = number;
        while (changeNumber != 0) {
            sum +=  changeNumber % 10;
            changeNumber /= 10;
        }
        return sum;
    }

    private static int multiEachDigit(int number) {
        int sum = 1;
        int changeNumber = number;
        while (changeNumber != 0) {
            sum *= changeNumber % 10;
            changeNumber /= 10;
        }
        return sum;
    }
}