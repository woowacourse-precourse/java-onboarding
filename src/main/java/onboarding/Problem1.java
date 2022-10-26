package onboarding;

import java.util.List;

class Problem1 {


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 처리
        if (validateList(pobi) || validateList(crong)) {
            return -1;
        }

        int pobiMax;
        for (int page : pobi) {
            pobiMax = compareTwoNumbers(page);
        }

        int crongMax;
        for (int page : crong) {
            crongMax = compareTwoNumbers(page);
        }

        return 0;
    }

    // 예외 발생시 TRUE
    private static boolean validateList(List<Integer> list) {
        // 페이지는 null 값이 들어갈 수 없다.
        if (list.get(0) == null || list.get(1) == null) {
            return true;
        }

        // 첫 페이지는 0 이상 400이하의 값이여야한다.
        if (list.get(0) <= 0 || list.get(0) >= 400){
            return true;
        }
        // 마지막 페이지는 0 이상 400이하의 값이어야한다.
        if (list.get(1) <= 0 || list.get(1) >= 400) {
            return true;
        }

        return list.get(1) - list.get(0) != 1;
    }

    private static int compareTwoNumbers(int number) {
        int addNum = addEachNumber(number);
        int multiNum = multiEachNumber(number);
        return Math.max(addNum, multiNum);
    }

    // 각 자릿수를 더하는 메서드
    private static int addEachNumber(int number) {
        int sum = 0;
        while (number != 0) {
            int result = number % 10;
            sum += result;
            number /= 10;
        }
        return sum;
    }

    // 각 자릿수를 곱하는 메서드
    private static int multiEachNumber(int number) {
        int multi = 1;
        while (number != 0) {
            int result = number % 10;
            multi *= result;
            number /= 10;
        }
        return multi;
    }
}