package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 상황들은 return -1
        if (       pobi.get(1) - pobi.get(0) != 1
                || crong.get(1) - crong.get(0) != 1
                || pobi.get(0) < 1 || pobi.get(0) > 400
                || pobi.get(1) < 1 || pobi.get(1) > 400
                || crong.get(0) < 1 || crong.get(0) > 400
                || crong.get(1) < 1 || crong.get(1) > 400
                || pobi.get(0)%2 != 1
                || pobi.get(1)%2 != 0
                || crong.get(0)%2 != 1
                || crong.get(1)%2 != 0
        ) { return -1; }

        int pobi_leftpage = make_max_number(pobi.get(0));
        int pobi_rightpage = make_max_number(pobi.get(1));
        int pobi_maxnum = Math.max(pobi_leftpage,pobi_rightpage);

        int crong_leftpage = make_max_number(crong.get(0));
        int crong_rightpage = make_max_number(crong.get(1));
        int crong_maxnum = Math.max(crong_leftpage,crong_rightpage);

        if (pobi_maxnum > crong_maxnum)
            answer = 1;
        else if (pobi_maxnum < crong_maxnum)
            answer = 2;
        else answer = 0;

        return answer;
    }

    private static int make_max_number(int page) {
        int copypage1 = page;
        int copypage2 = page;

        // 각 자리수를 다 더한 plus_sum과, 각 자리수를 다 곱한 multiple_sum을 선언 
        int plus_sum = 0;
        int multiple_sum = 1;

        // 각 자리수 모두 더하기
        while (copypage1 > 0) {
            plus_sum += copypage1 % 10;
            copypage1 = copypage1 / 10;
        }
        // 각 자리수 모두 곱하기
        while (copypage2 > 0) {
            multiple_sum *= copypage2 % 10;
            copypage2 = copypage2 / 10;
        }

        return Math.max(plus_sum,multiple_sum);
    }
}