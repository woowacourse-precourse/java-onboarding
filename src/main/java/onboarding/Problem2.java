package onboarding;

import onboarding.support.problem2.DecodeUtil;

public class Problem2 {
    public static String solution(String cryptogram) {
        DecodeUtil decodeUtil = new DecodeUtil(cryptogram);
        return decodeUtil.getDecodedString();
    }
}
