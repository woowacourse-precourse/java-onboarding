package onboarding;

public class Problem2 {
    /**
     * 암호문을 입력받아 해독한 결과를 리턴합니다.
     */
    public static String solution(String cryptogram) {
        // 문자열에 많은 mutation이 일어날 수 있으므로, StringBuilder를 사용합니다.
        StringBuilder s = new StringBuilder(cryptogram);

        Boolean removeHappened;
        do {
            removeHappened = removeFirstDuplicateChars(s);
        } while (removeHappened);

        return s.toString();
    }

    /**
     * 인접하면서 동일한 문자 두 개가 등장하는 첫 번째 경우, 그 문자들을 제거하고
     * {@code true}를 리턴합니다. 그런 경우가 없다면 {@code false}를 리턴합니다.
     */
    private static Boolean removeFirstDuplicateChars(StringBuilder s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                s.delete(i, i + 2);
                return true;
            }
        }
        return false;
    }
}
