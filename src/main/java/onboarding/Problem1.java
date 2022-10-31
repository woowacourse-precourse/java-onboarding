package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static boolean checkException(List<Integer> player){
        if(player.get(0) < 1 || player.get(1) < 1 || player.get(0) > 400 || player.get(1) > 400){
            return false;
        }
        if (player.get(0) + 1 != player.get(1)){
            return false;
        }
        return true;
    }
    public static List<Integer> splitPagenumber(Integer pagenumber){
        List<Integer> pageSplits = new ArrayList<>();
        while(pagenumber > 0){
            pageSplits.add(pagenumber%10);
            pagenumber /= 10;
        }
        return pageSplits;
    }
    public static int pagenumberSum(List<Integer> pageSplits){
        int pagenumberSum = 0;
        for (int i = 0; i < pageSplits.size(); i++) {
            pagenumberSum += pageSplits.get(i);
        }
        return pagenumberSum;
    }
    public static int pagenumberMultiply(List<Integer> pageSplits){
        int pagenumberMultiply = 1;
        for (int i = 0; i < pageSplits.size(); i++) {
            pagenumberMultiply *= pageSplits.get(i);
        }
        return pagenumberMultiply;
    }
    public static int decideBiggest(int number1, int number2){
        if(number1 > number2){
            return number1;
        }
        return number2;
    }
    public static int decideWinner(int scorePobi, int scoreCrong){
        if(scorePobi > scoreCrong){
            return 1;
        }
        else if (scoreCrong < scorePobi) {
            return 2;
        }
        else if (scorePobi == scoreCrong) {
            return 0;
        }
        return -1;
    }
}