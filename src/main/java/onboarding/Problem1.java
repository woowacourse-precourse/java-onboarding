package onboarding;

import java.util.Iterator;
import java.util.List;

class Problem1 {
    public int calScore(String str){
        return 0;
    }
    public int showScore(List<Integer> pages){
        int odd = pages.get(0);
        int even = pages.get(1);

        String oddStr = Integer.toString(odd);
        String evenStr = Integer.toString(even);

        int score = Math.max(calScore(oddStr), calScore(evenStr));

        return score;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}