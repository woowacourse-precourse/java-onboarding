package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (checkRepetition(cryptogram)){
            cryptogram = removeRepetition(cryptogram);
        }
        return cryptogram;
    }
}

