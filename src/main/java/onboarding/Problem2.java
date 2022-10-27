package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (true) {
            String decoded;
            if(cryptogram.length() < 2) decoded = cryptogram;
            else decoded = decodeCryptogram(cryptogram);
            if (cryptogram.equals(decoded)) break;
            cryptogram = decoded;
        }
        return cryptogram;
    }

    private static String decodeCryptogram(String cryptogram) {
        String newCrypt = "";
        char prev = ' ';

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            char now = cryptogram.charAt(i);
            char next = cryptogram.charAt(i + 1);
            if (now != prev && now != next) {
                newCrypt += now;
            }
            prev = now;
        }

        if (cryptogram.charAt(cryptogram.length() - 1) != cryptogram.charAt(cryptogram.length() - 2)) {
            newCrypt += cryptogram.charAt(cryptogram.length() - 1);
        }
        return newCrypt;
    }
}

