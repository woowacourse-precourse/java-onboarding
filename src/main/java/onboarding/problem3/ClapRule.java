package onboarding.problem3;

public class ClapRule {
    public boolean isClap(String string, int i) {
        return string.charAt(i) == '3' || string.charAt(i) == '6' || string.charAt(i) == '9';
    }
}
