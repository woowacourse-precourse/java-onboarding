package onboarding;

import java.util.List;

class Problem1 {

    static int function(int number) {
        char[] number_arr = (number+"").toCharArray();
        int number_len = number_arr.length;
        int number_add = 0;
        int number_mult = 1;

        for (int i = 0; i < number_len; i++) {
            int cur_digit = Integer.parseInt(String.valueOf(number_arr[i]));
            number_add += cur_digit;
            number_mult *= cur_digit;
        }

        return Math.max(number_add, number_mult);

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        boolean condition = pobi.contains(0) || pobi.contains(400) || crong.contains(0) || crong.contains(400);
        boolean condition2 = (pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1));

        int pobi_score = Math.max(function(pobi.get(0)), function(pobi.get(1)));
        int crong_score = Math.max(function(crong.get(0)), function(crong.get(1)));

        answer = crong_score > pobi_score ? 2 : 1;

        if(crong_score == pobi_score)
            answer = 0;

        if(condition && condition2)
            answer = -1;

        return answer;
    }
}