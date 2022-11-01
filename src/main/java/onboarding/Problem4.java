package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String[] stringArray = word.split(" ");
        ArrayList<String> answerArray = new ArrayList<>();

        if (throwBoundaryException(word)) {
            return "failed with boundary exception";
        }

        for (String eachWord : stringArray) {
            answerArray.add(changeWord(eachWord));
        }

        return String.join(" ", answerArray);
    }

    public static boolean throwBoundaryException(String word) {

        return word.length() < 1 || word.length() > 1000;
    }

    public static boolean isNotAlphabet(char word) {
        return word < 65 || word > 122 || (word > 90 && word < 97);
    }

    public static boolean isLowerCase(char word) {
        return word >= 97 && word <= 122;
    }

    public static String changeWord(String word) {
        char[] charArray = word.toCharArray();
        int index;

        for (index = 0; index < charArray.length; index++) {
            if (isNotAlphabet(charArray[index])) {
                continue;
            }

            if (isLowerCase(charArray[index])) {
                charArray[index] += 219 - (2 * charArray[index]);
                continue;
            }

            charArray[index] += 155 - (2 * charArray[index]);
        }

        return String.valueOf(charArray);
    }

}
