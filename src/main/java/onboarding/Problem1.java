package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);

        int crong_left = crong.get(0);
        int crong_right = crong.get(1);

        if (pobi_right - pobi_left != 1 || crong_right - crong_left != 1 || pobi_left <= 1 || pobi_right >= 400 || crong_left <= 1 || crong_right >= 400) {
            return -1;
        }

        int pobi_result;
        int crong_result;
        int pobi_left_result = calculate(pobi_left, checkLength(pobi_left));
        int pobi_right_result = calculate(pobi_right, checkLength(pobi_right));
        int crong_left_result = calculate(crong_left, checkLength(crong_left));
        int crong_right_result = calculate(crong_right, checkLength(crong_right));

        if (pobi_left_result < pobi_right_result) {
            pobi_result = pobi_right_result;
        } else {
            pobi_result = pobi_left_result;
        }

        if (crong_left_result < crong_right_result) {
            crong_result = crong_right_result;
        } else {
            crong_result = crong_left_result;
        }

        if (pobi_result > crong_result) {
            answer = 1;
        } else if (pobi_result == crong_result) {
            answer = 0;
        } else {
            answer = 2;
        }

        return answer;
    }
    public static int checkLength(int num) {
        int cnt = 0;
        for (int i = num; i > 0;) {
            cnt++;
            i /= 10;
        }
        return cnt;
    }
    public static int calculate(int num, int length) {
        int add = 0, multiply = 1;
        for (int i = 0; i < length; i++) {
            add += num % 10;
            multiply *= num % 10;
            num /= 10;
        }
        if (add > multiply) {
            return add;
        } else {
            return multiply;
        }
    }
}