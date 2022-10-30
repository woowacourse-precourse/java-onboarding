package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = decrypt(word);
        return answer;
    }

    private static String decrypt(String word) {
        StringBuilder outputBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            outputBuilder.append(getMatchingCharacter(cur));
        }

        return outputBuilder.toString();
    }

    private static char getMatchingCharacter(char input) {
        if (!Character.isLetter(input)) return input;

        boolean isUpperCase = 'a' > input;
        char standard = isUpperCase ? 'A' : 'a';

        int index = input - standard;
        return (char) (standard + 25 - index);
    }
}
