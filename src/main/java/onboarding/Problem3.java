package onboarding;

public class Problem3 {
    public static int solution(int number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            builder.append(i);
        }
        return builder.length() - builder.toString().replaceAll("[369]", "").length();
    }
}
