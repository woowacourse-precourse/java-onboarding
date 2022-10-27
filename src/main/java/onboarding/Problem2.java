package onboarding;

public class Problem2 {

    //두번 반복되는 문자 삭제
    private static StringBuffer removeRepeat(StringBuffer cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                cryptogram.delete(i, i + 2);
                break;
            }
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        StringBuffer strBCcryptogram = new StringBuffer(cryptogram);
        
        return answer;
    }
}
