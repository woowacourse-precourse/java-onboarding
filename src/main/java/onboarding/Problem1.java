package onboarding;

import java.util.List;

class Problem1 {
    public static boolean check_list(List<Integer> list) {
        return ((list.get(0) % 2 == 1) && (1 < list.get(0)) && (list.get(0) < 399) && (list.get(0) + 1 == list.get(1)));
    }

    public static int plus_check(int number) {
        int plus_answer = 0;

        while (number != 0) {
            plus_answer += number % 10;
            number /= 10;
        }

        return plus_answer;
    }

    public static int multi_check(int number) {
        int multi_answer = 1;

        while (number != 0) {
            multi_answer *= number % 10;
            number /= 10;
        }

        return multi_answer;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_result = 0;
        int crong_result = 0;

        if (check_list(pobi) && check_list(crong)) {
            int pobi_plus = Math.max(plus_check(pobi.get(0)), plus_check(pobi.get(1)));
            int pobi_multi = Math.max(multi_check(pobi.get(0)), multi_check(pobi.get(1)));

            pobi_result = Math.max(pobi_plus, pobi_multi);

            int crong_plus = Math.max(plus_check(crong.get(0)), plus_check(crong.get(1)));
            int crong_multi = Math.max(multi_check(crong.get(0)), multi_check(crong.get(1)));

            crong_result = Math.max(crong_plus, crong_multi);

            if (pobi_result == crong_result) {
                answer = 0;
            }
            else if ((pobi_result > crong_result)) {
                answer = 1;
            }
            else {
                answer = 2;
            }

        }
        else {
            answer = -1;
        }

        return answer;
    }
}