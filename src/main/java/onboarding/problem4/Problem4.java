package onboarding.problem4;

public class Problem4 {
    public static String solution(String word) {
        Message msg = new Message(word);
        return msg.encryptMessage();
    }
}
