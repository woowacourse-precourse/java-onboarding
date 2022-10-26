package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if (check(pobi) && check(crong)) {
            int p = selectNum(pobi);
            int c = selectNum(crong);

            if (p > c) {
                answer = 1;
            }
            if (p < c) {
                answer = 2;
            }
            if (p == c) {
                answer = 0;
            }
        }

        return answer;
    }

    static int selectNum(List<Integer> x) {
        int result = 0;

        int left = x.get(0);
        int right = x.get(1);

        result = Math.max(maxCase(left), maxCase(right));

        return result;
    }

    static int maxCase(int i) {
        String[] split = String.valueOf(i).split("");
        int sum = 0;
        int mul = 1;

        for (String s : split) {
            sum += Integer.parseInt(s);
            mul *= Integer.parseInt(s);
        }

        return Math.max(sum, mul);
    }

    static boolean check(List<Integer> x) {
        boolean answer = true;
        if (x.get(0) == 1 || x.get(0) == 399) {
            answer = false;
        }
        if (x.get(1) - x.get(0) != 1) {
            answer = false;
        }

        return answer;
    }
}