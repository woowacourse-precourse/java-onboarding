package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 1. 주어진 숫자(number)를 문자열로 변경함
        String numStr = numberToString(number);

        return answer;
    }

    // 입력받은 수를 문자열로 변환하여 반환함
    private static String numberToString(int number) {
        return Integer.toString(number);
    }
}
