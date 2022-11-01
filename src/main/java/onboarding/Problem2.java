package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        if (cryptogram == null || cryptogram.length() == 0) {
            return cryptogram;
        }

        char[] cryptograms = cryptogram.toCharArray();
        int i, k = 0;

        for (i = 1; i < cryptograms.length; i++)
        {
            if (cryptograms[i - 1] != cryptograms[i]) {
                cryptograms[k++] = cryptograms[i - 1];
            }
            else {
                while (i < cryptograms.length && cryptograms[i - 1] == cryptograms[i]) {
                    i++;
                }
            }
        }

        if(k!=0){
            cryptograms[k++] = cryptograms[i - 1];
            String newCryptogram = new String(cryptograms).substring(0, k);
            if (k != cryptograms.length) {
                return solution(newCryptogram);
            }
            return newCryptogram;
        }else return "";

    }
}


