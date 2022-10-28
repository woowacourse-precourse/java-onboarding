package onboarding;

import java.util.List;

class Problem1 {

    private static int doSum(int num) {
        String stringInt = String.valueOf(num);
        int sum = 0;
        for (int i=0; i< stringInt.length(); i++) {
            String convertedNum = String.valueOf(stringInt.charAt(i));
            sum += Integer.parseInt(convertedNum);
        }
        return sum;
    }

    private static int doMultiply(int num) {
        String stringInt = String.valueOf(num);
        int multiply = 1;
        for (int i=0; i< stringInt.length(); i++) {
            String convertedNum = String.valueOf(stringInt.charAt(i));
            multiply *= Integer.parseInt(convertedNum);
        }
        return multiply;
    }

    private static int chooseLargeNumber(int num) {
        int summedNum = doSum(num);
        int multipliedNum = doMultiply(num);
        return Math.max(summedNum, multipliedNum);
    }

    private static int chooseLageNumber(List<Integer> person) {
        int leftNum = chooseLargeNumber(person.get(0));
        int rightNum = chooseLargeNumber(person.get(1));
        return Math.max(leftNum, rightNum);
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiNum = chooseLageNumber(pobi);
        int crongNum = chooseLageNumber(crong);
        int answer = Math.max(pobiNum, crongNum);

        if (pobiNum == crongNum) {
            return 0;
        }
        if (answer == pobiNum) {
            return 1;
        }
        if (answer == crongNum) {
            return 2;
        }

        return answer;
    }
}