package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePage(pobi) || !validatePage(crong)) return -1;
        int pobiNum = calculatePageMaxNumber(pobi);
        int crongNum = calculatePageMaxNumber(crong);
        int answer = 0;
        if (pobiNum - crongNum < 0) {
            answer = 1;
        }
        else if (pobiNum - crongNum > 0) {
            answer = 2;
        }
        return answer;
    }

    private static boolean validatePage(List<Integer> page) {
        return page.get(1) - page.get(0) == 1;
    }

    private static int addEachDigit(Integer num) {
        int divided = num;
        int sum = 0;
        while (divided != 0) {
            sum += divided % 10;
            divided /= 10;
        }
        return sum;
    }

    private static int multiplyDigit(Integer num) {
        int divided = num;
        int sum = 1;
        while (divided != 0) {
            sum *= divided % 10;
            divided /= 10;
        }
        return sum;
    }

   private static int calculatePageMaxNumber(List<Integer> page) {
        return Math.max(addEachDigit(page.get(0)), multiplyDigit(page.get(1)));
   }
}