package onboarding;

public class Problem4 {
    private static final int BIG = 1;
    private static final int SMALL = 2;
    private static final int SPACE = 3;

    public static String solution(String word) throws Exception {
        char[] charArray = word.toCharArray();
        char[] reverseArray = reverse(charArray);
        String answer = new String(reverseArray);
        return answer;
    }
    private static char[] reverse(char[] charArray) throws Exception {
        for(int index=0;index<charArray.length;index++){
            if(isBigOrSmall(charArray[index])==BIG){
                charArray[index]=(char)(90-(charArray[index]-65));
            };
            if(isBigOrSmall(charArray[index])==SMALL){
                charArray[index]=(char)(122-(charArray[index]-97));
            }
            if(isBigOrSmall(charArray[index])==SPACE)continue;
        }
        return charArray;
    }
    public static int isBigOrSmall(char now) throws Exception{
        if(65 <= now && now <=90)return BIG;
        if(97 <= now && now <=122)return SMALL;
        if(now == 32)return SPACE;
        throw new IllegalArgumentException("알파벳이나 공백을 입력하시오");
    }
}
