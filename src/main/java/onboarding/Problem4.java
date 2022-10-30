package onboarding;

import onboarding.P4.GreenFrog;
import onboarding.P4.WordVerification;

public class Problem4 {
    public static String solution(String word) {
        GreenFrog greenFrog = new GreenFrog();
        WordVerification wordVerification = new WordVerification();

        if(!wordVerification.LengthCheck(word)){
            throw new IllegalArgumentException("1글자 이상 1000글자 이하로 입력 해주세요.");
        }


        return greenFrog.WordReverse(word);
    }



}
