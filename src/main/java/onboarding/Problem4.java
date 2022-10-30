package onboarding;

import onboarding.problem4.FrogSpeaker;

public class Problem4 {
    public static String solution(String word) {
        FrogSpeaker frogSpeaker = new FrogSpeaker();

        return frogSpeaker.speak(word);
    }
}
