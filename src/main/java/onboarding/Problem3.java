package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String s = String.valueOf(i);

            for (int j = 0; j < s.length(); j++) {
                int n = s.charAt(j);
                if (n == '3' || n == '6' || n == '9') answer++;
            }
        }

        return answer;
    }
}
