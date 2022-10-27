package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 요구사항 외의 값은 -1 을 반환.
        int answer = -1;

        // pobi 와 crong 의 값을 체크.
        if (check(pobi) && check(crong)) {
            // pobi 의 맥스값으로 int p 초기화
            int p = selectNum(pobi);
            // crong 의 맥스값으로 int c 초기화
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


    // 왼쪽 페이지를 이용한 최대값과 오른쪽 페이지를 이용한 최대값을 비교하여 최대값을 반환.
    static int selectNum(List<Integer> x) {
        int result = 0;

        int left = x.get(0);
        int right = x.get(1);

        result = Math.max(maxCase(left), maxCase(right));

        return result;
    }

    // 모든수의 합과 곱 중 더 큰값을 반환.
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

    // 입력된 페이지 값이 요구사항에 적합한 값인지 판별.
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