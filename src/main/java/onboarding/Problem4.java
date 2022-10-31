package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char currentLetter = word.charAt(i);
            sb.append(makeFrogWord(currentLetter));
        }

        answer = sb.toString();
        return answer;
    }

    private static char makeFrogWord(char currentLetter) {
        if ((currentLetter >= 'A') && (currentLetter <= 'Z')) {
            return (char) ('Z' - currentLetter + 'A');
        }
        if ((currentLetter >= 'a') && (currentLetter <= 'z')) {
            return (char) ('z' - currentLetter + 'a');
        }

        return currentLetter;
    }
}