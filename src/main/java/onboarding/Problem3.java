package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int n = 1;

        while (n <= number) {
            String tmp = String.valueOf(n);
            for (int i = 0; i < tmp.length(); i++) {
                char ch = tmp.charAt(i);
                if (ch == '3' || ch == '6' || ch == '9') {
                    answer++;
                }
            }

            n++;
        }

        return answer;
    }
}
