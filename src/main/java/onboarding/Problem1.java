package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isErrorList(pobi) || isErrorList(crong))
            return -1;
        int pobiScore = getMaxInList(pobi);
        int crongScore = getMaxInList(crong);
        if (pobiScore == crongScore)
            return 0;
        return (pobiScore > crongScore) ? 1 : 2;
    }

    private static int getMaxInList(List<Integer> list) {
        int leftPage = Math.max(addEachNumber(list.get(0)), multiplyEachNumber(list.get(0)));
        int rightPage = Math.max(addEachNumber(list.get(1)), multiplyEachNumber(list.get(1)));
        return Math.max(leftPage, rightPage);
    }

    private static int addEachNumber(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static int multiplyEachNumber(int number) {
        int multiple = 1;
        while (number != 0) {
            multiple *= number % 10;
            number /= 10;
        }
        return multiple;
    }

    private static boolean isErrorList(List<Integer> list) {
        if (list.size() != 2
                || list.get(0) == null || list.get(0) <= 1 || list.get(0) >= 400 || list.get(0) % 2 == 0
                || list.get(1) == null || list.get(1) <= 1 || list.get(1) >= 400 || list.get(1) % 2 == 1)
            return true;
        return list.get(1) - list.get(0) != 1;
    }
}