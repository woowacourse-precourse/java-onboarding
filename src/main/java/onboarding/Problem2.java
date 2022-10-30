package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        String prev = removeDuplication(cryptogram);
        String next;
        while (true) {
            next = removeDuplication(prev);
            if (next.equals(prev)) {
                answer = next;
                break;
            }
            prev = next;
        }
        return answer;
    }
}
