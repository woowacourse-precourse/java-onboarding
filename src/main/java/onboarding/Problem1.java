package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.size() != 2 || crong.size() != 2) return -1;
        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) return -1;

        int pobi_high_score0 = Math.max(plus_score(pobi.get(0)), multiply_score(pobi.get(0)));
        int pobi_high_score1 = Math.max(plus_score(pobi.get(1)), multiply_score(pobi.get(1)));
        int crong_high_score0 = Math.max(plus_score(crong.get(0)), multiply_score(crong.get(0)));
        int crong_high_score1 = Math.max(plus_score(crong.get(1)), multiply_score(crong.get(1)));

        int pobi_max_score = Math.max(pobi_high_score0, pobi_high_score1);
        int crong_max_score = Math.max(crong_high_score0, crong_high_score1);

        return (pobi_max_score > crong_max_score) ? 1 : (pobi_max_score < crong_max_score) ? 2 : 0;
    }

    public static int plus_score(int num) {
        int total_score = 0;
        while(num > 0) {
            total_score += num % 10;
            num /= 10;
        }
        return total_score;
    }

    public static int multiply_score(int num) {
        int total_score = 1;
        while(num > 0) {
            total_score *= num % 10;
            num /= 10;
        }
        return total_score;
    }

}