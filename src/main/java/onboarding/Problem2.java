package onboarding;

public class Problem2 {
    private static final int MAX_LENGTH = 1000;
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = replaceChar(cryptogram);
        return answer;
    }

    private static String replaceChar(String cryptogram) {
        String tmp;
        String answer;
        answer = cryptogram.replaceAll("([a-z])\\1", "");
        for(int i=0; i < MAX_LENGTH; i++) {
            tmp = answer;
            answer = answer.replaceAll("([a-z])\\1", "");

            // 이전과 결과가 같을경우 반복문 탈출
            if(answer.equals(tmp)) {
                break;
            }
        }
        return answer;
    }
}
