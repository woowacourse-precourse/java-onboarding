package onboarding;

public class Problem4 {
    public static String solution(String word) throws Exception {
        validate(word);
        String answer = "";
        return answer;
    }

    private static void validate(String word) throws Exception {
        if (word.length() < 1 || word.length() > 1000) {
            throw new Exception("입력값의 길이가 잘못되었습니다");
        }
    }
}
