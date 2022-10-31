package onboarding;

public class Problem3 {
    // 박수를 쳐야하는 숫자 배열
    static final char[] CLAP_NUMBER = {'3', '6', '9'};
    // 전체 기능 호출
    public static int solution(int number) {
        return 1;
    }
    // 문자열로 받은 숫자의 자릿수마다 박수치는 숫자인지 탐색하는 기능
    private static int howManyClap(String number) {
        int clapTotal = 0;
        for (int i = 0; i < number.length(); i++) {
            if (isDigitClapNumber(number.charAt(i))) {
                clapTotal += 1;
            }
        }
        return clapTotal;
    }
    // 해당 문자열 타입의 숫자가 박수치는 숫자인지 판별하는 기능
    private static boolean isDigitClapNumber(char digit) {
        for (char c : CLAP_NUMBER) {
            if (digit == c) {
                return true;
            }
        }
        return false;
    }
}
