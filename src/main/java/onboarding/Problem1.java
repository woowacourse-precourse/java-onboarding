package onboarding;

import java.util.List;

class Problem1 {
    static boolean check(int left, int right) {
        if (left >= right || right - left > 1 || left % 2 == 0 || right % 2 == 1)
            return true;
        else
            return false;
    }

    static int pow(int num) {
        int ans = 1;
        int test_num = num;
        int len;

        while (num / 10 != 0) {
            ans *= num % 10;
            num /= 10;
        }
        ans *= num;

        return ans;
    }

    static int add(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }

    static int bigger(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    static int output(int left, int right) {
        int l_big = bigger(add(left), pow(left));
        int r_big = bigger(add(right), pow(right));

        return bigger(l_big, r_big);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (check(pobi.get(0), pobi.get(1)) || check(crong.get(0), crong.get(1))) {
            answer = -1;
        } else {
            int p_ans = output(pobi.get(0), pobi.get(1));
            int c_ans = output(crong.get(0), crong.get(1));

            if (p_ans > c_ans)
                answer = 1;
            else if (p_ans < c_ans)
                answer = 2;
            else
                answer = 0;
        }

        return answer;
    }
}
