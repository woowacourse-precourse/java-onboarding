package onboarding;

import onboarding.problem2.Decryption;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decryption decryption = new Decryption(cryptogram);
        return decryption.getResult();
    }

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
        System.out.println(solution("zyelleyz"));
    }
}
