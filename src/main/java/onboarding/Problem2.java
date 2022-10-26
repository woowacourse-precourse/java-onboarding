package onboarding;

import onboarding.problem2.TextDecoder;
import onboarding.problem2.TextDecoderV1;

public class Problem2 {
    public static String solution(String cryptogram) {
        TextDecoder answer = new TextDecoderV1(cryptogram);
        return answer.getPlainText();
    }
}
