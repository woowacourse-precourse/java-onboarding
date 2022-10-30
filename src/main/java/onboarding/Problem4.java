package onboarding;


public class Problem4 {
    static final String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String smallLetters = "abcdefghijklmnopqrstuvwxyz";

    private static boolean isCapitalLetter(String character){

        return capitalLetters.contains(character);
    }
}
