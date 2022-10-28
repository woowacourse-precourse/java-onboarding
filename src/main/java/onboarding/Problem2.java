package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
            // 문자열의 길이가 0일 경우 바로 종료
            if (answer.length() == 0) {
                return answer;
            }
            // 문자열이 대칭일 경우 빈 문자열 반환
            if (isReversible(answer)) {
                return "";
            }
    }
}
