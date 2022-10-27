package onboarding;

import onboarding.domain.MessageConvertor;

public class Problem4 {
    public static String solution(String word) {
        MessageConvertor messageConvertor = new MessageConvertor(word);
        return messageConvertor.getConvertResult();
    }
}
