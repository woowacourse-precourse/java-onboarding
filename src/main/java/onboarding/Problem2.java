package onboarding;

/* 기능 목록
 *
 *  canRemove : 문자열에서 다음 문자를 뺄 수 있는지 확인
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        for(char c : cryptogram.toCharArray()) {
            if(canRemove(answer, c)) {
                answer = answer.substring(0, answer.length() - 1);
                continue;
            }

            answer += c;
        }

        return answer;
    }

    private static boolean canRemove(String str, char c) {
        return !str.isEmpty() && str.endsWith(String.valueOf(c));
    }
}
