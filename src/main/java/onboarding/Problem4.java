package onboarding;

import onboarding.problem4.Reverser;

public class Problem4 {


    public static String solution(String string) {
        Reverser reverser = new Reverser();
        return reverser.reverse(string);
    }
}
