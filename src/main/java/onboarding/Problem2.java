package onboarding;

public class Problem2 {
    static boolean isvalid(String cryptogram){

        return true;
    }
    static String decrypt(String cryptogram){

        return new String("failed");
    }
    public static String solution(String cryptogram) {
        String answer = "answer";

        if (!isvalid(cryptogram))
            return new String("failed");
        answer = decrypt(cryptogram);
        return answer;
    }
}
