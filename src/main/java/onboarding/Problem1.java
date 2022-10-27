package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = pageScoreCompare(pobi);
        int crongScore = pageScoreCompare(crong);
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int pageScoreCompare(List<Integer> person) {
        pageScore(person.get(0));
        return 98;
    }

    private static int pageScore(int page) {
        int oneNumber;
        int tenNumber;
        int hundredNumber;
        int sumNum;
        int multiplyNum;
        if (page / 100 != 0) {
            oneNumber = page % 10;
            tenNumber = (page % 100) / 10;
            hundredNumber = page / 100;
            sumNum = sumNumber(oneNumber, tenNumber, hundredNumber);
            multiplyNum = multiplyNumber(oneNumber, tenNumber, hundredNumber);
            return compareNumber(sumNum, multiplyNum);
        }

        if (page / 10 != 0) {
            oneNumber = page % 10;
            tenNumber = page / 10;
            sumNum = sumNumber(oneNumber, tenNumber, 0);
            multiplyNum = multiplyNumber(oneNumber, tenNumber, 1);
            return compareNumber(sumNum, multiplyNum);
        }

        return page;


    }

    private static int compareNumber(int sumNum, int multiplyNum) {
        if (sumNum > multiplyNum) return sumNum;
        return multiplyNum;
    }

    private static int multiplyNumber(int oneNumber, int tenNumber, int hundredNumber) {
        return oneNumber * tenNumber * hundredNumber;
    }

    private static int sumNumber(int oneNumber, int tenNumber, int hundredNumber) {
        return oneNumber + tenNumber + hundredNumber;
    }
}