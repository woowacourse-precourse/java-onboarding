package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 중복 문자가 처음 발생하는 index 구하기
        int startIndex = -1;
        for (int i=0; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                startIndex = i;
                break;
            }
        }
        return cryptogram;
    }
}
