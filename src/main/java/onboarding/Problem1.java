package onboarding;

import java.util.List;

class Problem1 {
    // 점수를 계산하는 함수
    static int calculateScore(int page){
        int addScore = 0, mulScore = 1;
        while (page > 0){
            int mod = page % 10;
            addScore += mod;
            mulScore *= mod;
            page /= 10;
        }
        return Math.max(addScore,mulScore);
    }
    // 해당 사람의 최종 점수를 뽑아내는 함수
    static int finalScore(List<Integer> person){
        int score = 0;
        for(Integer p : person){
            score = Math.max(score, calculateScore(p));
        }
        return score;
    }

}