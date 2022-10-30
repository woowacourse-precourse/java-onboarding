package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isValidate(pobi)==false||isValidate(crong) == false){
            return -1;
        }

        int pobiScore = finalScore(pobi.get(0));
        int crongScore = finalScore(crong.get(0));
        int answer = winner(pobiScore,crongScore);
        return answer;
    }

    private static int finalScore(int page) {
        int score = 0;
        score = Math.max(cacullateScore(page),cacullateScore(page+1));
        return score;
    }


    private static int cacullateScore(int page){
        int score1 = sumScore(page);
        int score2 = multipleScore(page);
        int score = Math.max(score1,score2);
        return score;
    }

    private static int winner(int score1, int score2) {
        if (score1 > score2) {
            return 1;
        }
        if (score1 < score2) {
            return -1;
        }
        return 0;
    }
    private static int sumScore(int page){
        String s = String.valueOf(page);
        int sum = 0;

        for (int len = s.length(), i = 0; i<len;i++) {
            sum += s.charAt(i) - '0';
        }
        return sum;
    }
    private static int multipleScore(int page){
        String s = String.valueOf(page);
        int multiple = 1;

        for (int len = s.length(), i = 0; i<len;i++) {
            multiple *= s.charAt(i) - '0';
        }
        return multiple;
    }

    private static boolean isValidate(List<Integer> page){
        if (page.get(1)-page.get(0)!=1){
            return false;
        }if (page.get(0)==1||page.get(1)==400){
            return false;
        }if (page.get(0)%2!=1){
            return false;
        }if (page.get(1)%2!=0){
            return false;
        }
        return true;
    }
}