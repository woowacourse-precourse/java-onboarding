package onboarding;

import java.util.List;

class Problem1 {
    static boolean check_range (int page){
        if(page<0||page>400)
            return true;
        return false;
    }
    static boolean exception_check(int left, int right) {
        if (check_range(left)||check_range(right)||left >= right || right - left > 1 || left % 2 == 0 || right % 2 == 1)
            return true;
        else
            return false;
    }

    static int pow(int num) {
        int pow_answer = 1;

        while (num / 10 != 0) {
            pow_answer *= num % 10;
            num /= 10;
        }
        pow_answer *= num;

        return pow_answer;
    }

    static int add(int num) {
        int add_answer = 0;
        while (num != 0) {
            add_answer += num % 10;
            num /= 10;
        }
        return add_answer;
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

        if (exception_check(pobi.get(0), pobi.get(1)) || exception_check(crong.get(0), crong.get(1))) {
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
