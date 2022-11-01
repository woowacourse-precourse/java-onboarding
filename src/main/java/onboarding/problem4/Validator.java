package onboarding.problem4;

public class Validator {
    public static boolean validate(String word){
        int length = word.length();
        return (length >= 1) && (length <=1000);
    }
}
