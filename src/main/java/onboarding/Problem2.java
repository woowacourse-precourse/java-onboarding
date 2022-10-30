package onboarding;

public class Problem2 {
    /** 문자열에서 연속적으로 중복되는 문자제거 */
    public static String removeDuplicate(String str) {
        for (int i = 0; i < 26; i++) {                                  // a-z까지 26번 반복
            String letter = Character.toString((char)((int)'a' + i));   // letter = a-z
            String pattern = letter + "{2,}";                           // letter 문자열이 2번 이상 반복되면
            str = str.replaceAll(pattern, "");              // 해당 문자 삭제
        }
        return str;
    }

    public static String solution(String cryptogram) {
        String prevStr = cryptogram;                        // 중복제거 전 문자열
        String nextStr = removeDuplicate(cryptogram);       // 중복제거 후 문자열

        while (prevStr != nextStr) {                // 중복제거 후 문자열이 중복제거 전 문자열과 같지 않으면
            prevStr = nextStr;                      // 중복제거 전 문자열을 중복제거 후 문자열로 갱신
            nextStr = removeDuplicate(prevStr);     // 중복제거 후 문자열
        }

        String answer = nextStr;        // 최종 중복제거된 문자열
        return answer;
    }
}
