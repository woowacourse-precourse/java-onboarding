package onboarding;

public class Problem3 {

    public static final char THREE = '3';
    public static final char SIX = '6';
    public static final char NINE = '9';
    public static final char[] CLAP_NUMBERS = {THREE, SIX, NINE};
    public static final int START_NUMBER = 1;

    /**
     * @param number : 0-9 사이 문자 숫자
     * @return boolean : 박수를 쳐야 하는지
     */
    public static boolean isClapNumber(char number) {
        for (int i = 0; i < CLAP_NUMBERS.length; i++) {
            if (number == CLAP_NUMBERS[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param number : 자연수
     * @return int : number 까지 박수치는 횟수
     */
    public static int getClapsByNumber(int number) {
        String numberString = Integer.toString(number);
        int numberStringSize = numberString.length();
        int claps = 0;
        for (int i = 0; i < numberStringSize; i++) {
            if (isClapNumber(numberString.charAt(i))) {
                claps++;
            }
        }
        return claps;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = START_NUMBER; i <= number; i++) {
            answer += getClapsByNumber(i);
        }
        return answer;
    }
}
