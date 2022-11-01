package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int scorePobi = getMax(pobi);
        int scoreCrong = getMax(crong);
        if((pobi.get(1)-pobi.get(0)==1)&&(crong.get(1)-crong.get(0)==1)) {
            if (scorePobi < scoreCrong) {
                answer = 2;
            } else if (scorePobi == scoreCrong) {
                answer = 0;
            } else if (scorePobi > scoreCrong) {
                answer = 1;
            }
        }else {
            return -1;
        }
        return answer;
    }
    public static int getScore(Integer element){
        int score = 0;
        String elementStr = element.toString();
        int sum = 0;
        int multi = 1;
        int digit = 0;
        for(int i=0;i<elementStr.length();i++){
            digit = Integer.parseInt(Character.toString(elementStr.charAt(i)));
            sum += digit;

            if(digit!=0){
                multi *= digit;
            }
        }

        score = Math.max(sum, multi);

        return score;
    }
    public static int getMax(List<Integer> User){
        int scoreLeft = getScore(User.get(0));
        System.out.println(scoreLeft);
        int scoreRight = getScore(User.get(1));
        System.out.println(scoreRight);
        int scoreMax = Math.max(scoreLeft, scoreRight);

        return scoreMax;
    }
}