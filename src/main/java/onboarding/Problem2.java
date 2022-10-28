package onboarding;

// 중복된 문자열 검사
// 어렵다...
public class Problem2 {

    public static String overlapRemover(String cryptogram) {
        StringBuilder cryptogramStringBuilder = new StringBuilder(cryptogram);

        int i = 0;

        // 암호 문자열 길이 -1 까지 반복한다.
        while (i < cryptogramStringBuilder.length() - 1) {
            int overlapStartIndex = 0;
            int overlapEndIndex = 0;
            
            // 인덱스 0, 1 쌍을 시작으로하여 순차적으로 비교를 시작한다. 그 값이 같을경우 제거 로직 시작
            if (cryptogramStringBuilder.charAt(i) == cryptogramStringBuilder.charAt(i + 1)) {
                overlapStartIndex = i;
                overlapEndIndex = i + 1;

                while (overlapEndIndex + 1 < cryptogramStringBuilder.length()) {
                    if (cryptogramStringBuilder.charAt(overlapEndIndex) ==
                            cryptogramStringBuilder.charAt(overlapEndIndex + 1)) {
                        overlapEndIndex += 1;
                    }
                    else if (cryptogramStringBuilder.charAt(overlapEndIndex) !=
                            cryptogramStringBuilder.charAt(overlapEndIndex + 1)) {
                        break;
                    }
                }
                // 중복 문자열 제거 후 처음 부터 다시 검사
                cryptogramStringBuilder.delete(overlapStartIndex, overlapEndIndex + 1);
                i = 0;
            }
            else if (cryptogramStringBuilder.charAt(i) != cryptogramStringBuilder.charAt(i + 1)) {
                i += 1;
            }
        }
        return cryptogramStringBuilder.toString();
    }

    public static String solution(String cryptogram) {
        return overlapRemover(cryptogram);
    }
}
