package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = pro(cryptogram);

        return answer;
    }

    static String pro(String cryptogram) {
        boolean[] isDuplicated = new boolean[cryptogram.length()];  // 연속으로 중복되는 문자인지 기록하는 배열
        String s = "";

        for(int i = 1; i < cryptogram.length(); i++) {
            char curr = cryptogram.charAt(i);       // 이전 문자열
            char prev = cryptogram.charAt(i - 1);   // 현재 문자열
            if(curr != prev) continue;              // 서로 다른 경우
            else isDuplicated[i] = true;    isDuplicated[i - 1] = true; // 서로 같을 경우 true
        }

        for(int i = 0; i < cryptogram.length(); i++) {
            if(isDuplicated[i]) continue;       // 중복 문자일 경우
            else {
                char c = cryptogram.charAt(i);
                s += String.valueOf(c);         // 중복되지 않은 문자일 경우
            }
        }

        if(s.length() == cryptogram.length()) return s; // input 의 길이와 output 의 길이가 같다면 더 이상 해독팔 필요가 없다
        return pro(s);  // 재귀 호출
    }
}
