package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isWrongInput(pobi, crong)) return -1;

        int pobi_left_score = Math.max(plusScore(pobi.get(0)), multiplyScore(pobi.get(0)));
        int pobi_right_score = Math.max(plusScore(pobi.get(1)), multiplyScore(pobi.get(1)));
        int crong_left_score = Math.max(plusScore(crong.get(0)), multiplyScore(crong.get(0)));
        int crong_right_score = Math.max(plusScore(crong.get(1)), multiplyScore(crong.get(1)));

        int pobi_max_score = Math.max(pobi_left_score, pobi_right_score);
        int crong_max_score = Math.max(crong_left_score, crong_right_score);

        return (pobi_max_score > crong_max_score) ? 1 : (pobi_max_score < crong_max_score) ? 2 : 0;
    }

    private static int plusScore(int num) {
        int total_score = 0;
        while(num > 0) {
            total_score += num % 10;
            num /= 10;
        }
        return total_score;
    }

    private static int multiplyScore(int num) {
        int total_score = 1;
        while(num > 0) {
            total_score *= num % 10;
            num /= 10;
        }
        return total_score;
    }

    private static boolean isWrongInput(List<Integer> pobi, List<Integer> crong) {
        if(pobi.size() != 2 || crong.size() != 2) return true;
        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) return true;

        return false;
    }
}