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
    // main 함수
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore;
        int crongScore;

        // 예외 케이스
        if (!(crong.get(0).equals(crong.get(1) - 1))||!(pobi.get(0).equals(pobi.get(1) - 1))){
            return -1;
        }
        pobiScore = finalScore(pobi);
        crongScore = finalScore(crong);

        // 제한 조건
        if(pobiScore == crongScore){
            return 0;
        }
        else if (pobiScore > crongScore){
            return 1;
        }
        else{
            return 2;
        }
    }
}