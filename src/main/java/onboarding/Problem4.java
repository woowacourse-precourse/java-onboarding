package onboarding;

import onboarding.problem4.GreenFrog;
public class Problem4 {
    public static String solution(String word) {
        GreenFrog greenFrog = new GreenFrog(word);
        return greenFrog.conversionCase();
    }
}
