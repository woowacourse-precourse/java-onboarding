package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = "";
        int indexCnt = 1;
        String oneChar, twoChar;

        while (cryptogram.length() != indexCnt) {
            oneChar = String.valueOf(cryptogram.charAt(indexCnt-1));
            twoChar = String.valueOf(cryptogram.charAt(indexCnt));
            // 1. 연속 중복 문자 찾기
            if (oneChar.equals(twoChar)) {
                // 2. 연속 중복 문자 제거 및 인덱스 변경
                cryptogram = cryptogram.replaceFirst(oneChar + twoChar, "");
                indexCnt -= 2;
            }
            indexCnt++;
        }
        answer = cryptogram;
        return answer;
    }
}
