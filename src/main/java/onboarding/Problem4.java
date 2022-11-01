package onboarding;

public class Problem4 {
    private static char convertUpper(char letter) {
        int difference = letter - 65;
        int converted = 90 - difference;

        return (char) converted;

    }

    private static char convertLower(char letter) {
        int difference = letter - 97;
        int converted = 122 - difference;

        return (char) converted;
    }

    public static String solution(String word) {
        String answer = "";
        char letter;

        for (int i = 0; i < word.length(); i++) {
            letter = word.charAt(i);
            if ((letter >= 65) && (letter <= 90)) {
                answer += convertUpper(letter);
            } else if ((letter >= 97) && (letter <= 122)) {
                answer += convertLower(letter);
            } else {
                answer += letter;
            }
        }

        return answer;
    }
}
