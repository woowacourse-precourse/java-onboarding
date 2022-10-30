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

    public static boolean checkAlpha(String target) {
        String isAlphaRegex = "^[a-zA-Z]$";
        return target.matches(isAlphaRegex);
    }

    public static boolean checkUpper(String target) {
        String isUpperRegex = "^[A-Z]$";
        return target.matches(isUpperRegex);
    }

    public static Character changeCharUpperCase(Character target) {
        int diff = target - UPPER_FIRST_CHARACTER;
        return (char) (UPPER_LAST_CHARACTER - diff);
    }

    public static boolean checkLower(String target) {
        String isLowerRegex = "^[a-z]$";
        return target.matches(isLowerRegex);
    }

    public static Character changeCharLowerCase(Character target) {
        int diff = target - LOWER_FIRST_CHARACTER;
        return (char) (LOWER_LAST_CHARACTER - diff);
    }

    public static String makeAnswer(String target) {
        StringBuilder makeAnswer = new StringBuilder();

        String[] letters = target.split("");
        for (String letter : letters) {
            if (checkAlpha(letter)) {
                if (checkLower(letter)) {
                    makeAnswer.append(changeCharLowerCase(letter.charAt(0)));
                } else if (checkUpper(letter)) {
                    makeAnswer.append(changeCharUpperCase(letter.charAt(0)));
                }
            } else {
                makeAnswer.append(letter);
            }
        }

        return makeAnswer.toString();
    }
}
