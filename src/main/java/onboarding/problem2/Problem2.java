package onboarding.problem2;

public class Problem2 {
    public static String solution(String cryptogram) {
        Message answer = new Message(cryptogram);
        return answer.removeDuplicates();
    }
}
