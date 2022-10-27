package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(isExceptional(pobi) || isExceptional(crong)) {
            return -1;
        }

        int answer = 0;
        int pobiPoint = getPoint(pobi);
        int crongPoint = getPoint(crong);

        if(pobiPoint > crongPoint)
            answer = 1;
        if(pobiPoint < crongPoint)
            answer = 2;

        return answer;
    }

    private static boolean isExceptional(List<Integer> person) {
        int left = person.get(0);
        int right = person.get(1);

        if((left < 3) || ((Math.abs(left - right)) > 1) || (right > 398) || (left % 2 == 0) || (right % 2 == 1)) {
            return true;
        }

        return false;
    }

    private static int getPoint(List<Integer> person) {
        return Math.max(getPagePoint(person.get(0)), getPagePoint(person.get(1)));
    }

    private static int getPagePoint(int page) {
        return Math.max(addDigits(page), multipleDigits(page));
    }

    private static int addDigits(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int multipleDigits(int num) {
        int multiple = 1;
        while(num != 0) {
            multiple *= num % 10;
            num /= 10;
        }
        return multiple;
    }
}