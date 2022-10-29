/*
 * Problem2.java
 *
 * 2022-10-28
 *
 */
package onboarding;

/**
 * 우아한 테크코스 - 프리코스 1주차 페이지 번호 게임
 *
 * @author 이준현
 * @version 1.00 2022년 10월 27일
 */
public class Problem2 {

    /**
     * 입력받은 cryptogram이 문제의 조건에 맞는지 유효성을 검증하는 method
     *
     * @param str 입력받은 input String
     * @return 문제의 조건에 부합할시 true, 부적합할 시 false return
     */
    public static boolean validCheck(String str) {
        char[] charArray = str.toCharArray();
        if (str.length() > 1000 || str.length() < 1) {
            return false;
        }
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사이클마다 인접한 문자열의 시작, 끝 인덱스를 구하고 이를 이용하여 인접한 문자열 모두 제거하는 method
     *
     * @param str 인접한 중복 문자열을 제거할 string
     * @return 인접한 중복문자가 모두 제거된 string return
     */
    public static String deduplicate(String str) {
        StringBuilder builder = new StringBuilder(str);
        int start = 0;
        int end = 0;
        while (true) {
            start = findDuplicateStartIndex(builder);
            if (start == -1) {
                return builder.toString();
            }
            end = findDuplicateEndIndex(builder, start);
            builder.delete(start, end + 1);
        }
    }

    /**
     * string에 인접한 문자열중 중복인 subString의 시작 index를 구하는 method
     *
     * @param strBuilder 중복 인접문자열의 index를 구할 문자열 빌더
     * @return 중복 인접 문자열의 시작 index를 return
     */
    public static int findDuplicateStartIndex(StringBuilder strBuilder) {
        int start;
        for (int i = 1; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) == strBuilder.charAt(i - 1)) {
                start = i - 1;
                return start;
            }
        }
        return -1;
    }

    /**
     * string에 인접한 문자열중 중복인 subString의 마지막 index를 구하는 method
     *
     * @param strBuilder 중복 인접문자열의 index를 구할 문자열 빌더
     * @param start      중복 인접 문자열의 시작 index
     * @return 중복 인접 문자열의 마지막 index를 return
     */
    public static int findDuplicateEndIndex(StringBuilder strBuilder, int start) {
        int end = start;
        for (int i = start + 1; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) == strBuilder.charAt(start)) {
                end++;
            } else {
                break;
            }
        }
        return end;
    }

    /**
     * 중복 인접 문자열을 제거한 문자열을 return 하는 method
     *
     * @param cryptogram 중복 인접 문자열을 제거할 문자열 원본
     * @return 중복 인접 문자열이 제거된 문자열
     */
    public static String solution(String cryptogram) {
        if (!validCheck(cryptogram)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        String answer = "answer";
        answer = deduplicate(cryptogram);
        return answer;
    }
}
