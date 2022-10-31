package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if (isValid(word)) {
            String answer = "";
            return answer;
        } else
            return ""; // word의 길이가 주어진 범위를 벗어났을때
    }
    static boolean isValid(String word) {
        int len = word.length();
        if (len < 1 || len > 1000)
            return false;
        else
            return true;
    }
}
