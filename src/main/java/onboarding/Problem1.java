package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_score = max(pobi);
        int crong_score = max(crong);
        int answer = 0;
        if (pobi_score == -1 || crong_score == -1) {
            answer = -1;
        } else if (pobi_score > crong_score){
            answer = 1;
        } else if (pobi_score < crong_score){
            answer = 2;
        }
        return answer;
    }
    static int max(List<Integer> pages) {
        int page1 = pages.get(0);
        int page2 = pages.get(1);
        if (page1 % 2 == 0 || page1 < 3 || page1 > 397 || page1 + 1 != page2) {
            return -1;
        }
        int sum = 0, mult = 1;
        while (page1>0){
            int num = page1 % 10;
            sum += num;
            mult *= num;
            page1 /= 10;
        }
        while (page2>0){
            int num = page2 % 10;
            sum += num;
            mult *= num;
            page2 /= 10;
        }
        return Math.max(sum, mult);
    }
}

