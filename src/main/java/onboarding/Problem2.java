package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /***
     * 중복 문자 여부 확인
     * @param cryptogram
     * @return
     */
    private static boolean check(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
