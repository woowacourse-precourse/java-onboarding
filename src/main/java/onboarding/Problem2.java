package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String beforeDec = cryptogram;
        String afterDec;

        while(true) {
            afterDec = decrypt(beforeDec);
            if (beforeDec.equals(afterDec)) {
                break;
            }
            beforeDec = afterDec;
        }

        return afterDec;
    }
}
