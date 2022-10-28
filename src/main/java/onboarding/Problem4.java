package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if (!isValidate(word)) {
            return "error";
        }
        String answer = "";
        return answer;
    }

    /**
     * word의 길이를 검증하는 기능
     */
    public static boolean isValidate(String word) {
        int length = word.length();
        return (length > 0 && length < 1001);
    }
}
