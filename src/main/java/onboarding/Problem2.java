package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /**
     * 연속하는 중복 문자를 제거합니다.
     */
    private static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        int length = str.length();

        for (int i = 0; i < length - 1; i++) {
            char currentAlphabet = str.charAt(i);
            char nextAlphabet = str.charAt(i + 1);

            if (currentAlphabet != nextAlphabet) {
                result.append(currentAlphabet);

                // 더이상 비교할 것이 없다면 마지막 글자도 추가
                if (i == length - 2) {
                    result.append(nextAlphabet);
                }

                continue;
            }

            int endIndex = findDuplicateEndIndex(str, i);

            if (endIndex == length - 2) {
                result.append(str.charAt(length - 1));
                break;
            }

            i = endIndex;
        }

        return result.toString();
    }

    /**
     * 연속 중복이 끝나는 인덱스를 반환합니다.
     */
    private static int findDuplicateEndIndex(String str, int start) {
        int end = str.length() - 1;

        for (int i = start; i < str.length(); i++) {
            if (str.charAt(start) != str.charAt(i)) {
                end = i - 1;
                break;
            }
        }

        return end;
    }
}
