package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            char[] chars = Integer.toString(i).toCharArray();

            for (char c : chars) {
                int n = Character.getNumericValue(c);
                if (n > 0 && n % 3 == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
