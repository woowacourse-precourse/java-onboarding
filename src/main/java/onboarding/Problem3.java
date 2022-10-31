package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            char[] c = String.valueOf(i).toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (c[j] == '3' || c[j] == '6' || c[j] == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}
