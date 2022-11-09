package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(true) {
            if(cryptogram.isEmpty()) return cryptogram;
            cryptogram += " ";
            String nextCryptogram = "";
            char current = cryptogram.charAt(0);
            int sameCount = 1;
            for(int cryptoIterator = 1; cryptoIterator < cryptogram.length() ; cryptoIterator++) {
                if(cryptogram.charAt(cryptoIterator) != current) {
                    if(sameCount == 1) nextCryptogram += current;
                    current = cryptogram.charAt(cryptoIterator);
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
}
