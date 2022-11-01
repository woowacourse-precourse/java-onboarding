package onboarding;

import java.util.List;

class Problem1 {
    //예외처리 함수
    private static boolean checkCorrectOf(List<Integer> player){
        if(player.get(1) - player.get(0) != 1) return false;
        else if(player.get(0)==null || player.get(1) ==null) return false;
        else if(player.get(0) > 400 || player.get(1) == 400) return false;
        else if(player.get(0) < 1 || player.get(1) < 1) return false;
        return true;
    }
    //Player의 점수를 계산
    private static int getScoreOf(List<Integer> player){
        int score = 0;
        for (int num : player) {
            int sumOfNum = 0;
            int mulOfNum = 1;
            while (num != 0) {
                sumOfNum += num % 10;
                mulOfNum *= num % 10;
                num /= 10;
            }
            if (score < mulOfNum)
                score = mulOfNum;
            if (score < sumOfNum)
                score = sumOfNum;
        }
        return score;
    }
    //2명의 Player중 승자를 반환
    private static int winnerBetween(int scoreOfPlayer1, int scoreOfPlayer2){
        if(scoreOfPlayer1 > scoreOfPlayer2) return 1;
        else if(scoreOfPlayer1 < scoreOfPlayer2) return 2;
        else return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!checkCorrectOf(pobi) || !checkCorrectOf(crong)) return -1;

        int scoreOfPobi = getScoreOf(pobi);
        int scoreOfCrong = getScoreOf(crong);

        return winnerBetween(scoreOfPobi, scoreOfCrong);
    }
}