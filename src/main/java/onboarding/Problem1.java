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
}