/*
 * Problem2.java
 *
 * 2022-10-28
 *
 */
package onboarding;

/**
 * 우아한 테크코스 - 프리코스 1주차 암호문 해독
 *
 * @author 이준현
 * @version 2.00 2022년 11월 01일
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
     * 입력받은 문자열을 해독된 문자열로 만들어 return한다.
     *
     * @param str 해독할 문자열
     * @return 해독이 완료된 문자열 return
     */
    public static String decode(String str) {
        String result = str;
        while (checkDuplicates(result)) {
            result = deduplicate(result);
        }
        return result;
    }

    /**
     * 문자 내 중복이 존재하는지 확인하는 기능
     *
     * @param str 중복을 확인할 문자열
     * @return 중복이 있을시 true, 없을시 false
     */
    public static boolean checkDuplicates(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 문자열을 입력받고 처음으로 중복발생하는 부분을 제거하고 남은 subString에 재귀적으로 수행
     *
     * @param str 중복제거를 수행할 문자열
     * @return
     */
    public static String deduplicate(String str) {
        if (str.length() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder(str);
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = 0;
        start = findDuplicateStartIndex(builder);
        end = findDuplicateEndIndex(builder, start);
        if (end == start) {
            return str;
        }
        result.append(builder.substring(0, start));
        result.append(deduplicate(builder.substring(end + 1, builder.length())));
        builder.delete(start, end + 1);
        return result.toString();
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
        return 0;
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
        answer = decode(cryptogram);
        return answer;
    }
}