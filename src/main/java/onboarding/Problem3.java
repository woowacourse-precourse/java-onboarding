package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String srcStr = String.valueOf(i);
            String removed369Str = get369removedString(srcStr);
            // 원본 문자열과 get369removedString으로부터 반환받은 문자열의 길이 차는 3, 6, 9의 개수이다.
            answer += (srcStr.length() - removed369Str.length());
        }
        return answer;
    }

    /**
     * 주어진 문자열에서 "3", "6", "9"를 찾아 빈 문자로 치환한 문자열을 반환한다.
     * @param numToString
     * @return "3", "6", "9"를 없앤 문자열
     */
    private static String get369removedString(String numToString) {
        return numToString.replaceAll("3", "").replaceAll("6", "").replaceAll("9", "");
    }

}
