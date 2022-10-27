package onboarding;

import java.util.*;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        ArrayList<Integer> pobi_All = new ArrayList<>();
        ArrayList<Integer> crong_All = new ArrayList<>();

        // 1. 예외상황
        if (pobi.get(1) - pobi.get(0) != 1 | crong.get(1)-crong.get(0) != 1) {
            return -1;
        }
        for (int i = 0; i <= 1 ; i++) {
            pobi_All.add(max_value(pobi.get(i)));
            crong_All.add(max_value(crong.get(i)));
        }
        int pobi_max = Collections.max(pobi_All);
        int crong_max = Collections.max(crong_All);

        // 3. 결과값 출력
        if (pobi_max > crong_max) {return 1;}
        else if(crong_max > pobi_max) {return 2;}
        else{return 0;}
    }

    // 2. 페이지 별 최댓값 계산
    public static int max_value(Integer num) {
        int tmp_sum = 0;
        int tmp_mul = 1;
        while( num > 0) {
            tmp_sum += num % 10;
            tmp_mul *= num % 10;
            num /= 10;
        }
        return max(tmp_sum, tmp_mul);
    }
}