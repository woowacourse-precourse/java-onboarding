package onboarding;

// 알파벳 대문자인 경우
// 알파벳 소문자인 경우
// 둘다 아닐 경우
// a-z b-y 차가 35

/**
 * 기능 목록
 * 0. 대문자인지, 소문자인지, 그 외인지 판별하는 기능.
 * 1. 대문자일 경우, 변환하는 기능.
 * 2. 소문자일 경우, 변환하는 기능.
 * 3. 둘다 아닐 경우 처리
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public char convertBigAlphabet(char alphabet) {
        char result = (char) (155 - alphabet);
        return result;
    }

    // 대문자 1, 소문자 0, 둘다 아닐경우 -1
    public int checkAlphabetWhatType(char alphabet) {
        if (checkIsBigAlphabet(alphabet)) {
            return 1;
        } else if (checkIsSmallAlphabet(alphabet)) {
            return 0;
        }
        return -1;
    }

    private boolean checkIsBigAlphabet(char alphabet) {
        return compare(alphabet, 65, 90);
    }

    private boolean checkIsSmallAlphabet(char alphabet) {
        return compare(alphabet, 97, 122);
    }

    private boolean compare(char value, int first, int last) {
        if (value >= first && value <= last) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
