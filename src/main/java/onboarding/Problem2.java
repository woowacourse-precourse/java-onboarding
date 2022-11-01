package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(true) {
            boolean[] duplicates = checkDuplicate(cryptogram);
            String newCryptogram = delDuplicate(duplicates, cryptogram);

            if (newCryptogram.equals(cryptogram) || cryptogram.length()==0) {
                break;
            }
            cryptogram = newCryptogram;
        }
        return cryptogram;
    }
    private static boolean[] checkDuplicate(String cryptogram) {
        boolean duplicates[] = new boolean[cryptogram.length()];

        for (int i=0; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i)==cryptogram.charAt(i+1)) {
                duplicates[i] = true;
                duplicates[i+1] = true;
            }
        }
        return duplicates;
    }

    private static String delDuplicate(boolean[] duplicates, String cryptogram) {
        String newCryptogram = "";

        for (int i=0; i<duplicates.length; i++) {
            if (!duplicates[i]) {
                newCryptogram+=cryptogram.charAt(i);
            }
        }
        return newCryptogram;
    }
}
