package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // todo list
        // 알파벳 치트시트
        String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Z = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String a = "abcdefghijklmnopqrstuvwxyz";
        String z = "zyxwvutsrqpomnlkjihgfedcba";

        StringBuilder sb = new StringBuilder();

        // 대소문자 구분 변환 루프
        for(int i = 0; i < A.length(); i++) {
            // 알파벳인지 아닌지 체크
            char ch = word.charAt(i);
            boolean bool = (ch >= 'a' && ch <='z') || (ch >= 'A' && ch <= 'Z');
            boolean upper = ch >= 'A' && ch <= 'Z';
            boolean lower = ch >= 'a' && ch <='z';
            // 알파벳 변환만 구현하면 됨
            if(bool) {
                if(upper) {

                }
                if(lower) {

                }
            }

        }

        return sb.toString();
    }
}
