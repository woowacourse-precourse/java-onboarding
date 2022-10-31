package onboarding;

public class Problem4 {
    public static final int SMALL = 1;
    public static final int BIG = 2;
    public static final int ETC = 0;
    public static String solution(String word) {
        if(CheckInput(word)){
            char[] charArray = word.toCharArray();

            for(char c : charArray){
                if( Classification(c) == BIG){
                    System.out.println("BIG");
                }
                if( Classification(c) == SMALL){
                    System.out.println("SMALL");
                }
                if( Classification(c) == ETC){
                    System.out.println("ETC");
                }
            }

        }throw new IllegalArgumentException("잘못된 입력값");
    }

    /* 기능1 : input 확인 */
    private static boolean CheckInput(String word){
        if(word.length() > 0 && word.length() < 10001){
            System.out.println(word.length());
            return true;
        }return false;
    }

    /* 기능2 : 문자 구분 */
    private static int Classification(char charvalue){
        if(charvalue >= 65 && charvalue <=90) return BIG;
        if(charvalue >= 97 && charvalue <= 122) return SMALL;
        return ETC;
    }
}
