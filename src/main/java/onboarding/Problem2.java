package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    // 입력 받은 문자열을 주어진 조건에 따라 해독한다.
    static String decrypt(String cryptogram) {
        boolean[] isDuplicated = new boolean[cryptogram.length()];  // 연속으로 중복되는 문자의 인덱스를 기록하는 배열
        String new_cryptogram = "";

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
                new_cryptogram += String.valueOf(c);         // 중복되지 않은 문자일 경우
            }
        }

        if(new_cryptogram.length() == cryptogram.length()) {
            // input 의 길이와 output 의 길이가 같다면 더 이상 해독팔 필요가 없다
            return new_cryptogram;
        }
        return decrypt(new_cryptogram);  // 재귀 호출
    }
}
