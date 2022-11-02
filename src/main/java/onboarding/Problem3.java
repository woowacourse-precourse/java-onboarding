package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int num = 1; num <= number; num++) {
            String numStr = String.valueOf(num);

            answer += count369(numStr);
        }
        return answer;
    }

    private static int count369(String numStr) {
        int cnt = 0;
        for (int i = 0; i < numStr.length(); i++) {
            if (is369(numStr, i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean is369(String numStr, int i) {
        return numStr.charAt(i) == '3' ||
                numStr.charAt(i) == '6' ||
                numStr.charAt(i) == '9';
    }
}
