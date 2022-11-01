package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static int EXCEPTION_NUMBER= -1;
    static int POBI_WIN = 1;
    static int CRONG_WIN = 2;
    static int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalid(pobi) || isInvalid(crong)) {
            return EXCEPTION_NUMBER;
        }

        List<Integer> winnersList = chooseWinnersList(pobi, crong);

        if (winnersList.equals(pobi)) {
            return POBI_WIN;
        } else if (winnersList.equals(crong)) {
            return CRONG_WIN;
        } else {
            return DRAW;
        }
    }

    public static boolean isInvalid(List<Integer> list) {
        if (list.size() != 2) {
            return true;
        }
        if (list.contains(1) || list.contains(400)) {
            return true;
        }

        int leftPage = list.get(0);
        int rightPage = list.get(1);
        if (leftPage - rightPage != -1) {
            return true;
        }

        return false;
    }

    public static int plusNumber(Integer number) {
        int answer = 0;
        char[] chars = Integer.toString(number).toCharArray();
        for (char aChar : chars) {
            answer += Character.getNumericValue(aChar);
        }
        return answer;
    }

    public static int multiplyNumber(Integer number) {
        int answer = 1;
        char[] chars = Integer.toString(number).toCharArray();
        for (char aChar : chars) {
            answer *= Character.getNumericValue(aChar);
        }
        return answer;
    }

    public static int getMaxNumber(Integer number1, Integer number2) {
        int maxNumber = Math.max(plusNumber(number1), multiplyNumber(number1));
        maxNumber = Math.max(maxNumber, plusNumber(number2));
        maxNumber = Math.max(maxNumber, multiplyNumber(number2));
        return maxNumber;
    }

    public static List<Integer> chooseWinnersList (List<Integer> list1, List<Integer> list2) {
        int MaxFor1 = getMaxNumber(list1.get(0), list1.get(1));
        int MaxFor2 = getMaxNumber(list2.get(0), list2.get(1));

        if (MaxFor1 > MaxFor2) {
            return list1;
        } else if (MaxFor2 > MaxFor1) {
            return list2;
        } else {
            return new ArrayList<>();
        }
    }
}