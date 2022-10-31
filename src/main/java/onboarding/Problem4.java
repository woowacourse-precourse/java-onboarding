package onboarding;

public class Problem4 {
    static final int reverseNum = 25;
    public static String solution(String word) {
        String answer = "";

        checkException(word);

        answer = returnAlpha(word);

        return answer;
    }

    //변환한 알파벳을 반환
    public static String returnAlpha(String word) {
        String reverse_str = "";

        for (int i = 0; i < word.length(); i++)
            reverse_str += reverseAlpha(word.charAt(i));

        return reverse_str;
    }
    //알파벳을 반대로 변환
    public static char reverseAlpha(char alpha) {
        int minus = 0;

        //대문자일 경우
        if (Character.isUpperCase(alpha)) {
            minus = alpha - 'A';
            alpha = (char)(alpha + reverseNum - (minus * 2));
        }
        //소문자일 경우
        else if (Character.isLowerCase(alpha)) {
            minus = alpha - 'a';
            alpha = (char)(alpha + reverseNum - (minus * 2));
        }

        return alpha;
    }
    /*
    예외 처리 함수
     */
    public static void checkException(String word) {
        if (word.length() < 1 || word.length() > 1000)
            throw new IllegalArgumentException("ERROR");
    }
}
