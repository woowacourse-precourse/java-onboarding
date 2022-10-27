package onboarding;

public class Problem4 {
    private static final int BIG = 1;
    private static final int SMALL = 2;
    private static final int SPACE = 3;

    public static String solution(String word) throws Exception {
        String answer = "answer";
        char[] charArray = word.toCharArray();
        return answer;
    }
    public static int isBigOrSmall(char now) throws Exception{
        if(65 <= now && now <=90)return BIG;
        if(97 <= now && now <=122)return SMALL;
        if(now == 32)return SPACE;
        throw new IllegalArgumentException("알파벳이나 공백을 입력하시오");
    }
}
