package onboarding;


public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);  // 현재 문자
            answer.append(reverseCharacter(ch));  // 청개구리 변환
        }

        return answer.toString();
    }

    private static char reverseCharacter(char character) {
        // no reverse (문자가 아닐 때)
        if (!Character.isAlphabetic(character)) {
            return character;
        }

        if (Character.isUpperCase(character)) {
            return (char) ('A' + 'Z' - character);
        } else {
            return (char) ('a' + 'z' - character);
        }
    }

}
