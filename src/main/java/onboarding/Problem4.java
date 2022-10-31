package onboarding;

public class Problem4 {
    private static final int SMALL = 1;
    private static final int BIG = 2;
    private static final int ETC = 0;
    public static String solution(String word) {
        if(CheckInput(word)){
            char[] charArray = word.toCharArray();
            String ans = "";

            for(char charvalue : charArray){
                if( Classification(charvalue) == BIG) ans += ReverseBig(charvalue);
                if( Classification(charvalue) == SMALL) ans += ReverseSmall(charvalue);
                if( Classification(charvalue) == ETC) ans += charvalue;
            }return ans;
        }throw new IllegalArgumentException("잘못된 입력값");
    }

    /* 기능1 : input 확인 */
    private static boolean CheckInput(String word){
        if(word.length() > 0 && word.length() < 10001){
            return true;
        }return false;
    }

    /* 기능2 : 문자 구분 */
    private static int Classification(char charvalue){
        if(charvalue >= 65 && charvalue <=90) return BIG;
        if(charvalue >= 97 && charvalue <= 122) return SMALL;
        return ETC;
    }

    /* 기능3 : 소문자 변환 */
    private static char ReverseSmall(char small){
        return (char)(122-(small-97));
    }

    /* 기능3 : 대문자 변환 */
    private static char ReverseBig(char big){
        return (char)(90-(big-65));
    }
}
