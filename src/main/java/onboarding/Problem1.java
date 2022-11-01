package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = pageNumberException(pobi, crong);
        if(answer == -1){
            return answer;
        }
        int pobiScore = compareScore(pageNumberHighScore(pobi, 0),pageNumberHighScore(pobi, 1));
        int crongScore = compareScore(pageNumberHighScore(crong, 0),pageNumberHighScore(crong, 1));
        answer = selectWinner(pobiScore, crongScore);
        return answer;
    }

    private static int pageNumberException(List<Integer> pobi, List<Integer> crong) {
        if((pobi.get(0)+1 != pobi.get(1)) || (crong.get(0)+1 != crong.get(1))){
            return -1;
        }
        return 0;
    }

    private static int pageNumberHighScore(List<Integer> pageNumberList, int direction) {
        int digitSum = 0;
        int digitMul = 1;
        int score = pageNumberList.get(direction);
        while(score > 0) {
            digitSum += score % 10;
            digitMul *= score % 10;
            score = score / 10;
        }
        return compareScore(digitSum, digitMul);
    }

    private static int compareScore(int compare1, int compare2){
        if(compare1 > compare2) return compare1;
        if(compare1 < compare2) return compare2;
        return compare2;
    }

    private static int selectWinner(int pobiScore, int crongScore){
        if(pobiScore > crongScore) return 1;
        if(pobiScore < crongScore) return 2;
        return 0;
    }
}