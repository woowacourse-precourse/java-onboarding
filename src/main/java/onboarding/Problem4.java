package onboarding;

import onboarding.problem4.ContraryCharacter;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answerBuilder = new StringBuilder();
        for(Character character : word.toCharArray()){
            answerBuilder.append(new ContraryCharacter(character).character());
        }
        return answerBuilder.toString();
    }
}
