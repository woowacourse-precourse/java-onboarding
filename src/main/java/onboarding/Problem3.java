package onboarding;

/**
 * Programs should be written for people to read, and only incidentally for machine to execute
 */

public class Problem3 {
    public static int solution(int number) {
        long countClap = 0L; // answer 이 될 박수 친 총 횟수
        for(int i = 1; i <= number; i++){
            String numberToString = String.valueOf(i);
            countClap += getCountOfChar(numberToString, '3');
            countClap += getCountOfChar(numberToString, '6');
            countClap += getCountOfChar(numberToString, '9');
        }
        int answer = (int) countClap;
        return answer;
    }

    /**
     * stream을 이용해 해당 문자열에 특정 문자의 개수를 센다.
     */

    public static long getCountOfChar(String str, char ch){
        return str.chars().filter(c -> c == ch).count();
    }
}
