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

    public static boolean checkAlpha(Character target) {
        String isAlphaRegex = "^[a-zA-Z]$";
        return target.toString().matches(isAlphaRegex);
    }

    public static boolean checkUpper(Character target) {
        String isUpperRegex = "^[A-Z]$";
        return target.toString().matches(isUpperRegex);
    }

    public static Character changeCharUpperCase(Character target) {
        int diff = target - UPPER_FIRST_CHARACTER;
        return (char) (UPPER_LAST_CHARACTER - diff);
    }

    public static boolean checkLower(Character target) {
        String isLowerRegex = "^[a-z]$";
        return target.toString().matches(isLowerRegex);
    }

    public static Character changeCharLowerCase(Character target) {
        int diff = target - LOWER_FIRST_CHARACTER;
        return (char) (LOWER_LAST_CHARACTER - diff);
    }

    public static String makeAnswer(String target) {
        StringBuilder makeAnswer = new StringBuilder();

        char[] wordCharArray = target.toCharArray();
        for (char wordChar : wordCharArray) {
            System.out.println(":" + wordChar);
            if (checkAlpha(wordChar)) {
                if (checkLower(wordChar)) {
                    makeAnswer.append(changeCharLowerCase(wordChar));
                } else if (checkUpper(wordChar)) {
                    makeAnswer.append(changeCharUpperCase(wordChar));
                }
            } else {
                makeAnswer.append(wordChar);
            }
        }

        return makeAnswer.toString();
    }
}
