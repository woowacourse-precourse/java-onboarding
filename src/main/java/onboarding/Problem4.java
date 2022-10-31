package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if(CheckInput(word)){

        }
        throw new IllegalArgumentException("잘못된 입력값");
    }

    /* 기능1 : input 확인 */
    private static boolean CheckInput(String word){
        if(word.length() > 0 && word.length() < 1001) return true;
        return false;
    }
}
