package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String numString = Integer.toString(i);
            for (char c : numString.toCharArray()) {
                int n = c - '0';
                if (n == 3 || n == 6 || n == 9) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
