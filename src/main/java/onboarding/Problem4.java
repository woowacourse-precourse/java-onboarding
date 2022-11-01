package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c: chars) {
            sb.append(changeCharacter(c));
        }

        answer = sb.toString();
        return answer;
    }

    private static boolean isUpper(char c){
        if (c >= 'A' && c<= 'Z') return true;
        return false;
    }

    private static boolean isLower(char c){
        if (c >= 'a' && c<= 'z') return true;
        return false;
    }

    private static char changeCharacter(char c){
        // 사전은 알파벳 순서 반대로 매칭되어 있음-> 사전에서 매칭되어 있는 숫자끼리 더하면 '일정'하다
        final int UPPER = (int)'A' + (int)'Z';
        final int LOWER = (int)'a' + (int)'z';
        if (isUpper(c)) return (char) (UPPER - (int)c);
        if (isLower(c)) return (char) (LOWER - (int)c);
        return c;
    }
}
