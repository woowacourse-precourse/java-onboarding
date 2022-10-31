package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countThreeSixNine(i);
        }
        return answer;
    }

    public static int countThreeSixNine(int n) {
        String n_str = String.valueOf(n);
        int cnt = 0;
        for (int i = 0; i < n_str.length(); i++) {
            char digit = n_str.charAt(i);
            if (digit == '3' | digit == '6' | digit == '9') {
                cnt += 1;
            }
        }
        return cnt;
    }
}
