package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        String decrypted = cryptogram;

        do {
            cryptogram = decrypted;
            decrypted = eliminateSuccessiveDup(cryptogram);
        }
        while(cryptogram.length() != decrypted.length());
        return cryptogram;
    }

    private static String eliminateSuccessiveDup(String subCryptogram) {
        int dupStartIdx = -1;
        char prevChar = ' ';

        for(int i = 0; i < subCryptogram.length(); i++) {
            char curChar = subCryptogram.charAt(i);

            if(curChar == prevChar) continue;
            if(dupStartIdx != i-1) {
                subCryptogram = subCryptogram.substring(0, dupStartIdx) + subCryptogram.substring(i);
                i = dupStartIdx - 1;
                dupStartIdx = i;
                prevChar = ' ';
            } else {
                dupStartIdx = i;
                prevChar = curChar;
            }
        }

        if(dupStartIdx != subCryptogram.length() - 1) subCryptogram = subCryptogram.substring(0, dupStartIdx);
        return subCryptogram;
    }
}
