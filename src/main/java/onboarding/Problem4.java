package onboarding;

public class Problem4 {
    public static String solution(String word) {
        Message_p4 msg = new Message_p4(word);
        return msg.encryptMessage();
    }
}
