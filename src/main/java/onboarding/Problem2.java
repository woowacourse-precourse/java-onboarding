package onboarding;

import java.util.Locale;

public class Problem2 {
    public static String solution(String cryptogram) {
        Cryptogram crypto = new Cryptogram(cryptogram);
        doingZip(crypto);
        return crypto.getCryptogram();
    }

    private static void doingZip(Cryptogram crypto) {
        int idx = crypto.getZipIdx();
        while (idx != -1){
            crypto.zipCryptogram(idx);
            idx = crypto.getZipIdx();
        }
    }

    static class Cryptogram{
        private String cryptogram;

        public Cryptogram(String word) {
            Validator.isValidate(word);
            setCryptogram(word);
        }

        public void zipCryptogram(int start){
            StringBuilder sb = new StringBuilder(cryptogram);
            int end = start + 1;
            while (end < cryptogram.length() && charAt(start) == charAt(end)){
                end++;
            }
            setCryptogram(new String(sb.delete(start, end)));
        }

        public int getZipIdx(){
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)){
                    return i;
                }
            }
            return -1;
        }

        public char charAt(int i){
            return cryptogram.charAt(i);
        }

        public String getCryptogram() {
            return cryptogram;
        }

        public void setCryptogram(String cryptogram) {
            this.cryptogram = cryptogram;
        }
    }

    static class Validator{

        public static boolean isValidate(String cryptogram){
            try {
                isCorrectSize(cryptogram);
                isOnlyLowerCase(cryptogram);
            } catch (Exception error) {
                return false;
            }
            return true;
        }

        private static void isCorrectSize(String str){
            if (str.length() < 1 || str.length() > 1000){
                throw new IllegalArgumentException("is not correct size");
            }
        }

        private static void isOnlyLowerCase(String str){
            String diff = str.toLowerCase();
            if (!str.equals(diff)){
                throw new IllegalArgumentException("is not only lower case");
            }
        }
    }
}

