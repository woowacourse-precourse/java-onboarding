package onboarding.Problem2;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decodeQueue = new Decoder(cryptogram);
        while(decodeQueue.removeDuplicatedCharacter());
        return decodeQueue.toString();
    }
}
