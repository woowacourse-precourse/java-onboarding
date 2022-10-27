package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiPoint = getPoint(pobi);
        int crongPoint = getPoint(crong);

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getPoint(List<Integer> person) {
        return Math.max(getPagePoint(person.get(0)), getPagePoint(person.get(1)));
    }

    private static int getPagePoint(int page) {
        return Math.max(addDigits(page), multipleDigits(page));
    }

    private static int addDigits(int num) {
        int sum = 0;
        while(num == 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int multipleDigits(int num) {
        int multiple = 1;
        while(num == 0) {
            multiple *= num % 10;
            num /= 10;
        }
        return multiple;
    }
}