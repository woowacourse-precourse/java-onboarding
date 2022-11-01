package onboarding;

public class Problem2 {
    static int repeatStart, repeatDone;
    public static String solution(String cryptogram) {
        return decipher(cryptogram);
    }
    static String decipher(String cryptogram) {
        String deciphered = cryptogram;
        if (check(deciphered)) {
            deciphered = deciphered.substring(0, repeatStart)+deciphered.substring(repeatDone);
            return decipher(deciphered);
        }
        else {
            return deciphered;
        }
    }
    static boolean check(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                repeatStart=i;
                repeatDone = i+2;
                return true;
            }
        }
        return false;
    }
}
