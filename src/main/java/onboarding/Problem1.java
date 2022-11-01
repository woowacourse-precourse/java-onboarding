package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return -1;

        int scorePobi = score(pobi);
        int scoreCrong = score(crong);

        int answer = 0;
        if (scorePobi > scoreCrong) answer = 1;
        else if (scorePobi < scoreCrong) answer = 2;
        return answer;
    }

    public static int digitSum(Integer n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int digitMul(Integer n) {
        int mul = 1;
        while (n > 0) {
            mul *= n % 10;
            n /= 10;
        }
        return mul;
    }

    public static int score(List<Integer> list) {
        int left = Math.max(digitSum(list.get(0)), digitMul(list.get(0)));
        int right = Math.max(digitSum(list.get(1)), digitMul(list.get(1)));
        return Math.max(left, right);
    }
}