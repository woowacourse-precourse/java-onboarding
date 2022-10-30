package onboarding.Problem4;
public class Problem4 {
    private static Encoder encoder = new Encoder();
    public static String solution(String word)
    {
        if(word.length() > 10000)
        {
            throw new RuntimeException("입력된 단어의 길이가 제한 범위를 초과했습니다.");
        }
        return encoder.encode(word);
    }
}
