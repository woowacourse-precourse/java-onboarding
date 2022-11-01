package onboarding;

import java.util.List;

class Problem1 {
    public static boolean validTest(List<Integer> input) {
        int left = input.get(0);
        int right = input.get(1);

        if (left + 1 != right){
            return false;
        }
        if (left < 1 || right > 400){
            return false;
        }
        if (left % 2 != 1) {
            return false;
        }
        return true;
    }

    public static int addEachNum(int...num) {
        int result = 0;

        for (int n : num) {
            result += n;
        }
        return result;
    }

    public static int mulEachNum(int...num) {
        int result = 1;

        for (int n : num) {
            result *= n;
        }
        return result;
    }

    public static int calMaxNum(int num) {
        int addResult, mulResult;

        if (num < 10) { // single digit
            return num;
        }
        if (num < 100) { // two-digit number
            addResult = addEachNum(num / 10, num % 10);
            mulResult = mulEachNum(num / 10, num % 10);
        } else { // three-digit number
            addResult = addEachNum(num / 100, num % 100 / 10, num % 10);
            mulResult = mulEachNum(num / 100, num % 100 / 10, num % 10);
        }
        return Math.max(addResult, mulResult);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!validTest(pobi) || !validTest(crong)) {
            return -1;
        }

        int pobiScore = Math.max(calMaxNum(pobi.get(0)), calMaxNum(pobi.get(1)));
        int crongScore = Math.max(calMaxNum(crong.get(0)), calMaxNum(crong.get(1)));

        answer = pobiScore > crongScore ? 1 : pobiScore < crongScore ? 2 : 0;

        return answer;
    }
}