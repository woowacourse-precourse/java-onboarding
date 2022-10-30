package onboarding;

import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);
        int crong_left = crong.get(0);
        int crong_right = crong.get(1);

        if (pobi_right - pobi_left != 1 || crong_right - crong_left != 1) {
            return -1;
        }
        int pobi_left_sum = getSum(pobi_left);
        int pobi_left_mul = getMul(pobi_left);
        int pobi_right_sum = getSum(pobi_right);
        int pobi_right_mul = getMul(pobi_right);
        List<Integer> pobi_numbers = List.of(pobi_left_sum, pobi_left_mul, pobi_right_sum, pobi_right_mul);
        int pobi_max = Collections.max(pobi_numbers);

        int crong_left_sum = getSum(crong_left);
        int crong_left_mul = getMul(crong_left);
        int crong_right_sum = getSum(crong_right);
        int crong_right_mul = getMul(crong_right);
        List<Integer> crong_numbers = List.of(crong_left_sum, crong_left_mul, crong_right_sum, crong_right_mul);
        int crong_max = Collections.max(crong_numbers);

        if (pobi_max > crong_max) {
            answer = 1;
        } else if (crong_max > pobi_max) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static int getSum(int n) {
        int ret = 0;
        while (n > 0) {
            ret += n % 10;
            n /= 10;
        }
        return ret;
    }

    public static int getMul(int n) {
        int ret = 1;
        while (n > 0) {
            ret *= n % 10;
            n /= 10;
        }
        return ret;
    }
}