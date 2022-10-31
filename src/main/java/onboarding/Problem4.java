package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 알파벳 치트시트
        String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Z = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String a = "abcdefghijklmnopqrstuvwxyz";
        String z = "zyxwvutsrqponmlkjihgfedcba";

        StringBuilder sb = new StringBuilder();

        // 대소문자 구분 변환 루프
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            boolean upper = ch >= 'A' && ch <= 'Z';
            boolean lower = ch >= 'a' && ch <='z';

            if(upper) { // 대문자인지 체크
                sb.append(Z.charAt(A.indexOf(ch)));
                continue;
            }

            if(lower) { // 소문자인지 체크
                sb.append(z.charAt(a.indexOf(ch)));
                continue;
            }

            sb.append(ch);
        }

        return sb.toString();
        // 테스트 케이스 통과
    }
}
