package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String[] stringArray = word.split(" ");

        if (throwBoundaryException(word)) {
            return "failed with boundary exception";
        }

        for (String eachWord : stringArray) {

        }

        return ;
    }

    public static boolean throwBoundaryException(String word) {

        return word.length() < 1 || word.length() > 1000;
    }

    public static boolean isAlphabet(char word) {
        return word < 65 || word > 122 || (word > 90 && word < 97);
    }

    public static boolean isLowerCase(char word) {
        return word >= 97 && word <= 122;
    }

}
