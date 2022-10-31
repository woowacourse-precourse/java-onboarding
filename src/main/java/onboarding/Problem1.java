package onboarding;

import java.util.List;

class Problem1 {

    // 특정 숫자가 낼 수 있는 최대의 점수를 리턴하는 함수
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
        int pobi0 = pobi.get(0);
        int pobi1 = pobi.get(1);
        int crong0 = crong.get(0);
        int crong1 = crong.get(1);

        // 입력 받은 페이지가 주어진 페이지의 범위를 벗어날 때.
        boolean condition = pobi0 < 1 || pobi1 > 400 || crong0 < 1 || crong1 > 400;

        // 두 페이지가 연속하지 않을 때.
        boolean condition2 = !((pobi0 + 1 == pobi1) && (crong0 + 1 == crong1));

        // 왼쪽이 홀수가 아니거나, 오른쪽이 짝수가 아닐 때.
        boolean condition3 = ((pobi0 % 2 != 1) || (pobi1 % 2 != 0)) || ((crong0 % 2 != 1) || (crong1 % 2 != 0));

        int pobi_score = Math.max(function(pobi0), function(pobi1));
        int crong_score = Math.max(function(crong0), function(crong1));

        answer = crong_score > pobi_score ? 2 : 1;

        if(crong_score == pobi_score)
            answer = 0;

        if(condition || condition2 || condition3)
            answer = -1;

        return answer;
    }
}