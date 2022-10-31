package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = Math.max(score(pobi.get(0)), score(pobi.get(1)));
        int crongScore = Math.max(score(crong.get(0)), score(crong.get(1)));
        answer = Integer.compare(pobiScore, crongScore);
        if (answer == -1) answer = 2;
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) answer = -1;
        return answer;
    }
    public static int score(int page) {
        int sum = 0, multiply = 1;
        while (page > 0) {
            int num = page % 10;
            page /= 10;
            sum += num;
            multiply *= num;
        }
        return Math.max(sum, multiply);
    }
}