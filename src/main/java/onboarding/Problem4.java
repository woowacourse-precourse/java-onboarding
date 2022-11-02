package onboarding;

public class Problem4 {
    static char changeCharacter(char c) {
        int asciiCode = c;
        if (65 <= asciiCode && asciiCode <= 90)
            return (char) (155 - asciiCode);
        return (char) (219 - asciiCode);
    }

    static String concatResult(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                char res = changeCharacter(c);
                result.append(res);
                continue;
            }
            result.append(c);
        }
        return result.toString();
    }

    public static String solution(String word) {
        String answer = "";
        answer = concatResult(word);
        return answer;
    }
}
