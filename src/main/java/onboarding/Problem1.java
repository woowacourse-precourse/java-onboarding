package onboarding;

import java.util.List;

class Problem1 {
    public int calScore(String str){
        int mulTmp = 0, addTmp = 0;
        for (int i = 0; i < str.length(); i++) {
            addTmp += (int)str.charAt(i);
            mulTmp *= (int)str.charAt(i);
        }
        int maxScore = Math.max(addTmp, mulTmp);
        return maxScore;
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