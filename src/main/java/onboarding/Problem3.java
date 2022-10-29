package onboarding;

public class Problem3 {
    public static final String GAME_NUMBER = "369";

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int countIncludedNumberOfGameNumber(int number){
        String[] numberArray =  Integer.toString(number).split("");
        int count = 0;
        for (String num: numberArray){
            if(GAME_NUMBER.contains(num)){
            count++;
            }
        }
        return count;
    }
}
