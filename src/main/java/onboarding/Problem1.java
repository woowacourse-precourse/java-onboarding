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

    private static boolean isFirstOrLastPage(int num) {
        if (num == 1 || num == 400) {
            return true;
        }
        return false;
    }

    private static boolean isFirstOrLastPage(List<Integer> person1, List<Integer> person2) {
        boolean flag = false;
        for (int num : person1) {
            flag = isFirstOrLastPage(num);
        }
        for (int num : person2) {
            flag = isFirstOrLastPage(num);
        }
        return flag;
    }

    private static boolean isCorrectPage(List<Integer> person) {
        int leftPage = person.get(0);
        int rightPage = person.get(1);
        if (leftPage - rightPage != -1) {
            return false;
        }
        if (leftPage % 2 == 0 || rightPage % 2 != 0) {
            return false;
        }
        if (leftPage < 1 || rightPage > 400) {
            return false;
        }
        return true;
    }

    private static boolean isCorrectPage(List<Integer> person1, List<Integer> person2) {
        boolean flag = true;
        if (!isCorrectPage(person1)) {
            flag = false;
        }
        if (!isCorrectPage(person2)) {
            flag = false;
        }
        return flag;
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

        if (isFirstOrLastPage(pobi, crong)) {
            return -1;
        }
        if (!isCorrectPage(pobi, crong)) {
            return -1;
        }
        if (pobiNum == crongNum) {
            return 0;
        }
        if (answer == pobiNum) {
            return 1;
        }
        return 2;
    }
}