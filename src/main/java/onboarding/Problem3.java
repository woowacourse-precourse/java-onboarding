package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            String str = Integer.toString(i);
            result += str.length() - str.replaceAll("3|6|9", "").length();
        }
        return result;
    }
}
