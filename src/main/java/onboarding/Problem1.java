package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);

        int crong_left = crong.get(0);
        int crong_right = crong.get(1);

        if (pobi_right - pobi_left != 1 || crong_right - crong_left != 1 || pobi_left <= 1 || pobi_right >= 400 || crong_left <= 1 || crong_right >= 400) {
            return -1;
        }

        return answer;
    }
}