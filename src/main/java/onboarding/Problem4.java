package onboarding;

/**
 * 📚 기능 목록
 *
 * 1. 문자를 알파벳 역순으로 매칭하여 변환하는 기능
 */
public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder(word);

        for (int i = 0; i < answer.length(); i++) {
            answer.setCharAt(i, getFlipWord(answer.charAt(i)));
        }
        return answer.toString();
    }

    private static char getFlipWord(char letter) {
        char result = letter;

        if (Character.isUpperCase(letter)) {
            result = (char)('A' + 'Z' - letter);
        }

        if(Character.isLowerCase(letter)) {
            result = (char)('a' + 'z' - letter);
        }

        return result;
    }
}
