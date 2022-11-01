package onboarding;

/* 기능 목록
1. 문자열 순회해 앞, 뒤문자와 중복되지 않는 것만 남기기
2. 변경된 문자열에 새로운 중복 있는지 체크
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static String reduce(String input) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            boolean sameWithPrior = i > 0 && input.charAt(i - 1) == input.charAt(i);
            boolean sameWithAfter = i < input.length() - 1 && input.charAt(i + 1) == input.charAt(i);
            if (!sameWithAfter && !sameWithPrior) {
                builder.append(input.charAt(i));
            }
        }
        return builder.toString();
    }
}
