package onboarding;

/** TODO
 * 1. 모든 자리 문자별로 뒤에 몇개까지 중복 되어있는지 확인
 * 2. 중복 된 만큼 제거
 * 3. 제거 했을 경우 flag true
 *  3-1. while문 flag true 일 경우 반복
 *  3-2. false 일 경우에는 마지막까지 중복 된 문자가 없고 제거된 것이 없으므로 종료
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean decoding = true;

        while (decoding) {
            decoding = false;

            for (int start = 0; start < answer.length() - 1; start++) {
                char currentChar = answer.charAt(start);

                int count = getDuplicatedCharCount(start, answer, currentChar);
                answer = removeDuplicateChar(answer, start, count);

                if (count > 0) {
                    decoding = true;
                    start--;
                }
            }
        }
        return answer;
    }

    private static int getDuplicatedCharCount(int start, String cryptogram, char currentChar) {
        int count = 0;
        for (int end = start + 1; end < cryptogram.length(); end++) {
            if (currentChar != cryptogram.charAt(end)) {
                break;
            }
            count = end - start + 1;
        }
        return count;
    }

    private static String removeDuplicateChar(String cryptogram, int start, int count) {
        return cryptogram.substring(0, start) + cryptogram.substring(start + count);
    }
}
