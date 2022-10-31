package onboarding;

public class Problem4 {
    private static final int BIG = 1;
    private static final int SMALL = 2;
    private static final int ELSE = 3;
    private static final int BIG_A = 65;
    private static final int BIG_Z = 90;
    private static final int SMALL_A = 97;
    private static final int SMALL_Z = 122;

    public static String solution(String word) {
        String answer = reverse(word.toCharArray());
        return answer;
    }
    private static String reverse(char[] charArray){
        for(int index=0;index<charArray.length;index++){
            charArray[index]=change(charArray[index]);
        }
        return new String(charArray);
    }
    private static char change(char tmp){
        if(isBigOrSmall(tmp)==BIG)tmp=(char)(BIG_Z-(tmp-BIG_A));
        if(isBigOrSmall(tmp)==SMALL)tmp=(char)(SMALL_Z-(tmp-SMALL_A));
        if(isBigOrSmall(tmp)==ELSE)tmp=tmp;//TMP MAINTAIN
        return tmp;
    }
    private static int isBigOrSmall(char now){
        if(65 <= now && now <=90)return BIG;
        if(97 <= now && now <=122)return SMALL;
        return ELSE;
    }
}
