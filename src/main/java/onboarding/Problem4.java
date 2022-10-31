package onboarding;

public class Problem4 {

    public static final Character UPPER_FIRST_CHARACTER = 'A';
    public static final Character UPPER_LAST_CHARACTER = 'Z';
    public static final Character LOWER_FIRST_CHARACTER = 'a';
    public static final Character LOWER_LAST_CHARACTER = 'z';

    public static String solution(String word) {
        String answer = "";

        answer = makeAnswer(word);

        return answer;
    }

    public static String makeAnswer(String target) {
        StringBuilder makeAnswer = new StringBuilder();

        String[] letters = target.split("");
        for (String letter : letters) {
            if (checkLower(letter)) {
                letter = changeCharLowerCase(letter.charAt(0));
            }
            if (checkUpper(letter)) {
                letter = changeCharUpperCase(letter.charAt(0));
            }
            makeAnswer.append(letter);
        }

        return makeAnswer.toString();
    }

    public static boolean checkUpper(String target) {
        String isUpperRegex = "^[A-Z]$";
        return target.matches(isUpperRegex);
    }

    public static String changeCharUpperCase(Character target) {
        int diff = target - UPPER_FIRST_CHARACTER;
        char changeTarget = (char) (UPPER_LAST_CHARACTER - diff);
        return Character.toString(changeTarget);
    }

    public static boolean checkLower(String target) {
        String isLowerRegex = "^[a-z]$";
        return target.matches(isLowerRegex);
    }

    public static String changeCharLowerCase(Character target) {
        int diff = target - LOWER_FIRST_CHARACTER;
        char changeTarget = (char) (LOWER_LAST_CHARACTER - diff);
        return Character.toString(changeTarget);
    }
}
