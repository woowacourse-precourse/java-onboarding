package onboarding;

import onboarding.problem4.Encoder;

public class Problem4 {
    private static Encoder encoder = new Encoder();
    private static int MAX_WORD_LENGTH = 10000;
    public static String solution(String word)
    {
        if(word.length() > MAX_WORD_LENGTH)
        {
            throw new RuntimeException("입력된 단어의 길이가 제한 범위를 초과했습니다.");
        }
        return encoder.encode(word);
    }
}
