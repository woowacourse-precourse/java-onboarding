package onboarding;

import onboarding.problem4.Dictionary;
import onboarding.problem4.GreenFrog;
import onboarding.problem4.Mother;
import org.assertj.core.internal.Strings;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        Mother mother = new Mother();
        GreenFrog greenFrog = mother.say(word);

        try {
            Dictionary dictionary = new Dictionary(word);

            return greenFrog.answer(dictionary);
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        String input = "I love you";
        System.out.println(solution(input));
    }
}
