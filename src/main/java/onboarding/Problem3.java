package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += count(i);
        }

        return answer;
    }

    private static int count(int n) {
        String s = String.valueOf(n);
        int cnt = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (canClap(c)) {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean canClap(char c) {
        return c == '3' || c == '6' || c == '9';
    }

}
