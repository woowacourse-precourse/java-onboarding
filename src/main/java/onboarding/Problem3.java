package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String numberString = Integer.toString(i);
            numberString = numberString.replaceAll("[^369]", "");

            answer += numberString.length();
        }

        return answer;
    }
}
