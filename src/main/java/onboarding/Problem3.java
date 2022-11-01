package onboarding;

public class Problem3 {
    private static int isClap(int digit) {
        if (digit != 0 && digit % 3 == 0) {
            return 1;
        }
        return 0;
    }
    private static int countClap(int number) {
        String numberToString = Integer.toString(number);
        int clapCount = 0;
        for (int i = 0; i < numberToString.length(); i++) {
            int digit = numberToString.charAt(i) - '0';
            clapCount += isClap(digit);
        }
        return clapCount;
    }
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }
}
