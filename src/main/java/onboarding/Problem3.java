package onboarding;


public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += getTotalClap(i);
        }

        return answer;
    }

    private static int getTotalClap(int number) {
        String str = String.valueOf(number);
        return str.replaceAll("[^3|6|9]", "").length();
    }
}