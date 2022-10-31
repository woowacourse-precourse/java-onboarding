package onboarding;

import onboarding.problem4.Translator;

public class Problem4 {
    public static String solution(String word) {
        Translator translator = new Translator(
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",
                "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba");
        return translator.translate(word);
    }
}
