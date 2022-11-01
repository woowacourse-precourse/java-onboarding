package onboarding;

//기능 목록
//1. 문자열을 역순으로 반환하는 기능

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder(word);

        for (int i = 0; i < answer.length(); i++) {
            answer.setCharAt(i, getFrogWord(answer.charAt(i)));
        }
        return answer.toString();
    }

    private static char getFrogWord(char reverse) {
        char result = reverse;

        if (Character.isUpperCase(reverse)) {
            result = (char)('A' + 'Z' - reverse);
        }

        if(Character.isLowerCase(reverse)) {
            result = (char)('a' + 'z' - reverse);
        }

        return result;
    }
}