package onboarding;

import java.util.List;

class Problem1 {
    public int calScore(String str) {
        int mulTmp = 1, addTmp = 0;
        for (int i = 0; i < str.length(); i++) {
            addTmp += Character.getNumericValue(str.charAt(i));;
            mulTmp *= Character.getNumericValue(str.charAt(i));;
        }
        int maxScore = Math.max(addTmp, mulTmp);
        return maxScore;
    }

    public int showScore(List<Integer> pages) {
        int odd = pages.get(0);
        int even = pages.get(1);

        String oddStr = Integer.toString(odd);
        String evenStr = Integer.toString(even);

        int score = Math.max(calScore(oddStr), calScore(evenStr));

        return score;
    }

    public int versusScore(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = showScore(pobi);
        int crongScore = showScore(crong);

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();
        int answer = problem1.versusScore(pobi, crong);
        return answer;
    }
}