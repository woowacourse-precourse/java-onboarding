package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if (violation(word)) return "ERROR";
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            answer.append(frog(c));
        }
        return answer.toString();
    }
    
    // 문자열이 적합한지 체크
    static boolean violation(String word) {
        int length = word.length();
        return length == 0 || length > 1000;
    }
    
    // 각 문자를 청개구리가 변환한 결과
    static char frog(char c) {
        char frogC = c;
        if (Character.isLowerCase(c)) {
            frogC = (char) ('z' - c + 'a');
        } else if (Character.isUpperCase(c)) {
            frogC = (char) ('Z' - c + 'A');
        }
        return frogC;
    }
}
