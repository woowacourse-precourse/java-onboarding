package onboarding;

import onboarding.P2.LetterDecode;
import onboarding.P2.LetterVerification;
public class Problem2 {
    public static String solution(String cryptogram) {
        LetterDecode letterDecode = new LetterDecode();
        LetterVerification letterVerification = new LetterVerification();

        if(letterVerification.LengthCheck(cryptogram)){
            throw new IllegalArgumentException("1글자 이상 1000글자 이하로 입력 해주세요.");
        }

        return letterDecode.RecursionDeCode(cryptogram);




    }
}
