package onboarding;

public class Problem4 {
    private static final int BIG = 1;
    private static final int SMALL = 2;
    private static final int ELSE = 3;
    private static final int BIG_A = 65;
    private static final int BIG_Z = 90;
    private static final int SMALL_A = 97;
    private static final int SMALL_Z = 122;

    public static String solution(String word) throws Exception {
        String answer = new String(reverse(word.toCharArray()));
        return answer;
    }
    private static char[] reverse(char[] charArray){
        for(int index=0;index<charArray.length;index++){
            if(isBigOrSmall(charArray[index])==BIG){
                charArray[index]=(char)(BIG_Z-(charArray[index]-BIG_A));
            };
            if(isBigOrSmall(charArray[index])==SMALL){
                charArray[index]=(char)(SMALL_Z-(charArray[index]-SMALL_A));
            }
            if(isBigOrSmall(charArray[index])==ELSE)continue;
        }
        return charArray;
    }
    public static int isBigOrSmall(char now){
        if(65 <= now && now <=90)return BIG;
        if(97 <= now && now <=122)return SMALL;
        return ELSE;
    }
}
