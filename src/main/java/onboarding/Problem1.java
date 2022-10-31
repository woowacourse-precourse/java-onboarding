package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_max = 0;
        int crong_max = 0;

        int pl = pobi.get(0);
        int pr = pobi.get(1);
        int cl = crong.get(0);
        int cr = crong.get(1);

        // 예외
        if (pr != (pl+1) || cr != (cl+1) ) {
            answer = -1;
            return answer;
        }

        int p_max_sum = max(addEachNumber(pl), addEachNumber(pr));
        int p_max_mul = max(multiplyEachNumber(pl), multiplyEachNumber(pr));
        pobi_max = max(p_max_sum, p_max_mul);

        int c_max_sum = max(addEachNumber(cl), addEachNumber(cr));
        int c_max_mul = max(multiplyEachNumber(cl), multiplyEachNumber(cr));
        crong_max = max(c_max_sum, c_max_mul);

        if (pobi_max > crong_max) {
            answer = 1;
        }
        else if (pobi_max < crong_max) {
            answer = 2;
        }
        else {
            answer = 0;
        }

        return answer;
    }

    // 각 자리 숫자 더하기
    static int addEachNumber(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // 각 자리 숫자 곱하기
    static int multiplyEachNumber(int num) {
        int multiplication = 1;
        while (num != 0) {
            multiplication *= num % 10;
            num /= 10;
        }
        return multiplication;
    }

    static int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

}