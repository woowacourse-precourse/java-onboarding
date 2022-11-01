package onboarding;

import java.util.List;

class Problem1 {
    public static Boolean isValid(List<Integer> pageNumbers) {
        if (pageNumbers.get(0) < 1 || pageNumbers.get(1) > 400) {
            return false;
        }
        if (pageNumbers.get(0) % 2 == 0 || pageNumbers.get(1) % 2 == 1) {
            return false;
        }
        if (pageNumbers.get(0) + 1 != pageNumbers.get(1)) {
            return false;
        }
        return true;
    }

    public static Integer getMax(Integer pageNumber) {
        return Math.max(divideAndPlus(pageNumber), divideAndMultiply(pageNumber));
    }

    public static Integer divideAndPlus(Integer pageNumber) {
        int result = 0;
        while (pageNumber != 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    public static Integer divideAndMultiply(Integer pageNumber) {
        int result = 1;
        while (pageNumber != 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int maxValueOfPobi = Integer.MIN_VALUE;
        int maxValueOfCrong = Integer.MIN_VALUE;

        if (!isValid(pobi) || !isValid((crong))) {
            return -1;
        }
        for (Integer pageNumber : pobi) {
            maxValueOfPobi = Math.max(maxValueOfPobi, getMax(pageNumber));
        }
        for (Integer pageNumber : crong) {
            maxValueOfCrong = Math.max(maxValueOfCrong, getMax(pageNumber));
        }

        if (maxValueOfPobi == maxValueOfCrong) {
            answer = 0;
        }
        if (maxValueOfPobi > maxValueOfCrong) {
            answer = 1;
        }
        if (maxValueOfPobi < maxValueOfCrong) {
            answer = 2;
        }
        return answer;
    }
}