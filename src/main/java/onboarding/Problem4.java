package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char character: word.toCharArray()) {
            answer.append(getOppositeLetter(character));
        }
        return answer.toString();
    }

    private static char getOppositeLetter(char c) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }
        if (Character.isLowerCase(c)) {
            int diff = 'z' - c;
            return (char)('a' + diff);
        }
        int diff = 'Z' - c;
        return (char)('A' + diff);
    }
}
