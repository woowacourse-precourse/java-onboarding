package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static int characterClassification(char word) {
        if (word >= 65 && word <= 90) {
            return 1;
        } else if (word >= 97 && word <= 122) {
            return 2;
        }
        return 0;
    }

}
