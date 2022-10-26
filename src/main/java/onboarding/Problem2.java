package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (true) {
            int wordLength = cryptogram.length();
            char now = cryptogram.charAt(0);
            String Aftercryptogram = String.valueOf(now);
            int stack = 0;
            for (int i = 1; i<wordLength; i++) {
                if (now != cryptogram.charAt(i)) {
                    Aftercryptogram += cryptogram.charAt(i);
                    now = cryptogram.charAt(i);
                    stack = 0;
                } else {
                    if (stack==0) {
                        Aftercryptogram = Aftercryptogram.substring(0, Aftercryptogram.length() - 1);
                        stack+=1;
                    }
                }
            }
            System.out.println(Aftercryptogram);
            if (Aftercryptogram.equals(cryptogram)) break;
            cryptogram = Aftercryptogram;
            if (cryptogram.length()==0) break;
        }
        return cryptogram;
    }
}
