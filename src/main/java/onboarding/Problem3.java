package onboarding;

/**
 * Programs should be written for people to read, and only incidectally for machine to execute
 */

public class Problem3 {
    public static int solution(int number) {
        long countClap = 0L;
        for(int i=1; i<=number; i ++){
            String numberToString = String.valueOf(i);
            countClap += getCountOfChar(numberToString, '3');
            countClap += getCountOfChar(numberToString, '6');
            countClap += getCountOfChar(numberToString, '9');
        }
        int answer = (int) countClap;
        return answer;
    }

    public static long getCountOfChar(String str, char ch){
        return str.chars().filter(c -> c == ch).count();
    }
}
