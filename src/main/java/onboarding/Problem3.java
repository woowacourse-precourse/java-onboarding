package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number ; i++) {
            String str = String.valueOf(i);
            if (str.contains("3")) {
                answer += str.length() - str.replaceAll("3", "").length();
            } else if (str.contains("6")) {
                answer += str.length() - str.replaceAll("6", "").length();
            } else if (str.contains("9")) {
                answer += str.length() - str.replaceAll("9", "").length();
            }
        }
        return answer;
    }
}
