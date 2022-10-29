package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(true) {
            if(cryptogram.isEmpty()) return cryptogram;
            cryptogram += " ";
            String nextCryptogram = "";
            char current = cryptogram.charAt(0);
            int sameCount = 1;
            for(int i = 1; i < cryptogram.length() ; i++) {
                if(cryptogram.charAt(i) != current) {
                    if(sameCount == 1) nextCryptogram += current;
                    current = cryptogram.charAt(i);
                    sameCount = 1;
                }
                else {
                    sameCount ++;
                }
            }
            cryptogram = cryptogram.substring(0, cryptogram.length() - 1);
            if(nextCryptogram.equals(cryptogram)) break;
            cryptogram = nextCryptogram;
        }
        return cryptogram;
    }

    public static void main(String args[]) {
        System.out.println(solution("browoanoommnaon"));
    }
}
